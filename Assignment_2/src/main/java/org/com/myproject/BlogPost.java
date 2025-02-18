package org.com.myproject;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

@Builder
@Getter
@EqualsAndHashCode
@ToString
@Jacksonized
public class BlogPost {
    private String id;
    private String authorId;
    private String postContent;

    // Private constructor with validation
    private BlogPost(String id, String authorId, String postContent) {
        if (id == null) throw new IllegalArgumentException("ID cannot be null");
        if (authorId == null) throw new IllegalArgumentException("Author ID cannot be null");
        if (postContent == null || postContent.isBlank()) throw new IllegalArgumentException("Post content cannot be null or blank");

        this.id = id;
        this.authorId = authorId;
        this.postContent = postContent;
    }
}
