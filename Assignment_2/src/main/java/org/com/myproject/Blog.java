package org.com.myproject;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import java.util.List;

@Getter
@EqualsAndHashCode
@ToString
public class Blog {
    private List<BlogPost> posts;
    private List<Person> contributors;
}
