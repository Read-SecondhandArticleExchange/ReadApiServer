package Read.Domain.EBook;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Created by iljun on 2017-07-19.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Channel {
    private String description;
    private String generator;
    private String lastBuildDate;
    private String link;
    private Integer pageCount;
    private Integer result;
    private String title;
    private Integer totalCount;
    private List<Item> item;
}
