package digicert.assignment.bookapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookDto {
    private String isbn;
    private String title;
    private String author;
}
