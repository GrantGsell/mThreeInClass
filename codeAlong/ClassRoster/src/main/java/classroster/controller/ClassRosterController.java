package classroster.controller;
import classroster.dao.ClassRosterDao;
import classroster.dao.ClassRosterPersistenceException;
import classroster.ui.ClassRosterView;
import classroster.dto.Student;
import java.util.List;

/**
 *
 * @author Grant
 */
public class ClassRosterController {
    //private ClassRosterDao dao = new ClassRosterDaoFileImpl();
    //private ClassRosterView view = new ClassRosterView();
    private ClassRosterDao dao;
    private ClassRosterView view;
    
    // Constructor: get dao and view at runtime
    // ie: dependency injection
    public ClassRosterController(ClassRosterDao dao, ClassRosterView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try{
            while (keepGoing) {
                
                menuSelection = getMenuSelection();
                
                switch (menuSelection) {
                    case 1:
                        listStudents();
                        break;
                    case 2:
                        createStudent();
                        break;
                    case 3:
                        viewStudent();
                        break;
                    case 4:
                        removeStudent();
                        break;
                    case 5:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
                
            }
            exitMessage();
        }catch(ClassRosterPersistenceException e){
            view.displayErrorMessage(e.getMessage());
        }
    }
    
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    
    private void createStudent() throws ClassRosterPersistenceException {
        view.displayCreateStudentBanner();
        Student newStudent = view.getNewStudentInfo();
        dao.addStudent(newStudent.getStudentId(), newStudent);
        view.displayCreateSuccessBanner();
    }
    
    
    private void listStudents() throws ClassRosterPersistenceException {
        view.displayDisplayAllBanner();
        List<Student> studentList = dao.getAllStudents();
        view.displayStudentList(studentList);
    }
    
    
    private void viewStudent() throws ClassRosterPersistenceException {
        view.displayDisplayStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student student = dao.getStudent(studentId);
        view.displayStudent(student);
    }
    
    
    private void removeStudent() throws ClassRosterPersistenceException {
        view.displayRemoveStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student removedStudent = dao.removeStudent(studentId);
        view.displayRemoveResult(removedStudent);
    }
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    
    private void exitMessage() {
        view.displayExitBanner();
    }
}
