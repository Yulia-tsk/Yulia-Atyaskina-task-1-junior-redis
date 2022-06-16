package democashingredis.service;
import democashingredis.model.Book;

import java.util.List;

public interface BookService {
    boolean saveBook(Book book);

    List<Book> fetchAllBooks();

    Book fetchBookById(Long id);

    boolean deleteBook(Long id);
}
