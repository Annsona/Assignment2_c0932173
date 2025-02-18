import static org.junit.jupiter.api.Assertions.*;
import org.com.myproject.BlogPost;
import org.com.myproject.Blog;
import org.com.myproject.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BlogTest {
    private Blog blog;

    @BeforeEach
    public void setUp() {
        Person author1 = Person.builder()
                .id("1")
                .firstName("John")
                .lastName("Doe")
                .age(30)
                .gender("Male")
                .build();

        Person author2 = Person.builder()
                .id("2")
                .firstName("Jane")
                .lastName("Smith")
                .age(25)
                .gender("Female")
                .build();

        BlogPost post1 = BlogPost.builder()
                .id("101")
                .authorId("1")
                .postContent("First blog post.")
                .build();

        BlogPost post2 = BlogPost.builder()
                .id("102")
                .authorId("2")
                .postContent("Second blog post.")
                .build();

        BlogPost post3 = BlogPost.builder()
                .id("103")
                .authorId("1")
                .postContent("Third blog post.")
                .build();

        blog = new Blog(Arrays.asList(post1, post2, post3), Arrays.asList(author1, author2));
    }

    @Test
    public void testGetPostsByAuthorAge_ValidAge() {
        List<String> result = blog.getPostsByAuthorAge(30);
        assertEquals(Arrays.asList("101", "103"), result);
    }

    @Test
    public void testGetPostsByAuthorAge_NoMatchingAge() {
        List<String> result = blog.getPostsByAuthorAge(40);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testGetPostsByAuthorAge_EmptyBlog() {
        Blog emptyBlog = new Blog(Collections.emptyList(), Collections.emptyList());
        List<String> result = emptyBlog.getPostsByAuthorAge(30);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testGetPostsByAuthorAge_MissingAuthorId() {
        BlogPost orphanPost = BlogPost.builder()
                .id("104")
                .authorId("99") // No matching author
                .postContent("Orphan blog post.")
                .build();

        blog = new Blog(Arrays.asList(orphanPost), blog.getContributors());
        List<String> result = blog.getPostsByAuthorAge(30);
        assertTrue(result.isEmpty());
    }
}
