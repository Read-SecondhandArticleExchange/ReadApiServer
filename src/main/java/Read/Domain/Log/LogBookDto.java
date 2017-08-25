package Read.Domain.Log;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by seungki on 2017-08-15.
 */
@Getter
@Setter
public class LogBookDto {

    private String bookId;
    private String author;
    private String translator;
    private String publisher;
    private String title;
    private String category;
    private String coverUrl;
    private String isbn;
    private String publication;
    private Long status;
}
