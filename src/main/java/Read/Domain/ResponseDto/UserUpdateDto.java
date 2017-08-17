package Read.Domain.ResponseDto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by iljun on 2017-08-17.
 */
@Getter
@Setter
@Builder
public class UserUpdateDto {

    private Long userId;
    private String name;
    private String profileUrl;
    private String phoneNumber;
    private String address;
    private String detailAddress;
    private Double latitude;
    private Double longitude;
    private Long postCode;

    public static UserUpdateDto of(MyInfoDto myInfoDto,Double latitude, Double longitude){
        return UserUpdateDto.builder()
                .userId(myInfoDto.getUserId())
                .name(myInfoDto.getName())
                .profileUrl(myInfoDto.getProfileUrl())
                .phoneNumber(myInfoDto.getPhoneNumber())
                .address(myInfoDto.getAddress())
                .detailAddress(myInfoDto.getDetailAddress())
                .postCode(myInfoDto.getPostCode())
                .latitude(latitude)
                .longitude(longitude)
                .build();
    }
}
