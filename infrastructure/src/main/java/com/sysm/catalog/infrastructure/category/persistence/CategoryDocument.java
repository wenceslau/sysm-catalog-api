package com.sysm.catalog.infrastructure.category.persistence;

import com.sysm.catalog.domain.category.Category;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.time.Instant;

@Document(indexName = "categories")
public class CategoryDocument {

    @Id
    private String id;

    @MultiField(
        mainField = @Field(type = FieldType.Text, fielddata = true),
        otherFields = @InnerField(suffix = "keyword", type = FieldType.Keyword)
    )
    private String name;

    @Field(type = FieldType.Text, name = "description")
    private String description;

    @Field(type = FieldType.Date, name = "active")
    private boolean active;

    @Field(type = FieldType.Date, name = "created_at")
    private Instant createdAt;

    @Field(type = FieldType.Date, name = "updated_at")
    private Instant updatedAt;

    @Field(type = FieldType.Date, name = "deleted_at")
    private Instant deletedAt;

    public CategoryDocument(String id, String name,
                            String description,
                            boolean active,
                            Instant createdAt,
                            Instant updatedAt,
                            Instant deletedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public static CategoryDocument fromEntity(Category category) {
        return new CategoryDocument(
            category.id(),
            category.name(),
            category.description(),
            category.active(),
            category.createdAt(),
            category.updatedAt(),
            category.deletedAt()
        );
    }

    public Category toEntity() {
        return Category.with(
            id,
            name,
            description,
            active,
            createdAt,
            updatedAt,
            deletedAt
        );
    }

    public String getId() {
        return id;
    }

    public CategoryDocument setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CategoryDocument setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CategoryDocument setDescription(String description) {
        this.description = description;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public CategoryDocument setActive(boolean active) {
        this.active = active;
        return this;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public CategoryDocument setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public CategoryDocument setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }

    public CategoryDocument setDeletedAt(Instant deletedAt) {
        this.deletedAt = deletedAt;
        return this;
    }
}
