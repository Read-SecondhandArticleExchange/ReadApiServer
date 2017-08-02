package Read.Domain.Log;

import Read.Domain.Book.Book;
import Read.Domain.HoldUser.HoldUser;
import Read.Domain.ResponseDto.*;
import Read.Domain.User.User;
import Read.Domain.User.UserCreateDto;

import java.util.List;

/**
 * Created by iljun on 2017-07-13.
 */
public interface LogService {
    List<Log> selectAll();
    List<HoldUser> selectByOwnUser(String isbn);
    ReadBookResponseDto selectByUser(Long id);
    ReadBookResponseDto selectUserAndStatus(long id,long status);
    List<MyBookLogResponseDto> myBookLog(Long userId);
    DetailBookLogDto detailBookLog(String bookId, Long userId);
    Log selectByIsbn(String isbn);
    void updateByRequest(Log log);
    void insert(String bookId, User User);
    ResponseDto statusChange(LogStatusChangeDto logStatusChangeDto);
    UserInformationResponseDto informationUser(String bookid);
}
