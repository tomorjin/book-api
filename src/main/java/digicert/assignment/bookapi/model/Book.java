package digicert.assignment.bookapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document
public class Book {
    @Id
    private String isbn;
    private String title;
    private String author;

}
