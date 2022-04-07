package classroster;

import classroster.controller.ClassRosterController;
import classroster.dao.ClassRosterDao;
import classroster.dao.ClassRosterDaoFileImpl;
import classroster.service.ClassRosterServiceLayer;
import classroster.service.ClassRosterServiceLayerImpl;
import classroster.ui.ClassRosterView;
import classroster.ui.UserIO;
import classroster.ui.UserIOConsoleImpl;

/**
 *
 * @author Grant
 */
public class App {
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        ClassRosterView myView = new ClassRosterView(myIo);
        ClassRosterDao myDao = new ClassRosterDaoFileImpl();
        ClassRosterServiceLayer myService = new ClassRosterServiceLayerImpl(myDao);
        ClassRosterController controller = new ClassRosterController(myService, myView);
        controller.run();
        
        
        // Old Version
        /*
        UserIO myIo = new UserIOConsoleImpl();
        ClassRosterView myView = new ClassRosterView(myIo);
        ClassRosterDao myDao = new ClassRosterDaoFileImpl();
        ClassRosterController controller =
                new ClassRosterController(myDao, myView);
        controller.run();
        */
        
        // Old Version
        //ClassRosterController controller = new ClassRosterController();
        //controller.run();
    } 
}
