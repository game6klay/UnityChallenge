package backend;

import java.io.*;

/**
 * Created by jay on 7/28/17.
 */

/**
 * Have implemented the FileLogger and SystemErrorLogger class to get the logs respectively.
 * Both the class extend the StandardLogger class to for which we would write minimum code and
 * inherit maximum functionality to solve the problem in hand.
 * File path of the logs  file is in the project structure for simplicity.
 * */

class LoggerExample {
    public static void main(String[] args) {
        Logger logger = new StandardLogger(Logger.LOG_LEVEL_DEBUG, new StdOut());
        logger.Debug("Some debug statements here");

        Logger fileLogger = new FileLogger(Logger.LOG_LEVEL_DEBUG, new FileOut());
        fileLogger.Debug("should print in file");

        Logger systemErrorLogger = new SystemErrorLogger(Logger.LOG_LEVEL_DEBUG, new SystemError());
        systemErrorLogger.Debug("should print as error messages");

    }
}

/**
 * When we have a mismatch of requested level of the logs to the ones that we have called
 * it would not yield an output taking care of the check we have in the log() method.
 * */

class StandardLogger implements Logger{
    private final Output output;
    private final int logLevel;

    public StandardLogger(int logLevel, Output output) {
        this.output = output;
        this.logLevel = logLevel;
    }


    @Override
    public void Debug(String msg) {
        log(Logger.LOG_LEVEL_DEBUG, msg);
    }

    @Override
    public void Error(String msg) {
        log(Logger.LOG_LEVEL_ERROR, msg);
    }

    @Override
    public void Info(String msg) {
        log(Logger.LOG_LEVEL_INFO, msg);
    }

    void log (int requestedLevel, String msg) {
        if ((requestedLevel & this.logLevel) > 0) {
            this.output.write(msg);
        }
    }
}

/**
 * Two different implementation of the classes increases readability when we call the instances.
 * Other option of the design was to implements the methods in the StandardLogger itself and passing
 * different Handlers (FileOut and SystemError) when we instantiate the objects. That would be a loss
 * in readability of the code , however, leaving the code a bit more decoupled.
 * May be we can decide better according to specific requirement.
 * */

class FileLogger extends StandardLogger
{
    FileLogger(int logLevel,Output out)
    {
        super(logLevel,out);
    }

}

class SystemErrorLogger extends StandardLogger
{

    SystemErrorLogger(int logLevel, Output output) {
        super(logLevel, output);
    }
}

interface Logger {
    public static final int LOG_LEVEL_INFO = 0x0002;
    public static final int LOG_LEVEL_ERROR = 0x0004;
    public static final int LOG_LEVEL_DEBUG = 0x0008;

    public void Debug(String msg);
    public void Error(String msg);
    public void Info(String msg);
}

interface Output {
    public void write(String msg);
}

class StdOut implements Output {
    @Override
    public void write(String msg) {
        System.out.println(msg);
    }
}

class FileOut implements Output {

    @Override
    public void write(String msg)  {
        File file=null;
        BufferedWriter writer=null;
        file=new File("logs.log");
        if(!file.exists())
            try {
                file.createNewFile();
            }catch(IOException exc)
            {

            }
        try {
           writer  = new BufferedWriter(new FileWriter(file, true));
        }catch(IOException ex){

        }
        try{
        writer.write("\n"+msg);
        }catch(IOException ex)
        {

        }finally {
            try {
                writer.close();
            }catch(Exception e){

            }
        }

    }
}

class SystemError implements Output
{

    @Override
    public void write(String msg) {
        System.err.println("\n"+msg);
    }
}

