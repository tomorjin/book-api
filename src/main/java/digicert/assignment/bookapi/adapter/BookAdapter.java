package digicert.assignment.bookapi.adapter;

import digicert.assignment.bookapi.model.Book;
import digicert.assignment.bookapi.model.dto.BookDto;
import org.springframework.stereotype.Component;

@Component
public class BookAdapter {

    public Book toBook(BookDto dto) {
        return new Book(dto.getIsbn(), dto.getTitle(), dto.getAuthor());
    }

    public BookDto toBookDto(Book book) {
        return new BookDto(book.getIsbn(), book.getTitle(), book.getAuthor());
    }
}
