package Read.Domain.Log;

import Read.Domain.Book.Book;
import Read.Domain.HoldUser.HoldUser;
import Read.Domain.ResponseDto.MyBookLogResponseDto;
import Read.Domain.User.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by iljun on 2017-07-13.
 */
@Repository("LogMapper")
public interface LogMapper {

    LogStatusByUserIdDto LogStatusByUserId(Long id);
    List<Book> selectByUserId(long id);
    List<Book> selectByStatusIdAndUserId(HashMap<String, Long> map);
    List<MyBookLogResponseDto> myBookLog(Long userId);
    Long selectBySequence(@Param("bookId") String bookId, @Param("userId") Long userId);
    List<LogUser> detailBookLogList(String bookId);
    Long countByBookId(String bookId);
    Log selectByIsbn(String isbn);
    void updateByRequest(Log log);
    void insert(@Param("bookId") String bookId, @Param("user") User user,@Param("sequence") Long sequence);
}
