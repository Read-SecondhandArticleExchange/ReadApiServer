package Read.Domain.ResponseDto;

import Read.Domain.Book.DetailBookInfo;
import Read.Domain.Log.LogUser;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by iljun on 2017-08-01.
 */
@Getter
@Setter
@Builder
public class DetailBookLogDto {
    private DetailBookInfo detailBookInfo;
    private Long totalCount;
    private Long mySequence;
    private List<LogUser> userList;

    public static DetailBookLogDto of(DetailBookInfo detailBookInfo, List<LogUser> userList,Long myCount, Long mySequence){
        return DetailBookLogDto.builder()
                .detailBookInfo(detailBookInfo)
                .userList(userList)
                .totalCount(myCount)
                .mySequence(mySequence)
                .build();
    }
}
