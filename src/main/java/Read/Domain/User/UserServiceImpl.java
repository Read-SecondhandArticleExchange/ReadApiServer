package Read.Domain.User;

import Read.Domain.Log.LogMapper;
import Read.Domain.ResponseDto.RequestUser;
import Read.Domain.ResponseDto.ResponseDto;
import Read.Domain.ResponseDto.UserConfirmDto;
import Read.Domain.ResponseDto.UserResponseDto;
import Read.GeoCoding;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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
    private GeoCoding geoCoding;

    @Autowired
    private  LogMapper logMapper;

    @Override
    public List<User> selectAll(){
        return userMapper.selectAll();
    }

    @Transactional(readOnly = true)
    @Override
    public UserResponseDto searchUser(Long userId){
        return UserResponseDto.of(MyPageDto.of(userMapper.selectById(userId)),logMapper.selectByUser(userId));
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
    public void AddressUpdate(Long userId,String address,Long postCode, String detailAddress) throws Exception{
        Float[] cords = geoCoding.geoCoding(address+detailAddress);
        userMapper.updateAddress(userId, address,(double)cords[0],(double)cords[1],postCode, detailAddress);
    }
    @Transactional(readOnly = true,propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public UserConfirmDto confirmUser(UserConfirmRequestDto userConfirmRequestDto){
        User user = userMapper.confirmId(userConfirmRequestDto.getKakaoId());
        if(user==null){
            userMapper.firstLogin(userConfirmRequestDto);
            return UserConfirmDto.ofSuccess("0");
        }else{
            if(!user.getNickName().equals(userConfirmRequestDto.getProfileName())||!user.getProfileUrl().equals(userConfirmRequestDto.getProfileUrl())){
                userMapper.updateProfileAndNickName(userConfirmRequestDto);
            }
            return user.getAddress()==null ? UserConfirmDto.ofSuccess("0"):UserConfirmDto.ofSuccess("1");
        }
    }

    @Transactional(readOnly = true,propagation = Propagation.REQUIRED)
    @Override
    public ResponseDto signUpUser(UserCreateDto userCreateDto) throws Exception{
        Float [] cords=geoCoding.geoCoding(userCreateDto.getAddress());
        User user = new User();
        user.setAddress(userCreateDto.getAddress());
        user.setUserName(userCreateDto.getUserName());
        user.setLatitude((double)cords[0]);
        user.setLongitude((double)cords[1]);
        user.setPhoneNumber(userCreateDto.getPhoneNumber());
        user.setUserId(userCreateDto.getKakaoId());
        user.setDetailAddress(userCreateDto.getDetailAddress());
        user.setPostCode(userCreateDto.getPostCode());
        userMapper.userCreate(user);
        return ResponseDto.ofSuccess("SUCCESS");

    }

    @Override
    public RequestUser requestUser(Long userId){
        return userMapper.requestUser(userId);
    }

    @Override
    public void update(Long userId, String name, String address, String phoneNumber, Long postCode, String detailAddress) throws Exception{
            Float [] cords = geoCoding.geoCoding(address+detailAddress);
            userMapper.update(userId, name, address, phoneNumber,(double)cords[0],(double)cords[1],postCode,detailAddress);
    }
}
