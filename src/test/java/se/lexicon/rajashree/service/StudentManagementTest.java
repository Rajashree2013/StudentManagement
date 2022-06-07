package se.lexicon.rajashree.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import se.lexicon.rajashree.config.ComponentScanConfig;
import se.lexicon.rajashree.dao.StudentDao;
import se.lexicon.rajashree.exception.DataNotFoundException;
import se.lexicon.rajashree.models.Student;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ComponentScanConfig.class)
public class StudentManagementTest {

    @Autowired
    private StudentManagement testObject;

    @BeforeEach
    public void setup() {
        testObject.save(new Student("Shoubhit Nayak"));
    }


    @Test
    @DisplayName("Given id of 1 findById return expected object")
    void findById() {
        Student expectedData = new Student(3, "Shoubhit Nayak");
        Student actualData = testObject.find(3);
        assertEquals(expectedData, actualData);

    }
}
