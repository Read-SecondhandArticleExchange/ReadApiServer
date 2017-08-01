package Read.Domain.Book;

import Read.Domain.EBook.*;
import Read.Domain.Log.Log;
import Read.Domain.Log.LogService;
import Read.Domain.ResponseDto.BookResponseDto;
import Read.Domain.ResponseDto.RequestBookDto;
import Read.Domain.User.User;
import Read.Domain.User.UserService;
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
    public void insert(String isbn,Long userId){
        InsertDto dto = InsertDto.of(userId,eBookService.search(isbn).getChannel().getItem().get(0),0.0,0.0);
        bookMapper.insert(dto);
    }

    @Override
    public List<RequestBookDto> requestSearch(String content){
        return bookMapper.requestBook(content);
    }

    @Override
    public DetailBookInfo detailBook(String bookId){
        return bookMapper.detailBook(bookId);
    }

    @Override
    @Transactional(readOnly = true)
    public void request(String isbn, Long userId){
        Log log = logService.selectByIsbn(isbn);
        User user = userService.findOne(userId);
        logService.updateByRequest(log);
        logService.insert(log.getBookId(),user);
    }
}
