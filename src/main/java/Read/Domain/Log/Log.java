package Read.Domain.Log;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by iljun on 2017-07-13.
 */
@Getter
@Setter
@Data
public class Log {
    private String bookId;
    private Long userId;
    private Long status;
    private String address;
    private Double latitude;
    private Double longitude;
    private String latest;
    private Long sequence;
}
