package Read.Domain.Log;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by iljun on 2017-08-01.
 */
@Getter
@Setter
public class LogUser {
    private String nickName;
    private String profileUrl;
    private String latest;
}
