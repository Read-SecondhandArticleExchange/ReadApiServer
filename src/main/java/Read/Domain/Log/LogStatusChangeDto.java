package Read.Domain.Log;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by seungki on 2017-07-25.
 */
@Getter
@Setter
@AllArgsConstructor
public class LogStatusChangeDto {
    long userId;
    String bookId;
    long presentStatus;
    long changeStatus;
}
