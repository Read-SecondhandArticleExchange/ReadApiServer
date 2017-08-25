package Read.Domain.Book;

import Read.Domain.EBook.*;
import Read.Domain.Log.Log;
import Read.Domain.Log.LogService;
import Read.Domain.ResponseDto.BookResponseDto;
import Read.Domain.ResponseDto.RequestBookDto;
import Read.Domain.ResponseDto.RequestBookDtoV2;
import Read.Domain.User.User;
import Read.Domain.User.UserService;
import Read.GeoCoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iljun on 2017-07-13.
 */
@Service("BookService")
public class BookServiceImpl implements BookService{

    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private EBookService eBookService;

    @Autowired
    private LogService logService;

    @Autowired
    private UserService userService;

    @Autowired
    private GeoCoding geoCoding;

    @Override
    public List<Book> selectAll(){
        return bookMapper.selectAll();
    }

    @Override
    public EBook search(String content){
        return eBookService.search(content);
    }

    @Override
    @Transactional(readOnly = true)
    public void insert(String isbn,Long userId) throws Exception{
        User user = userService.findOne(userId);
        Float[] cords = geoCoding.geoCoding(user.getAddress());
        InsertDto dto = InsertDto.of(userId,eBookService.search(isbn).getChannel().getItem().get(0),(double)cords[0],(double)cords[1]);
        bookMapper.insert(dto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RequestBookDtoV2> requestSearch(String content, Long userId){
        List<RequestBookDto> list = bookMapper.requestBook(content);
        List<RequestBookDtoV2> list2 = new ArrayList();
        for(int i=0; i<list.size(); i++) {
            list2.add(RequestBookDtoV2.of(list.get(i), bookMapper.myRequestBookCount(list.get(i).getIsbn(), userId)));
        }
        return list2;
    }

    @Override
    public DetailBookInfo detailBook(String bookId){
        return bookMapper.detailBook(bookId);
    }

    @Override
    @Transactional(readOnly = true)
    public String request(String isbn, Long userId){
        Log log = logService.selectByIsbn(isbn);
        User user = userService.findOne(userId);
        //mapper 에서 book_point를 매핑 못해줘서 bookpoint null이 계속 나옴
        // UserMapper selectById 이 부분 수정 함
        if(user.getBookPoint()==0){
            return "포인트 부족";}
        logService.updateByRequest(log);
        logService.insert(log.getBookId(),user);
        return "성공";
    }
}
