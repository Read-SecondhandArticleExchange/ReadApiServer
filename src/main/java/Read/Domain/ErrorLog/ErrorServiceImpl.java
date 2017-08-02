package Read.Domain.ErrorLog;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by iljun on 2017-08-02.
 */
@Service("ErrorService")
public class ErrorServiceImpl implements ErrorService{

    @Autowired
    private ErrorLogMapper errorLogMapper;

    @Override
    public String logError(Exception e){
        String errorMsg = save(e);
        return errorMsg;
    }

    @Override
    public String save(Exception e){
        String msg=null;
        try{
            HttpServletRequest request = ((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes())).getRequest();

            String ip = request.getHeader("X-FORWARD-FOR");
            String queryString = request.getQueryString();

            if(ip==null)
                ip = request.getRemoteAddr();
            ErrorLog log = ErrorLog.of(ip,getFullURL(request), ExceptionUtils.getStackTrace(e),queryString);

            errorLogMapper.save(log);

            msg = e.getMessage();
        }catch(Exception e2){
            e.printStackTrace(System.out);
            e2.printStackTrace(System.out);
        }
        return msg;
    }

    @Override
    public String getFullURL(HttpServletRequest request) {
        StringBuffer requestURL = request.getRequestURL();
        String queryString = request.getQueryString();
        if (queryString == null)
            return requestURL.toString();
        return requestURL.append('?').append(queryString).toString();
    }
}
