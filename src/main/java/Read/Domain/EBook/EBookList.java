package Read.Domain.EBook;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by iljun on 2017-07-19.
 */
@Getter
@Setter
public class EBookList {
    private String title;
    private String description;
    private String generator;
    private String link;
    private String lastBuildData;
    private Integer totalCount;
    private Integer result;
    private List<Item> item;
}
