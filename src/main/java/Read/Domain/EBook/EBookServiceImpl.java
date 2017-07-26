package Read.Domain.EBook;

import Read.Domain.Book.BookApi;
import Read.Domain.ResponseDto.ApiInfo;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by iljun on 2017-07-17.
 */
@Service("EBookService")
@Slf4j
public class EBookServiceImpl implements EBookService{

    private static final Logger logger = LoggerFactory.getLogger(EBookServiceImpl.class);

    @Autowired
    private ApiInfo apiInfo;

    @Autowired
    private RestTemplate restTemplate;

    public EBook search(String content){
        StringBuilder url = new StringBuilder();
        url.append(apiInfo.getUrl()).append("apiKey=").append(apiInfo.getKey());
        url.append("&q=").append(content);
        url.append("&searchType=title").append("&sort=accu");
        url.append("&output=json");
        EBook list = restTemplate.getForObject(url.toString(),EBook.class);

        return list;
    }

}
