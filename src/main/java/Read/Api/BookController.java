package Read.Api;

import Read.Domain.Book.Book;
import Read.Domain.EBook.EBook;
import Read.Domain.ResponseDto.*;
import Read.Domain.Book.BookService;
import Read.Domain.User.User;
import Read.Domain.User.UserService;
import io.swagger.annotations.*;
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
@RequestMapping(value = "api/v1/book")
@Api(value="Book APi" ,description = "Book Api" ,basePath="/api/v1/book")
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @ApiOperation(value="테스트용 api" ,notes="테스트용 api")
    @RequestMapping(value = "selectAll", produces = "application/json;charset=UTF-8", method= RequestMethod.GET)
    public @ResponseBody List<Book> selectAll(){
        return bookService.selectAll();
    }

    @ApiOperation(value="책 검색 api", notes = "책 검색 api")
    @RequestMapping(value= "search", method=RequestMethod.GET)
    public @ResponseBody SearchResponseDto search(
            @ApiParam(value="검색 내용")
            @RequestParam("content")String content){
        logger.info("BookController search Method");
        try{
            return SearchResponseDto.of(bookService.search(content));
        }catch(Exception e){
            logger.error("BookController search Method error" ,e.getMessage());
        }
        return null;
    }

    @ApiOperation(value="책 등록 api", notes="책 등록 api")
    @RequestMapping(value="insert", method=RequestMethod.POST)
    public @ResponseBody BookResponseDto insert(
            @ApiParam(value="책 isbn")
            @RequestParam("isbn") String isbn,
            @ApiParam(value="유저 아이디")
            @RequestParam("userId") Long userId,
            @ApiParam(value="주소 정보 저장 유무")
            @RequestParam(value = "check", defaultValue = "false") boolean check,
            @ApiParam("address")
            @RequestParam(value = "address", required=false) String address ,
            @ApiParam("postCode")
            @RequestParam(value = "postCode",required=false) Long postCode,
            @ApiParam("detailAddress")
            @RequestParam(value = "detailAddress",required=false) String detailAddress){
        logger.info("BookController insert Method");
        try{
            if(check)
                userService.AddressUpdate(userId,address,postCode,detailAddress);
            bookService.insert(isbn,userId);
            return BookResponseDto.of("책 등록 성공",userService.findOne(userId));
        }catch(Exception e){
            logger.error("book insert fail : " + e.getMessage());
        }
        return BookResponseDto.ofEmpty("책 등록 실패");
    }


    @ApiOperation(value="책 요청 검색 api" ,notes= "책 요청 검색 api")
    @RequestMapping(value="bookRequest", method = RequestMethod.GET)
    public List<RequestBookDtoV2> bookRequest(
            @ApiParam(value="검색 내용")
            @RequestParam("content") String content,
            @ApiParam(value="userId")
            @RequestParam("userId") Long userId){
        try{
            return bookService.requestSearch(content,userId);
        }catch(Exception e){
            logger.error("/api/v1/book/bookRequest error : " + e.getMessage());
        }
            return Collections.emptyList();
    }

    @ApiOperation(value = "책 요청", notes = "책 요청")
    @RequestMapping(value = "request", method = RequestMethod.GET)
    public RequestUser request(
            @ApiParam("유저아이디")
            @RequestParam("userId") Long userId){
        try{
            return userService.requestUser(userId);
        }catch(Exception e){
            logger.error("/api/v1/book/request GET : " + e.getMessage());
        }
        return null;
    }

    @ApiOperation(value = "책 요청", notes = "책 요청")
    @RequestMapping(value = "request", method = RequestMethod.POST)
    public ResponseDto request(
            @ApiParam(value="유저 아이디")
            @RequestParam("userId") Long userId,
            @ApiParam(value = "요청책 isbn")
            @RequestParam("isbn") String isbn,
            @ApiParam(value = "주소저장 여부")
            @RequestParam("check") boolean check,
            @ApiParam(value = "주소")
            @RequestParam("address") String address,
            @ApiParam(value="이름")
            @RequestParam("name") String name,
            @ApiParam(value="핸드폰번호")
            @RequestParam("phoneNumber") String phoneNumber,
            @ApiParam(value = "postCode")
            @RequestParam("postCode") Long postCode,
            @ApiParam(value = "detailAddress")
            @RequestParam("detailAddress") String detailAddress){
        try{
            if(check==true)
                userService.update(userId, name,address,phoneNumber,postCode,detailAddress);
            return ResponseDto.ofSuccess(bookService.request(isbn,userId));
        }catch(Exception e){
            logger.error("/api/v1/book/request error : " + e.getMessage());
        }
        return ResponseDto.ofFail("실패");

    }
}
