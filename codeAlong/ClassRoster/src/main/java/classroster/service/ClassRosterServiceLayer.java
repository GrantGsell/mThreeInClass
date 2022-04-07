package classroster.service;

import classroster.dao.ClassRosterPersistenceException;
import classroster.dto.Student;
import java.util.List;

/**
 *
 * @author Grant
 */
public interface ClassRosterServiceLayer {
    void createStudent(Student student) throws
            ClassRosterDuplicateIdException,
            ClassRosterDataValidationException,
            ClassRosterPersistenceException;
 
    List<Student> getAllStudents() throws
            ClassRosterPersistenceException;
 
    Student getStudent(String studentId) throws
            ClassRosterPersistenceException;
 
    Student removeStudent(String studentId) throws
            ClassRosterPersistenceException;
}
