package org.com.myproject;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@EqualsAndHashCode
@ToString
@JsonDeserialize(builder = BlogPost.BlogPostBuilder.class)
public class BlogPost {
    private String id;
    private String authorId;
    private String postContent;

    private BlogPost(String id, String authorId, String postContent) {
        if (id == null) throw new IllegalArgumentException("ID cannot be null");
        if (authorId == null) throw new IllegalArgumentException("Author ID cannot be null");

        this.id = id;
        this.authorId = authorId;
        this.postContent = postContent;
    }
}
