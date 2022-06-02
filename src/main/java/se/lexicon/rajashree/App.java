package se.lexicon.rajashree;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.rajashree.config.ComponentScanConfig;
import se.lexicon.rajashree.data_access.StudentDao;

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

    }
}
