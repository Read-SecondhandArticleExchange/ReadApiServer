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
    private String messgae;

    public static ResponseDto ofSuccess(String message){
        return ResponseDto.builder()
                .status("SUCCESS")
                .messgae(message)
                .build();
    }

    public static ResponseDto ofFail(String message){
        return ResponseDto.builder()
                .status("FAIL")
                .messgae(message)
                .build();
    }
}
