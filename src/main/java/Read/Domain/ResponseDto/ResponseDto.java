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
public class ResponseDto {
    private String status;
    private String message;

    public static ResponseDto ofSuccess(String message){
        return ResponseDto.builder()
                .status("SUCCESS")
                .message(message)
                .build();
    }

    public static ResponseDto ofFail(String message){
        return ResponseDto.builder()
                .status("FAIL")
                .message(message)
                .build();
    }

    public static ResponseDto ofError(String message){
        return ResponseDto.builder()
                .status("에러발생 서버개발자 일시켜요")
                .message(message)
                .build();
    }

    public static ResponseDto ofBadRequest(String message){
        return ResponseDto.builder()
                .status("요청 재 확인 요망")
                .message(message)
                .build();
    }
}
