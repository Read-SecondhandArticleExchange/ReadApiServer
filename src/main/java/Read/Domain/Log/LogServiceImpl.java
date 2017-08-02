package Read.Domain.Log;

import Read.Domain.Book.Book;
import Read.Domain.Book.BookService;
import Read.Domain.HoldUser.HoldUser;
import Read.Domain.ResponseDto.*;
import Read.Domain.User.User;
import Read.Domain.User.UserCreateDto;
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
    @Override
    public ResponseDto statusChange(LogStatusChangeDto logStatusChangeDto){
        //보유중에서 공유중
        if((logStatusChangeDto.getPresentStatus()==1)&&(logStatusChangeDto.getChangeStatus()==2)){
            logMapper.changeStatus(logStatusChangeDto);
            return ResponseDto.ofSuccess("SUCCESS");
        }
        //공유중에서 보유중
        if((logStatusChangeDto.getChangeStatus()==1 && logStatusChangeDto.getPresentStatus()==2)){
            long status = logMapper.countByBookId(logStatusChangeDto.getBookId());
            if(status>1){
                return ResponseDto.ofFail("누군가 요청중");
            }
            long temp=logStatusChangeDto.getChangeStatus();
            LogStatusChangeDto logStatusChangeDto1 = new LogStatusChangeDto(logStatusChangeDto.getUserId(),logStatusChangeDto.getBookId(),logStatusChangeDto.getChangeStatus(),logStatusChangeDto.getPresentStatus());
            logMapper.changeStatus(logStatusChangeDto1);
            return ResponseDto.ofSuccess("SUCCESS");
        }
        //보낼책->보낸책 요청한책->받을책
        if(logStatusChangeDto.getPresentStatus()==5 && logStatusChangeDto.getChangeStatus()==3){
            logMapper.sendStatus(logStatusChangeDto);
            logMapper.receiveStatus(logStatusChangeDto);
            return ResponseDto.ofSuccess("SUCCESS");
        }
        //받을책 -->보유중
        if(logStatusChangeDto.getPresentStatus()==4 && logStatusChangeDto.getChangeStatus()==1){
            logMapper.checkSendStatus(logStatusChangeDto);
            logMapper.pointUp(logStatusChangeDto.getBookId());
            return ResponseDto.ofSuccess("SUCCESS");
        }
        //요청한책 취소
        if(logStatusChangeDto.getPresentStatus()==6 && logStatusChangeDto.getChangeStatus()==0){
            logMapper.deleteStaus(logStatusChangeDto);
            logMapper.requestToShareStatus(logStatusChangeDto);
            return ResponseDto.ofSuccess("SUCCESS");
        }
        return ResponseDto.ofFail("FAIL");
    }
    @Override
    public UserInformationResponseDto informationUser(String bookid){
            return UserInformationResponseDto.of(logMapper.userInformation(bookid));
    }
}
