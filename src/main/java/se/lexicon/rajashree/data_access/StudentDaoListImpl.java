package se.lexicon.rajashree.data_access;


import org.springframework.stereotype.Component;
import se.lexicon.rajashree.models.Student;

import java.util.List;


@Component
public class StudentDaoListImpl implements StudentDao {


    @Override
    public Student find(int id) {
        return null;
    }

    @Override
    public Student save(Student student) {
        return null;
    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
