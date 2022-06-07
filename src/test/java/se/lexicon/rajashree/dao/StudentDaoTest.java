package se.lexicon.rajashree.dao;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import se.lexicon.rajashree.config.ComponentScanConfig;
import se.lexicon.rajashree.exception.DataNotFoundException;
import se.lexicon.rajashree.models.Student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ComponentScanConfig.class)
public class StudentDaoTest {

    @Autowired
    private StudentDao testObject;

    @BeforeEach
    public void setup() {
        testObject.save(new Student("Erik Svensson"));
    }

    @Test
    @DisplayName("Given Student student successfully create and successfully equal")
    void save() {
        Student expectedData = new Student(2, "Mehrdad Javan");
        Student actualData = testObject.save(new Student("Mehrdad Javan"));
        assertEquals(expectedData, actualData);
    }

    @Test
    @DisplayName("Given id of 1 findById return expected object")
    void findById() {
        try {
            Student expectedData = new Student(1, "Erik Svensson");
            Student actualData = testObject.find(1);
            assertEquals(expectedData, actualData);
        } catch (DataNotFoundException e) {
            System.out.println(e.getObjectName());
            System.out.println(e.getMessage());
        }

    }

    @Test
    void findById_throws_DataNotFoundException(){
        assertThrows(DataNotFoundException.class, () -> testObject.find(10));
    }

}
