package Read.Domain.User;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by iljun on 2017-07-25.
 */
@Getter
@Setter
public class AddressDto {
    private Long postCode;
    private String address;
    private String detailAddress;

}
