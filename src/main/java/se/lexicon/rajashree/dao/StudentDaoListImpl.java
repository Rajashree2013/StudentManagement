package se.lexicon.rajashree.dao;


import org.springframework.stereotype.Component;
import se.lexicon.rajashree.sequencer.StudentIdSequencer;
import se.lexicon.rajashree.exception.DataNotFoundException;
import se.lexicon.rajashree.models.Student;

import java.util.*;


@Component
public class StudentDaoListImpl implements StudentDao {

    private List<Student> students;

    public StudentDaoListImpl() {
        students = new ArrayList<>();
    }

    @Override
    public Student save(Student student) {
        if (student == null) throw new IllegalArgumentException("Student is null");
        student.setId(StudentIdSequencer.nextId());
        students.add(student);
        return student;
    }

    @Override
    public Student find(int id) throws DataNotFoundException {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElseThrow(() -> new DataNotFoundException("Not Found", "Student"));
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    @Override
    public void delete(int id) throws DataNotFoundException {
        Optional.ofNullable(find(id)).ifPresent(students::remove);
    }

    public void clear(){
        students.clear();
    }
}
