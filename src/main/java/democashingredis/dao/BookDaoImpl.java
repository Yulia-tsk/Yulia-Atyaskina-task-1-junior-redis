package democashingredis.dao;
import democashingredis.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    private RedisTemplate redisTemplate;

    private static final String KEY = "BOOK";

    @Override
    public boolean saveBook(Book book) {
        try {
            redisTemplate.opsForHash().put(KEY, book.getId().toString(), book);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }

    }

    @Override
    public List<Book> fetchAllBooks() {
        return redisTemplate.opsForHash().values(KEY);
    }

    @Override
    public Book fetchBookById(Long id) {
        Book book;
        book = (Book) redisTemplate.opsForHash().get(KEY, id.toString());
        return book;
    }

    @Override
    public boolean deleteBook(Long id) {
        try {
            redisTemplate.opsForHash().delete(KEY, id.toString());
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
