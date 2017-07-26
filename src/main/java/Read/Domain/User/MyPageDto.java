package Read.Domain.User;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by iljun on 2017-07-18.
 */
@Getter
@Setter
@Builder
public class MyPageDto {
    private Long userId;
    private String nickName;
    private Long submitCount;
    private Long takeCount;
    private Long ownCount;
    private Long bookPoint;
    private String address;

    public static MyPageDto of(User user){
        return MyPageDto.builder()
                .userId(user.getUserId())
                .nickName(user.getNickName())
                .submitCount(user.getSubmitCount())
                .takeCount(user.getTakeCount())
                .ownCount(user.getOwnCount())
                .bookPoint(user.getBookPoint())
                .address(user.getAddress())
                .build();
    }
}
