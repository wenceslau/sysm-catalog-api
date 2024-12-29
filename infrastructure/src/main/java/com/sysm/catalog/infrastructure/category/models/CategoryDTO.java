package com.sysm.catalog.infrastructure.category.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sysm.catalog.domain.category.Category;

import java.time.Instant;

public record CategoryDTO(
        @JsonProperty("id") String id,
        @JsonProperty("name") String name,
        @JsonProperty("description") String description,
        @JsonProperty("is_active") Boolean isActive,
        @JsonProperty("created_at")Instant createdAt,
        @JsonProperty("update_at")Instant updatedAt,
        @JsonProperty("delete_at")Instant deletedAt
) {

    @Override
    public Boolean isActive() {
        return isActive != null ? isActive : true;
    }

    public Category toCategory() {
        return Category.with(id(), name(), description(), isActive(), createdAt(), updatedAt(), deletedAt());
    }
}
