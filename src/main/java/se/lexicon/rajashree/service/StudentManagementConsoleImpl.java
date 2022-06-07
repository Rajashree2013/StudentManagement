package se.lexicon.rajashree.service;

import org.springframework.beans.factory.annotation.Autowired;
import se.lexicon.rajashree.dao.StudentDao;
import se.lexicon.rajashree.exception.DataNotFoundException;
import se.lexicon.rajashree.util.UserInputService;
import se.lexicon.rajashree.models.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StudentManagementConsoleImpl implements StudentManagement {

    Collection<Student> storage;
    UserInputService userInputService;
    StudentDao studentDao;

    @Autowired
    public StudentManagementConsoleImpl(UserInputService userInputService, StudentDao studentDAO) {
        this.userInputService = userInputService;
        this.studentDao = studentDao;
    }


    public StudentManagementConsoleImpl() {
        storage = new ArrayList<>();
    }


    @Override
    public Student create() {
        System.out.println("enter a name:");
        String name = userInputService.getString();
        Student student = new Student(name);
        Student savedData = studentDao.save(student);
        return savedData;
    }

    @Override
    public Student save(Student student) {
        if (student == null ) throw new IllegalArgumentException("Student is null");
        return studentDao.save(student);
    }

    @Override
    public Student find(int id) {
        if (id <= 0 ) throw new IllegalArgumentException("id is not valid");
        try {
            return studentDao.find(id);
        } catch (DataNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Student remove(int id) {
        // todo: implement remove
        return null;
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public Student edit(Student student) {
        // todo: implement edit
        return null;
    }
}
