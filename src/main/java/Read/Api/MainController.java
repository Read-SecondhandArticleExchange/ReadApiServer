package Read.Api;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import Read.Domain.Book.Book;
import Read.Domain.Main.MainService;
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
}
