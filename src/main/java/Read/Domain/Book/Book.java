package Read.Domain.Book;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by iljun on 2017-07-13.
 */
@Getter
@Setter
@Data
public class Book {

    private String bookId;
    private String author;
    private String translator;
    private String publisher;
    private String title;
    private String category;
    private String coverUrl;
    private String isbn;
    private String publication;
}
