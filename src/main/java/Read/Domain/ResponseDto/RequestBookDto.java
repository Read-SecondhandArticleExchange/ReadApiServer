package Read.Domain.ResponseDto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by iljun on 2017-07-25.
 */
@Getter
@Setter
@Builder
public class RequestBookDto {
    private String coverUrl;
    private String title;
    private String publisher;
    private String author;
    private String publication;
    private String isbn;
    private Long requestCount;

}
