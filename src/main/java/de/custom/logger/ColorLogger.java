package de.custom.logger;


import de.custom.formatter.LogFormatter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.MissingResourceException;
import java.util.logging.*;

@SuppressWarnings("unused")
public class ColorLogger extends Logger {

    private static boolean isDetailed = false;
    /**
     * Protected method to construct a logger for a named subsystem.
     * <p>
     * The logger will be initially configured with a null Level
     * and with useParentHandlers set to true.
     *
     * @param name               A name for the logger.  This should
     *                           be a dot-separated name and should normally
     *                           be based on the package name or class name
     *                           of the subsystem, such as java.net
     *                           or javax.swing.  It may be null for anonymous Loggers.
     * @param resourceBundleName name of ResourceBundle to be used for localizing
     *                           messages for this logger.  May be null if none
     *                           of the messages require localization.
     * @throws MissingResourceException if the resourceBundleName is non-null and
     *                                  no corresponding resource can be found.
     */
    protected ColorLogger(String name, String resourceBundleName) {
        super(name, resourceBundleName);
    }

    public static Logger newLogger(String name) {
        Logger logger = Logger.getLogger(name);
        Handler handlerObj = new ConsoleHandler();
        handlerObj.setLevel(Level.ALL);
        Formatter f = new LogFormatter(isDetailed);
        handlerObj.setFormatter(f);
        logger.addHandler(handlerObj);
        logger.setLevel(Level.ALL);
        logger.setUseParentHandlers(false);

        return logger;
    }

    public static Logger newDetailedLogger(String name) {
        isDetailed = true;
        return newLogger(name);
    }
}

