package Read.Domain.User;

import Read.Domain.ResponseDto.RequestUser;
import Read.Domain.ResponseDto.ResponseDto;
import Read.Domain.ResponseDto.UserResponseDto;

import java.util.List;

/**
 * Created by iljun on 2017-07-13.
 */
public interface UserService {
    List<User> selectAll();
    UserResponseDto searchUser(Long userId);

    User findOne(Long userId);
    AddressDto selectByAddress(Long userId);
    void AddressUpdate(Long userId,String address,Long postCode, String detailAddress) throws Exception;

    ResponseDto confirmUser(UserConfirmRequestDto userConfirmRequestDto);
    ResponseDto signUpUser(UserCreateDto userCreateDto) throws Exception;

    RequestUser requestUser(Long userId);
    void update(Long userId, String name, String address, String phoneNumber,Long postCode, String detailAddress) throws Exception;
}
