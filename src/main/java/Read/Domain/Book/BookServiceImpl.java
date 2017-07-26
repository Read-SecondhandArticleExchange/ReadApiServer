package Read.Domain.Book;

import Read.Domain.EBook.*;
import Read.Domain.Log.LogService;
import Read.Domain.ResponseDto.BookResponseDto;
import Read.Domain.ResponseDto.RequestBookDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public List<Book> selectAll(){
        return bookMapper.selectAll();
    }

    @Override
    public EBook search(String content){
        return eBookService.search(content);
    }

    @Override
    public void insert(String isbn,Long userId){
        InsertDto dto = InsertDto.of(userId,eBookService.search(isbn).getChannel().getItem().get(0),0.0,0.0);
        bookMapper.insert(dto);
    }

    @Override
    public List<RequestBookDto> requestSearch(String content){

        return null;
    }
}
