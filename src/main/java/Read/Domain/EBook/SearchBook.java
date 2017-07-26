package Read.Domain.EBook;

import Read.Domain.HoldUser.HoldUser;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by iljun on 2017-07-17.
 */
@Getter
@Setter
@Builder
public class SearchBook {
    private String auth;
    private String category;
    private String cover_l_url;
    private String cover_s_url;
    private String description;
    private String isbn;
    private String pub_nm;
    private String title;
    private String translator;
    private List<HoldUser> holdUsers;

    public static SearchBook of(Item ebook, List<HoldUser> holdUsers){
        return SearchBook.builder()
                .auth(ebook.getAuthor())
                .category(ebook.getCategory())
                .cover_l_url(ebook.getCover_l_url())
                .cover_s_url(ebook.getCover_s_url())
                .description(ebook.getDescription())
                .isbn(ebook.getIsbn())
                .pub_nm(ebook.getPub_nm())
                .title(ebook.getTitle())
                .translator(ebook.getTranslator())
                .holdUsers(holdUsers)
                .build();
    }
}
