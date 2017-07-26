package Read.Domain.ResponseDto;

import Read.Domain.Log.Log;
import Read.Domain.User.MyPageDto;
import Read.Domain.User.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by iljun on 2017-07-18.
 */
@Getter
@Setter
@Builder
public class UserResponseDto {

    private MyPageDto myPageDto;
    private List<Log> logList;

    public static UserResponseDto of(MyPageDto myPageDto, List<Log> logList){
        return UserResponseDto.builder()
                .myPageDto(myPageDto)
                .logList(logList)
                .build();
    }

    public static UserResponseDto ofEmpty(){
        return UserResponseDto.builder()
                .myPageDto(null)
                .logList(null)
                .build();
    }
}
