package se.lexicon.rajashree.data_access;

import se.lexicon.rajashree.models.Student;

import java.util.List;

public interface StudentDao {

    Student find(int id);
    Student save(Student student);
    List<Student> findAll();
    void delete(int id);


}
