package Read.Domain.HoldUser;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by iljun on 2017-07-17.
 */
@Getter
@Setter
@Builder
public class HoldUser {
    private String nickName;
    private Long userId;
}
