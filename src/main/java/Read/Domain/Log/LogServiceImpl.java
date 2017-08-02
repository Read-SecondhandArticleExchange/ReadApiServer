package Read.Domain.Log;

import Read.Domain.Book.Book;
import Read.Domain.Book.BookService;
import Read.Domain.HoldUser.HoldUser;
import Read.Domain.ResponseDto.DetailBookLogDto;
import Read.Domain.ResponseDto.MyBookLogResponseDto;
import Read.Domain.ResponseDto.ReadBookResponseDto;
import Read.Domain.User.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by iljun on 2017-07-13.
 */
@Service("LogService")
public class LogServiceImpl implements LogService {

    private final static Logger logger = LoggerFactory.getLogger(LogServiceImpl.class);

    @Autowired
    private LogMapper logMapper;

    @Autowired
    private BookService bookService;

    @Override
    public List<Log> selectAll(){
        return null;
    }

    @Override
    public List<HoldUser> selectByOwnUser(String isbn){
        return null;
    }


    @Override
    public ReadBookResponseDto selectByUser(Long userId){
            return  ReadBookResponseDto.ofSuccess(logMapper.LogStatusByUserId(userId),logMapper.selectByUserId(userId));

    }
    @Override
    @Transactional(readOnly = true)
    public ReadBookResponseDto selectUserAndStatus(long id, long status){
        HashMap<String,Long> map = new HashMap<>();
        map.put("userId",id);
        map.put("status",status);
        return ReadBookResponseDto.ofSuccess(null,logMapper.selectByStatusIdAndUserId(map));
    }

    @Override
    @Transactional(readOnly = true)
    public List<MyBookLogResponseDto> myBookLog(Long userId){
        List<MyBookLogResponseDto> list = logMapper.myBookLog(userId);
        for(int i=0; i<list.size(); i++){
            list.get(i).setMySequence(logMapper.selectBySequence(list.get(i).getBookId(),userId));
        }
        return list;
    }

    @Override
    public DetailBookLogDto detailBookLog(String bookId,Long userId){
        return DetailBookLogDto.of(bookService.detailBook(bookId),logMapper.detailBookLogList(bookId),logMapper.countByBookId(bookId),logMapper.selectBySequence(bookId,userId));
    }

    @Override
    public Log selectByIsbn(String isbn){
        return logMapper.selectByIsbn(isbn);
    }

    @Override
    public void updateByRequest(Log log){
        logMapper.updateByRequest(log);
    }

    @Override
    @Transactional(readOnly = true)
    public void insert(String bookId, User user){
        Long sequence = logMapper.countByBookId(bookId);
        logMapper.insert(bookId,user,sequence+1);
    }
}
