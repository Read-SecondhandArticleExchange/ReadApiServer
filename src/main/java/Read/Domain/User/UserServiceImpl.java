package Read.Domain.User;

import Read.Domain.Log.LogMapper;
import Read.Domain.ResponseDto.ResponseDto;
import Read.Domain.ResponseDto.UserResponseDto;
import Read.GeoCoding;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * Created by iljun on 2017-07-13.
 */
@Service("UserService")
@Slf4j
public class UserServiceImpl implements UserService{

    private static final Logger logget = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private LogMapper logMapper;

    @Override
    public List<User> selectAll(){
        return userMapper.selectAll();
    }

    @Transactional(readOnly = true)
    @Override
    public UserResponseDto searchUser(Long userId){
        //return UserResponseDto.of(userMapper.selectById(userId),logMapper.selectByUserId(userId));
        return null;
    }


    @Override
    public User findOne(Long userId){
        return userMapper.selectById(userId);
    }

    @Override
    public AddressDto selectByAddress(Long userId){
        return userMapper.selectByAddress(userId);
    }

    @Override
    public void AddressUpdate(Long userId,String address) {
        userMapper.updateAddress(userId, address);
    }
    @Transactional(readOnly = true)
    @Override
    public ResponseDto confirmUser(UserConfirmRequestDto userConfirmRequestDto){
        User user = userMapper.confirmId(userConfirmRequestDto.getKakaoId());
        if(user==null){
            userMapper.firstLogin(userConfirmRequestDto);
            return ResponseDto.ofSuccess("0");
        }else{
            if(!user.getNickName().equals(userConfirmRequestDto.getProfileName())||!user.getProfileUrl().equals(userConfirmRequestDto.getProfileUrl())){
                userMapper.updateProfileAndNickName(userConfirmRequestDto);
            }
            System.out.println(user);
            return user.getAddress()==null ? ResponseDto.ofSuccess("0"):ResponseDto.ofSuccess("1");
        }
    }

    @Transactional(readOnly = true)
    @Override
    public ResponseDto signUpUser(UserCreateDto userCreateDto) throws Exception{
        GeoCoding geoCoding = new GeoCoding();
        Float [] cords=geoCoding.geoCoding(userCreateDto.getAddress());
        User user = new User();
        user.setAddress(userCreateDto.getAddress());
        user.setUserName(userCreateDto.getUserName());
        user.setLatitude((double)cords[0]);
        user.setLongitude((double)cords[1]);
        user.setPhoneNumber(userCreateDto.getPhoneNumber());
        user.setUserId(userCreateDto.getKakaoId());
        userMapper.userCreate(user);
        return ResponseDto.ofSuccess("SUCCESS");

    }
}
