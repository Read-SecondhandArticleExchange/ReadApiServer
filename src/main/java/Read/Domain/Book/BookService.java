package Read.Domain.Book;

import Read.Domain.EBook.EBook;
import Read.Domain.ResponseDto.RequestBookDto;

import java.util.List;

/**
 * Created by iljun on 2017-07-13.
 */
public interface BookService {
    List<Book> selectAll();
    EBook search(String content);
    void insert(String isbn,Long userId);
    List<RequestBookDto> requestSearch(String content);
    DetailBookInfo detailBook(String bookId);
    void request(String isbn, Long userId);
}
