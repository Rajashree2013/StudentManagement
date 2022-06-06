package se.lexicon.rajashree.data_access;


import org.springframework.stereotype.Component;
import se.lexicon.rajashree.models.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


@Component
public class StudentDaoListImpl implements StudentDao {

    Collection<Student> storage;

    public StudentDaoListImpl() {
        storage = new ArrayList<>();
    }


    @Override
    public Student find(int id) {
        Student student = null;
        Iterator i = storage.iterator();
        while (i.hasNext()) {
            student = (Student) i.next();
            if (student.equals(id)) {
                break;
            }
        }
        return student;
    }

    @Override
    public Student save(Student student) {
        if (student == null) throw new IllegalArgumentException("customer is null");
        storage.add(student);
        return student;
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public void delete(int id) {
        Iterator i = storage.iterator();
        while (i.hasNext()) {
            String str = (String) i.next();
            if (str.equals(id)) {
                i.remove();
                break;
            }
        }

    }
}
