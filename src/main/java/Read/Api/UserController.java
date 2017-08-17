package Read.Api;

import Read.Domain.ResponseDto.MyInfoDto;
import Read.Domain.ResponseDto.ResponseDto;
import Read.Domain.ResponseDto.UserConfirmDto;
import Read.Domain.ResponseDto.UserResponseDto;
import Read.Domain.User.AddressDto;
import Read.Domain.User.User;
import Read.Domain.User.UserConfirmRequestDto;
import Read.Domain.User.UserCreateDto;
import Read.Domain.User.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by iljun on 2017-07-13.
 */
@RestController
@RequestMapping(value = "api/v1/user")
@Api(value="User APi" ,description = "User Api" ,basePath="/api/v1/user")
@Slf4j
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "test", method= RequestMethod.GET)
    @ApiOperation(value="테스트용 api" ,notes="테스트용 api")
    public List<User> selectAll(){
        return userService.selectAll();
    }

    @RequestMapping(value=" search" , method = RequestMethod.GET)
    @ApiOperation(value = "개인 정보 조회", notes="개인 개인정보 조회 api")
    public @ResponseBody UserResponseDto search(
            @ApiParam(value = "유저 id")
            @RequestParam("userId") Long userId){
        try{
            return userService.searchUser(userId);
        }catch(Exception e){
            log.error("api/v1/user/search error : " + e.getMessage());
        }
        return UserResponseDto.ofEmpty();
    }


    @RequestMapping(value = "userAddressSearch", method = RequestMethod.GET)
    @ApiOperation(value = "유저 주소 검색", notes = "유저 주소 검색")
    public @ResponseBody AddressDto userAddressSearch(
                @ApiParam(value = "유저 id")
                @RequestParam("userId") Long userId) {
        try {
            return userService.selectByAddress(userId);
        } catch (Exception e) {
            logger.error("/api/v1/user/userAddressSearch error : " + e.getMessage());
        }
        return null;
    }

    @RequestMapping(value = "confirm",method=RequestMethod.POST)
    @ApiOperation(value="사용자 가입 여부 확인",notes="회원이 등록되어있는지 확인 하기 위한 api(결과 status가 0이면 주소랑 이름등 입력해야한다.) ")
    public @ResponseBody
    UserConfirmDto confirm(@ApiParam(value = "kakao id 값,프로필url,프로필명") @RequestBody UserConfirmRequestDto userConfirmRequestDto){
                try {
                    return userService.confirmUser(userConfirmRequestDto);
                }catch (Exception e){
                    logger.info("api/v1/user/confirm error :"+e.getMessage());
                    return UserConfirmDto.ofFail(e.getMessage());
                }
    }

    @RequestMapping(value = "create",method = RequestMethod.POST)
    @ApiOperation(value = "사용자Id값(kakaoId를 의미),사용자 이름,핸드폰번호,주소 저장",notes ="회원 정보 등록 api")
    public ResponseDto signup(@ApiParam(value = "이름,핸드폰 번호,주소") @RequestBody UserCreateDto userCreateDto){
        try{
            return userService.signUpUser(userCreateDto);
        }catch (Exception e){
            logger.info("api/v1/user/signUp error:"+e.getMessage());
            return ResponseDto.ofFail(e.getMessage());
        }

    }

    @RequestMapping(value = "myInfo", method = RequestMethod.GET)
    @ApiOperation(value = "내 정보", notes = "내 정보")
    public MyInfoDto myInfo(@ApiParam(value = "유저 id")
                            @RequestParam("userId") Long userId){
        try{
            return userService.myInfo(userId);
        }catch(Exception e){
            logger.error("api/v1/user/myInfo error : " + e.getMessage());
        }
        return null;
    }

    @RequestMapping(value = "myInfo", method = RequestMethod.POST)
    @ApiOperation(value = "내 정보 수정", notes = "내 정보 수정")
    public ResponseDto myInfo(@ApiParam(value = "myInfoDto")
                              @RequestBody MyInfoDto myInfoDto){
        try{
            userService.myInfoUpdate(myInfoDto);
            return ResponseDto.ofSuccess("정보 수정 성공");
        }catch(Exception e){
            logger.error("api/v1/user/myInfo error : " + e.getMessage());
        }
        return ResponseDto.ofFail("정보 수정 실패");
    }
}
