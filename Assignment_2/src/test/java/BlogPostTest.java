import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BlogPostTest {

    @Test
    public void testBlogPostConstructor_ValidData() {
        BlogPost blogPost = BlogPost.builder()
                .id("1")
                .authorId("1")
                .postContent("This is a blog post.")
                .build();
        assertNotNull(blogPost);
        assertEquals("1", blogPost.getId());
        assertEquals("1", blogPost.getAuthorId());
        assertEquals("This is a blog post.", blogPost.getPostContent());
    }

    @Test
    public void testBlogPostConstructor_InvalidData() {
        assertThrows(IllegalArgumentException.class, () -> BlogPost.builder()
                .id(null)
                .authorId("1")
                .postContent("This is a blog post.")
                .build());

        assertThrows(IllegalArgumentException.class, () -> BlogPost.builder()
                .id("1")
                .authorId(null)
                .postContent("This is a blog post.")
                .build());
    }
}
