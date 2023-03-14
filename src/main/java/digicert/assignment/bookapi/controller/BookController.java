package digicert.assignment.bookapi.controller;

import digicert.assignment.bookapi.exception.EntityNotFoundException;
import digicert.assignment.bookapi.model.dto.BookDto;
import digicert.assignment.bookapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping("{isbn}")
    public BookDto getBook(@PathVariable("isbn") String isbn) throws EntityNotFoundException {
        return service.get(isbn);
    }

    @GetMapping
    public List<BookDto> getAll() {
        return service.getAll();
    }

    @PostMapping
    public BookDto create(@RequestBody BookDto dto) {
        return service.create(dto);
    }

    @PutMapping("{isbn}")
    public BookDto update(@PathVariable("isbn") String isbn, @RequestBody BookDto dto) throws EntityNotFoundException {
        return service.update(isbn, dto);
    }

    @DeleteMapping("{isbn}")
    public void delete(@PathVariable("isbn") String isbn) throws EntityNotFoundException {
        service.delete(isbn);
    }
}
