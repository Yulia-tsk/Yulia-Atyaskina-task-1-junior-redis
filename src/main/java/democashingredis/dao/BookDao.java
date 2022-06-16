package democashingredis.dao;
import democashingredis.model.Book;

import java.util.List;

public interface BookDao {
    boolean saveBook(Book book);

    List<Book> fetchAllBooks();

    Book fetchBookById(Long id);

    boolean deleteBook(Long id);
}
