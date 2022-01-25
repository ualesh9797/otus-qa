import org.apache.logging.log4j.LogManager;
import org.junit.Test;

public class Logger {
    private org.apache.logging.log4j.Logger logger = LogManager.getLogger(Logger.class);

    @Test
    public void TestKogger(){
     //   logger.info("Я ИНФО ЛОГ");
        System.out.println("привет");
    }
}
