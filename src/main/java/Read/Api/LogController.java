package Read.Api;

import Read.Domain.Book.Book;
import Read.Domain.Log.Log;
import Read.Domain.Log.LogStatusByUserIdDto;
import Read.Domain.Log.LogService;
import Read.Domain.Log.LogStatusChangeDto;
import Read.Domain.ResponseDto.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * Created by iljun on 2017-07-13.
 */
@RestController
@RequestMapping(value ="api/v1/log")
@Api(value="Log APi" ,description = "Log Api" ,basePath="/api/v1/Log")
@Slf4j
public class LogController {

    private static final Logger logger = LoggerFactory.getLogger(LogController.class);

    @Autowired
    private LogService logService;


    @ApiOperation(value="리드박스 전체보기" ,notes="리드박스 전체보기")
    @RequestMapping(value="readbook", method= RequestMethod.GET)
    public ReadBookResponseDto myreadbook(@RequestParam(value = "userId") Long id) {
        try {
            return logService.selectByUser(id);
        }catch (Exception e){
            logger.info("Log Controller search error"+e.getMessage());
        }
        return ReadBookResponseDto.ofEmpty();
    }

    @ApiOperation(value="상태별로 보기 api" ,notes="상태별로 보기 api")
    @RequestMapping(value="myreadbook/status", method= RequestMethod.GET)
    public ReadBookResponseDto bookstatus(@RequestParam(value = "userId") Long id, @RequestParam(value = "status") Long status) {
        try {
            return logService.selectUserAndStatus(id,status);
        }catch (Exception e){
            logger.info("Log Controller status error"+e.getMessage());
        }
        return ReadBookResponseDto.ofEmpty();
    }

    @ApiOperation(value = "내 북로그", notes= "내 북로그")
    @RequestMapping(value ="myBookLog", method = RequestMethod.GET)
    public List<MyBookLogResponseDto> myBookLog(@ApiParam(value = "유저아이디")
                     @RequestParam("userId") Long userId){
        try{
            return logService.myBookLog(userId);
        }catch(Exception e){
            logger.error("/api/v1/log/myBookLog error : " + e.getMessage());
        }
        return Collections.emptyList();
    }

    @ApiOperation(value = "상세 북로그", notes = "상세 북로그")
    @RequestMapping(value = "detailBookLog", method = RequestMethod.GET)
    public DetailBookLogDto detailBookLog(
            @ApiParam(value = "유저 아이디")
            @RequestParam("userId") Long userId,
            @ApiParam(value = "책 아이디")
            @RequestParam("bookId") String bookId){
        logger.info("detailBookLog Controller");
        try{
            return logService.detailBookLog(bookId,userId);
        }catch(Exception e){
            logger.error("/api/v1/log/detailBookLog error : " + e.getMessage());
        }
        return null;
    }
    @ApiOperation(value = "리드박스에서 상태변경 api",notes = "상태변경 api")
    @RequestMapping(value = "myreadbox/statuschange",method = RequestMethod.PUT)
    public ResponseDto boxstatusChanege(@ApiParam(value = "책번호,원래 상태번호,바꿀 상태번호") @RequestBody LogStatusChangeDto logStatusChangeDto){
        try{
            return logService.statusChange(logStatusChangeDto);
        }catch (Exception e){
            logger.info(e.getMessage());
            return ResponseDto.ofFail(e.getMessage());
        }
    }
    @ApiOperation(value = "리드박스에서 내 책을 요청한 사람의 주소 보기 정보 보기",notes = "내 책을 요청한 사람 주소정보 api")
    @RequestMapping(value = "myreadbox/information",method = RequestMethod.GET)
    public UserInformationResponseDto boxinformation(@ApiParam(value = "bookId") @RequestParam(value = "bookdId") String bookid){
        try{
            return logService.informationUser(bookid);
        }catch (Exception e){
            logger.info(e.getMessage());
            return UserInformationResponseDto.ofFail(null,e.getMessage());
        }
    }

}
