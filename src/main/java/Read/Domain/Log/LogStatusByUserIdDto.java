package Read.Domain.Log;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by iljun on 2017-07-24.
 */
@Getter
@Setter
public class LogStatusByUserIdDto {
    int virtualBook;
    int holdBook;
    int shareBook;
    int sendBook;
    int requestBook;
    int receiveBool;
}
