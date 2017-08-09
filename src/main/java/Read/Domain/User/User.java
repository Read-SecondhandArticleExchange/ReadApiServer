package Read.Domain.User;

import lombok.*;

/**
 * Created by iljun on 2017-07-06.
 */
@Getter
@Setter
@Data
public class User {
    private Long userId;
    private String nickName;
    private String profileUrl;
    private Long submitCount;
    private Long takeCount;
    private Long ownCount;
    private Long bookPoint;
    private Double latitude;
    private Double longitude;
    private String address;
    private String phoneNumber;
    private String userName;
    private Long postCode;
    private String detailAddress;
}
