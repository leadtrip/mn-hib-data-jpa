package example.micronaut.services;

import example.micronaut.commands.BookCreateCommand;
import example.micronaut.commands.BookUpdateCommand;
import example.micronaut.domain.Book;
import example.micronaut.domain.Genre;
import jakarta.inject.Singleton;

import java.util.stream.Collectors;

@Singleton
public class BookTransformer {

    /**
     * Only the Genre IDs are required by hibernate to figure out the join table mappings required so Genre::new is fine.
     */
    public Book fromUpdateCommand(BookUpdateCommand bookUpdateCommand) {
        Book book = new Book();
        book.setId(bookUpdateCommand.getId());
        book.setName(bookUpdateCommand.getName());
        book.setGenres(bookUpdateCommand.getGenres().stream().map(Genre::new).collect(Collectors.toSet()));
        return book;
    }

    public Book fromCreateCommand(BookCreateCommand bookCreateCommand ) {
        Book book = new Book();
        book.setName(bookCreateCommand.getName());
        book.setGenres(bookCreateCommand.getGenres().stream().map(Genre::new).collect(Collectors.toSet()));
        return book;
    }
}
