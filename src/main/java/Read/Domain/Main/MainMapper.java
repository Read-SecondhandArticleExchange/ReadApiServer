package Read.Domain.Main;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import Read.Domain.Book.Book;

@Repository("MainMapper")
public interface MainMapper {

	Summary getSummary();

	ArrayList<Book> getRecentBookList();

}
