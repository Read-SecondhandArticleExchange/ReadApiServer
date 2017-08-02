package Read.Domain.Book;

import Read.Domain.EBook.EBook;
import Read.Domain.ResponseDto.RequestBookDto;
import Read.Domain.ResponseDto.RequestBookDtoV2;

import java.util.List;

/**
 * Created by iljun on 2017-07-13.
 */
public interface BookService {
    List<Book> selectAll();
    EBook search(String content);
    void insert(String isbn,Long userId) throws Exception;
    List<RequestBookDtoV2> requestSearch(String content, Long userId);
    DetailBookInfo detailBook(String bookId);
    String request(String isbn, Long userId);
}
