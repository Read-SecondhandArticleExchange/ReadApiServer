package Read.Domain.User;

import Read.Domain.HoldUser.HoldUser;
import Read.Domain.ResponseDto.RequestUser;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by iljun on 2017-07-06.
 */
@Repository("UserMapper")
public interface UserMapper {
    List<User> selectAll();
    User selectById(Long userId);

    AddressDto selectByAddress(Long userId);
    void updateAddress(@Param("userId") Long userId, @Param("address") String address, @Param("latitude") double latitude, @Param("longitude") double longitude, @Param("postCode") Long postCode, @Param("detailAddress") String detailAddress);

    User confirmId(Long userId);
    void firstLogin(UserConfirmRequestDto userConfirmRequestDto);
    void updateProfileAndNickName(UserConfirmRequestDto userConfirmRequestDto);
    void userCreate(User user);

    RequestUser requestUser(Long userId);
    void update(@Param("userId")Long userId, @Param("name") String name, @Param("address") String address, @Param("phoneNumber") String phoneNumber,@Param("latitude") double latitude,@Param("longitude") double longitude,@Param("postCode") Long postCode, @Param("detailAddress") String detailAddress);
}
