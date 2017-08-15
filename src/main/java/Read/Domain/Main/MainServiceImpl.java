package Read.Domain.Main;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Read.Domain.Book.Book;

@Service
public class MainServiceImpl implements MainService{
	
	@Autowired
	MainMapper mainMapper;

	@Override
	public Summary getSummary() {
		return mainMapper.getSummary();
	}

	@Override
	public ArrayList<Book> getRecentBookList() {
		return mainMapper.getRecentBookList();
	}

}
