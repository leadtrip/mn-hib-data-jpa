package example.micronaut.commands;

import io.micronaut.core.annotation.Introspected;

import java.util.Set;
import java.util.UUID;

@Introspected
public class BookUpdateCommand {

    private UUID id;
    private String name;
    private Set<UUID> genres = Set.of();


    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<UUID> getGenres() {
        return genres;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGenres(Set<UUID> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "BookUpdateCommand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genres=" + genres +
                '}';
    }
}
