package org.com.myproject;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@EqualsAndHashCode
@ToString
public class Blog {
    private List<BlogPost> posts;
    private List<Person> contributors;

    // Constructor with validation to ensure posts and contributors are not null or empty
    public Blog(List<BlogPost> posts, List<Person> contributors) {
        if (posts == null || posts.isEmpty()) {
            throw new IllegalArgumentException("Posts cannot be null or empty");
        }
        if (contributors == null || contributors.isEmpty()) {
            throw new IllegalArgumentException("Contributors cannot be null or empty");
        }
        this.posts = posts;
        this.contributors = contributors;
    }

    // Method to get posts by author age, with streams as required
    public List<String> getPostsByAuthorAge(Integer age) {
        return contributors.stream()
                .filter(person -> person.getAge().equals(age))
                .map(Person::getId)
                .flatMap(authorId -> posts.stream()
                        .filter(post -> post.getAuthorId().equals(authorId))
                        .map(BlogPost::getId))
                .collect(Collectors.toList());
    }
}
