package Read.Domain.ResponseDto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by iljun on 2017-08-17.
 */
@Getter
@Setter
public class MyInfoDto {
    private Long userId;
    private String name;
    private String profileUrl;
    private String phoneNumber;
    private String address;
    private String detailAddress;
    private Long postCode;
}
