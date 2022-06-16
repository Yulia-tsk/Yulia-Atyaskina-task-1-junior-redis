package democashingredis.service;
import democashingredis.dao.BookDao;
import democashingredis.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookDao bookDao;
    @Override
    public boolean saveBook(Book book) {
        return bookDao.saveBook(book);
    }

    @Override
    public List<Book> fetchAllBooks() {
        return bookDao.fetchAllBooks();
    }

    @Override
    public Book fetchBookById(Long id) {
        return bookDao.fetchBookById(id);
    }

    @Override
    public boolean deleteBook(Long id) {
        return bookDao.deleteBook(id);
    }
}
