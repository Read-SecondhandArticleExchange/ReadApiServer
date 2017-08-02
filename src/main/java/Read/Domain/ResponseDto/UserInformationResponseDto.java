package Read.Domain.ResponseDto;


import Read.Domain.Log.Log;
import Read.Domain.User.MyPageDto;
import Read.Domain.User.User;
import Read.Domain.User.UserCreateDto;
import lombok.*;

import java.util.List;

/**
 * Created by seungki on 2017-08-02.
 */
@Getter
@Setter
@Builder
public class UserInformationResponseDto {
    UserCreateDto userCreateDto;
    String message;
    public static UserInformationResponseDto of(UserCreateDto userCreateDto){
        return UserInformationResponseDto.builder()
                .userCreateDto(userCreateDto)
                .message("SUCCESS")
                .build();
    }

    public static UserInformationResponseDto ofFail(UserCreateDto userCreateDto,String message){
        return UserInformationResponseDto.builder()
                .userCreateDto(null)
                .message(message)
                .build();
    }
}
