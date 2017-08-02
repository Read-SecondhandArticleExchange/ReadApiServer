package Read.Domain.ErrorLog;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Created by iljun on 2017-08-02.
 */
@Getter
@Setter
@Builder
public class ErrorLog {
    private Long logId;
    private String ip;
    private String url;
    private String body;
    private String queryString;
    private LocalDateTime createAt;

    public static ErrorLog of(String ip, String url, String body, String queryString){
        return ErrorLog.builder()
                .ip(ip)
                .url(url)
                .body(body)
                .queryString(queryString)
                .build();
    }
}
