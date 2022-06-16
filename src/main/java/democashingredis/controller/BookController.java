package democashingredis.controller;
import democashingredis.model.Book;
import democashingredis.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/books")
    public ResponseEntity<String> saveUser(@RequestBody Book book){
        boolean result = bookService.saveBook(book);
        if(result)
            return ResponseEntity.ok("Book created successfully");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> fetchUser(){
        List<Book> books;
        books = bookService.fetchAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> fetchBookById(@PathVariable("id") Long id){
        Book book;
        book = bookService.fetchBookById(id);
        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") Long id){
        boolean result = bookService.deleteBook(id);
        if(result)
            return ResponseEntity.ok("Book deleted successfully");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
