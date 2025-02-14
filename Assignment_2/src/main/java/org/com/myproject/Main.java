package org.com.myproject;

public class Main {
    public static void main(String[] args) {
        Person person = Person.builder()
                .id("1")
                .firstName("John")
                .lastName("Doe")
                .age(30)
                .gender("Male")
                .build();
        System.out.println(person);

        BlogPost blogPost = BlogPost.builder()
                .id("1")
                .authorId("1")
                .postContent("This is a blog post.")
                .build();
        System.out.println(blogPost);
    }
}
