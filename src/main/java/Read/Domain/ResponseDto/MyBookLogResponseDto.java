package Read.Domain.ResponseDto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by iljun on 2017-07-25.
 */
@Getter
@Setter
public class MyBookLogResponseDto {
    private String author;
    private String bookId;
    private String coverUrl;
    private String title;
    private String publisher;
    private String publication;
    private String category;
    private Long status;
    private Long totalCount;
    private Long mySequence;
}
