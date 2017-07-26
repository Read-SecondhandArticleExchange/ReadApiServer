package Read.Domain.ResponseDto;

import Read.Domain.EBook.SearchBook;
import Read.Domain.User.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by iljun on 2017-07-17.
 */
@Getter
@Setter
@Builder
public class BookResponseDto {
    private String message;
    private String address;

    public static BookResponseDto of(String message, User user){
        return BookResponseDto.builder()
                .message(message)
                .address(user.getAddress())
                .build();
    }

    public static BookResponseDto ofEmpty(String message){
        return BookResponseDto.builder()
                .message(message)
                .address(null)
                .build();
    }
}
