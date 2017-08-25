package Read.Api;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import Read.Domain.Book.Book;
import Read.Domain.Main.MainService;
import Read.Domain.Main.ResultMailSend;
import Read.Domain.Main.Summary;

/**
 * Created by seungki on 2017-08-12.
 */
@RequestMapping(value = "/")
@Controller
public class MainController {
	@Autowired
	MainService mainService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView Home() {
		ModelAndView mav = new ModelAndView();
		Summary summary = mainService.getSummary();
		ArrayList<Book> bookList = mainService.getRecentBookList();
		for (Book book : bookList) {
			System.out.println(book.toString());
		}
		mav.addObject("summary", summary);
		mav.addObject("bookList", bookList);
		mav.setViewName("main");
		return mav;
	}

	@RequestMapping(value = "/mailSend", method = RequestMethod.POST)
	public @ResponseBody ResultMailSend mailSend(HttpServletRequest req) {
		Enumeration params = req.getParameterNames();

		while (params.hasMoreElements()) {
			String names = (String) params.nextElement();
			System.out.println(names + " : " + req.getParameter(names));
		}
		
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		String contents = req.getParameter("contents");
		
		ResultMailSend resultVo = new ResultMailSend();
		
		try {
			mainService.sendMail(address, name, phone, contents);
			resultVo.setResultCode("1");
			resultVo.setMsg("good");
		} catch (Exception e) {
			resultVo.setResultCode("0");
			resultVo.setMsg("bad");
			e.printStackTrace();
		}
		
		return resultVo;
	}
}
