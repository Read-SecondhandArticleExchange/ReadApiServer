package Read.Domain.ErrorLog;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by iljun on 2017-08-02.
 */
@Repository
public interface ErrorLogMapper {
    void save(ErrorLog errorLog);
}
