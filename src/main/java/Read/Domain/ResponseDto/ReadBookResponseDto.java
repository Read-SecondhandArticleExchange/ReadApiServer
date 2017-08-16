package Read.Domain.ResponseDto;

import Read.Domain.Book.Book;
import Read.Domain.EBook.SearchBook;
import Read.Domain.Log.LogBookDto;
import Read.Domain.Log.LogStatusByUserIdDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by seungki on 2017-07-24.
 */
@Getter
@Setter
@Builder
public class ReadBookResponseDto {
    LogStatusByUserIdDto logStatusByUserIdDto;
    List<LogBookDto> bookList;

    public static ReadBookResponseDto ofSuccess(LogStatusByUserIdDto logStatusByUserIdDto,List bookList){
        return ReadBookResponseDto.builder()
                .logStatusByUserIdDto(logStatusByUserIdDto)
                .bookList(bookList)
                .build();
    }

    public static ReadBookResponseDto ofEmpty(){
        return ReadBookResponseDto.builder()
                .logStatusByUserIdDto(null)
                .bookList(null)
                .build();
    }
}
