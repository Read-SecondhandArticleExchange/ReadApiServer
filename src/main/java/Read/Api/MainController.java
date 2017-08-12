package Read.Api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by seungki on 2017-08-12.
 */
@RequestMapping(value ="/")
@Controller
public class MainController
{
        @RequestMapping(value = "/",method = RequestMethod.GET)
        public String test(){
            return "main";
        }
}
