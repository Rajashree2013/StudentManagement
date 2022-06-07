package se.lexicon.rajashree.dao;

import se.lexicon.rajashree.exception.DataNotFoundException;
import se.lexicon.rajashree.models.Student;

import java.util.List;

public interface StudentDao {

    Student find(int id) throws DataNotFoundException;;
    Student save(Student student);
    List<Student> findAll();
    void delete(int id) throws DataNotFoundException;;


}
