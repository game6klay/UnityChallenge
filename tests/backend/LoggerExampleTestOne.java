package backend;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

/**
 * Created by jay on 7/28/17.
 */
public class LoggerExampleTestOne {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    File file=new File("logs.log");
    BufferedReader fileReader=null;


    public LoggerExampleTestOne() throws FileNotFoundException {
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        if(!file.exists())
        {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            fileReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void testStandardLogger() {
        Logger logger = new StandardLogger(Logger.LOG_LEVEL_DEBUG, new StdOut());
        logger.Debug("Some debug statements here");
        assertEquals("Some debug statements here\n", outContent.toString());

    }

    @Test
    public void testFileLogger() {
        String content = "should print in file";
        Logger fileLogger = new FileLogger(Logger.LOG_LEVEL_DEBUG, new FileOut());
        fileLogger.Debug(content);
        String line="",lastLine="";
        try{
            while((line=fileReader.readLine())!=null)
            {
                lastLine=line;
            }

        }catch(IOException ex){}
        assertEquals(lastLine, content);

    }

    @Test
    public void testSystemErrorLogger() {
        Logger systemErrorLogger = new SystemErrorLogger(Logger.LOG_LEVEL_DEBUG, new SystemError());
        systemErrorLogger.Debug("should print as error messages");
        assertEquals("\nshould print as error messages\n", errContent.toString());
    }

    @Test
    public void testLogMisMatchStandardLogger() throws IllegalArgumentException {
        Logger logger = new StandardLogger(Logger.LOG_LEVEL_ERROR, new SystemError());
        logger.Debug("should print as error messages");
        assertEquals("", outContent.toString());
    }

    @Test()
    public void testLogMisMatchFileLogger() throws FileNotFoundException {
        file.delete();
        String content = "should print in file";
        Logger fileLogger = new FileLogger(Logger.LOG_LEVEL_ERROR, new FileOut());
        fileLogger.Debug(content);

        assertFalse(file.exists());
    }

    @Test
    public void testLogMisMatchSystemErrorLogger() throws IllegalArgumentException {
        Logger logger = new StandardLogger(Logger.LOG_LEVEL_ERROR, new SystemError());
        logger.Debug("should print as error messages");
        assertEquals("", errContent.toString());
    }

}