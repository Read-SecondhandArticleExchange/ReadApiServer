package Read.Domain.Book;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by iljun on 2017-08-01.
 */
@Getter
@Setter
public class DetailBookInfo {

    private String bookId;
    private String title;
    private String coverUrl;
    private String publisher;
    private String author;
    private String publication;
}
