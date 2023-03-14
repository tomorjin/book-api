package digicert.assignment.bookapi.service;

import digicert.assignment.bookapi.adapter.BookAdapter;
import digicert.assignment.bookapi.exception.EntityNotFoundException;
import digicert.assignment.bookapi.model.Book;
import digicert.assignment.bookapi.model.dto.BookDto;
import digicert.assignment.bookapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    private BookRepository repo;
    @Autowired
    private BookAdapter adapter;

    public BookDto create(BookDto dto) {
        return adapter.toBookDto(repo.save(adapter.toBook(dto)));
    }

    public BookDto get(String isbn) throws EntityNotFoundException {
        Optional<Book> foundBook = repo.findById(isbn);
        if (foundBook.isPresent())
            return adapter.toBookDto(foundBook.get());
        else throw new EntityNotFoundException("Book not found with isbn {" + isbn + "}");
    }

    public List<BookDto> getAll() {
        return repo.findAll().stream().map(book -> adapter.toBookDto(book)).collect(Collectors.toList());
    }

    public BookDto update(String isbn, BookDto dto) throws EntityNotFoundException {
        Optional<Book> foundBook = repo.findById(isbn);
        if (foundBook.isPresent()) {
            Book book = foundBook.get();
            book.setTitle(dto.getTitle());
            book.setAuthor(dto.getAuthor());
            return adapter.toBookDto(repo.save(book));
        } else throw new EntityNotFoundException("Book not found with isbn {" + isbn + "}");
    }

    public void delete(String isbn) throws EntityNotFoundException {
        Optional<Book> foundBook = repo.findById(isbn);
        if (foundBook.isPresent())
            repo.delete(foundBook.get());
        else throw new EntityNotFoundException("Book not found with isbn {" + isbn + "}");
    }

}
