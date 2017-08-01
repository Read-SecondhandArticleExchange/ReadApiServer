package Read.Domain.Book;

import Read.Domain.EBook.Item;
import Read.Domain.ResponseDto.RequestBookDto;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by iljun on 2017-07-13.
 */
@Repository("BookMapper")
public interface BookMapper {
    List<Book> selectAll();
    void insert(InsertDto insertDto);
    DetailBookInfo detailBook(String bookId);
    List<RequestBookDto> requestBook(String content);
}
