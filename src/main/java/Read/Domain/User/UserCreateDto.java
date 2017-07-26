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
    long kakaoId;
    String userName;
    String phoneNumber;
    String address;
}
