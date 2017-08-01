package Read.Domain.EBook;

import Read.Domain.HoldUser.HoldUser;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by iljun on 2017-07-17.
 */
@Getter
@Setter
public class Item {
    private String author;
    //private String barcode;
    private String category;
    private String cover_l_url;
    private String cover_s_url;
    private String description;
    //private String ebook_barcode;
    //private String etc_author;
    private String isbn;
    //private String isbn13;
    //private String link;
    //private Integer list_price;
    private String pub_date;
    private String pub_nm;
    //private Integer sale_price;
    //private String sale_yn;
    private String title;
    private String status_des;
    private String translator;
}
