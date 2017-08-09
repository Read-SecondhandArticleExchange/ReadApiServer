package Read.Domain.User;

import lombok.Getter;
import lombok.Setter;

import java.beans.Transient;

/**
 * Created by seungki on 2017-07-25.
 */
@Setter
@Getter
public class UserCreateDto {
    private long kakaoId;
    private String userName;
    private String phoneNumber;
    private Long postCode;
    private String address;
    private String detailAddress;
}
