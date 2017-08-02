package Read.Domain.ErrorLog;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by iljun on 2017-08-02.
 */
public interface ErrorService {
    String logError(Exception e);
    String save(Exception e);
    String getFullURL(HttpServletRequest request);
}
