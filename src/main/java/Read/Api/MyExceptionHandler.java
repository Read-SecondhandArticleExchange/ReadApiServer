package Read.Api;

import Read.Domain.ErrorLog.ErrorService;
import Read.Domain.ResponseDto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by iljun on 2017-08-02.
 */
@ControllerAdvice
public class MyExceptionHandler {

    @Autowired
    private ErrorService errorService;

    @ExceptionHandler(value = { Exception.class} )
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)//500
    @ResponseBody
    public ResponseDto handlerException(Exception e){
        String errorMsg = errorService.logError(e);
        return ResponseDto.ofError(errorMsg);
    }

}
