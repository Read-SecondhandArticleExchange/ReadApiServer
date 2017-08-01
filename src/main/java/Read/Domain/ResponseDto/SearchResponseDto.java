package Read.Domain.ResponseDto;

import Read.Domain.EBook.EBook;
import Read.Domain.EBook.Item;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by iljun on 2017-07-31.
 */
@Getter
@Setter
@Builder
public class SearchResponseDto {
    private List<Item> itemList;

    public static SearchResponseDto of(EBook ebook){
        return SearchResponseDto.builder()
                .itemList(ebook.getChannel().getItem())
                .build();
    }
}
