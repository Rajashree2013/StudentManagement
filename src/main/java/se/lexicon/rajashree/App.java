package se.lexicon.rajashree;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.rajashree.config.ComponentScanConfig;
import se.lexicon.rajashree.dao.StudentDao;
import se.lexicon.rajashree.service.StudentManagement;
import se.lexicon.rajashree.util.UserInputService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        StudentDao studentDao = context.getBean(StudentDao.class);
        UserInputService userInputService =context.getBean(UserInputService.class);
        StudentManagement studentManagement = context.getBean(StudentManagement.class);

    }
}
