package com.sysm.catalog.application.genre.save;

import com.sysm.catalog.application.UseCase;
import com.sysm.catalog.domain.exceptions.DomainException;
import com.sysm.catalog.domain.genre.Genre;
import com.sysm.catalog.domain.genre.GenreGateway;
import com.sysm.catalog.domain.validation.Error;

import java.time.Instant;
import java.util.Objects;
import java.util.Set;

public class SaveGenreUseCase extends UseCase<SaveGenreUseCase.Input, SaveGenreUseCase.Output> {

    private final GenreGateway genreGateway;

    public SaveGenreUseCase(final GenreGateway genreGateway) {
        this.genreGateway = Objects.requireNonNull(genreGateway);
    }

    @Override
    public Output execute(final Input input) {
        if (input == null) {
            throw DomainException.with(new Error("'SaveGenreUseCase.Input' cannot be null"));
        }

        final var aGenre = Genre.with(
                input.id(),
                input.name(),
                input.active(),
                input.categories(),
                input.createdAt(),
                input.updatedAt(),
                input.deletedAt()
        );

        this.genreGateway.save(aGenre);

        return new Output(aGenre.id());
    }

    public record Input(
            String id,
            String name,
            boolean active,
            Set<String> categories,
            Instant createdAt,
            Instant updatedAt,
            Instant deletedAt
    ) {

    }

    public record Output(String id) {

    }
}
