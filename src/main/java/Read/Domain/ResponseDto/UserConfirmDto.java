package Read.Domain.ResponseDto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by seungki on 2017-08-06.
 */
@Getter
@Setter
@Builder
public class UserConfirmDto {
    private String status;
    private String messgae;

    public static UserConfirmDto ofSuccess(String message){
        return UserConfirmDto.builder()
                .status(message)
                .messgae("SUCCESS")
                .build();
    }

    public static UserConfirmDto ofFail(String message){
        return UserConfirmDto.builder()
                .status(message)
                .messgae("FAIL")
                .build();
    }
}
