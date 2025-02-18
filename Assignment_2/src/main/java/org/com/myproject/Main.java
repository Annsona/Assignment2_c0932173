package org.com.myproject;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read the person.json and blogPosts.json files
            List<Person> people = objectMapper.readValue(new File("person.json"), new TypeReference<List<Person>>() {});
            List<BlogPost> blogPosts = objectMapper.readValue(new File("blogPosts.json"), new TypeReference<List<BlogPost>>() {});

            // Convert the list of people into a map for easier lookup by authorId
            Map<String, Person> personMap = people.stream().collect(Collectors.toMap(Person::getId, person -> person));

            // Check for missing authorId in the blog posts and ensure all are valid
            blogPosts.forEach(post -> {
                if (!personMap.containsKey(post.getAuthorId())) {
                    System.err.println("Warning: Author ID " + post.getAuthorId() + " not found for post " + post.getId());
                }
            });

            // Create the blog instance
            Blog blog = new Blog(blogPosts, people);

            // Print the total number of blog posts and contributors
            System.out.println("Total Blog Posts: " + blog.getPosts().size());
            System.out.println("Total Contributors: " + blog.getContributors().size());

            // Search for blog posts by author age
            int targetAge = 30;
            List<String> postsByAge = blog.getPostsByAuthorAge(targetAge);
            System.out.println("Blog Posts by Authors aged " + targetAge + ": " + postsByAge);

        } catch (IOException e) {
            // Handle errors related to file reading or deserialization
            System.err.println("Error reading JSON files: " + e.getMessage());
        }
    }
}
