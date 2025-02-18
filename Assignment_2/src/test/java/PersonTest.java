import static org.junit.jupiter.api.Assertions.*;

import org.com.myproject.Person;
import org.junit.jupiter.api.Test;

public class PersonTest {

    @Test
    public void testPersonConstructor_ValidData() {
        Person person = Person.builder()
                .id("1")
                .firstName("John")
                .lastName("Doe")
                .age(30)
                .gender("Male")
                .build();
        assertNotNull(person);
        assertEquals("John", person.getFirstName());
        assertEquals("Doe", person.getLastName());
        assertEquals(30, person.getAge());
    }

    @Test
    public void testPersonConstructor_InvalidData() {
        assertThrows(IllegalArgumentException.class, () -> Person.builder()
                .id(null)
                .firstName("John")
                .lastName("Doe")
                .age(30)
                .gender("Male")
                .build());

        assertThrows(IllegalArgumentException.class, () -> Person.builder()
                .id("1")
                .firstName(null)
                .lastName("Doe")
                .age(30)
                .gender("Male")
                .build());

        assertThrows(IllegalArgumentException.class, () -> Person.builder()
                .id("1")
                .firstName("John")
                .lastName("")
                .age(30)
                .gender("Male")
                .build());

        assertThrows(IllegalArgumentException.class, () -> Person.builder()
                .id("1")
                .firstName("John")
                .lastName("Doe")
                .age(-5)
                .gender("Male")
                .build());
    }
}
