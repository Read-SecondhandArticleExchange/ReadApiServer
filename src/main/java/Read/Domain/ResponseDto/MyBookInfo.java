package Read.Domain.ResponseDto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by iljun on 2017-07-18.
 */
@Getter
@Setter
@Builder
public class MyBookInfo {
    private String title;
    private String cover_url;
    private Status status;


}
