package Read.Domain.ResponseDto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by iljun on 2017-08-02.
 */
@Getter
@Setter
@Builder
public class RequestBookDtoV2 {
    private String coverUrl;
    private String title;
    private String publisher;
    private String author;
    private String publication;
    private String isbn;
    private Long requestCount;
    private Long myRequestCount;

    public static RequestBookDtoV2 of(RequestBookDto dto, Long myRequestCount){
        return RequestBookDtoV2.builder()
                .coverUrl(dto.getCoverUrl())
                .title(dto.getTitle())
                .publisher(dto.getPublisher())
                .author(dto.getAuthor())
                .publication(dto.getPublication())
                .isbn(dto.getIsbn())
                .requestCount(dto.getRequestCount())
                .myRequestCount(myRequestCount)
                .build();
    }
}
