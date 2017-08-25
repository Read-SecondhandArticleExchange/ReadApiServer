package Read.Domain.Main;

import java.util.ArrayList;

import Read.Domain.Book.Book;

public interface MainService {

	Summary getSummary();

	ArrayList<Book> getRecentBookList();

	void sendMail(String address, String name, String phone, String contents) throws Exception;


}
