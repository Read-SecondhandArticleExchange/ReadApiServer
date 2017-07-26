package Read.Domain.Book;

import Read.Domain.EBook.EBook;
import Read.Domain.EBook.Item;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by iljun on 2017-07-25.
 */
@Getter
@Setter
@Builder
public class InsertDto {
    private Long userId;
    private String author;
    private String translator;
    private String publisher;
    private String title;
    private String category;
    private String isbn;
    private String coverUrl;
    private Double latitude;
    private Double longitude;
    private String publication;

    public static InsertDto of(Long userId, Item item, double latitude, double longitude){
        return InsertDto.builder()
                .userId(userId)
                .author(item.getAuthor())
                .translator(item.getTranslator())
                .publisher(item.getPub_nm())
                .title(item.getTitle())
                .category(item.getCategory())
                .isbn(item.getIsbn())
                .coverUrl(item.getCover_l_url())
                .latitude(latitude)
                .longitude(longitude)
                .publication(item.getPub_date())
                .build();
    }
}
