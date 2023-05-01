package de.custom.logger;

import java.util.MissingResourceException;
import java.util.logging.*;

@SuppressWarnings("unused")
public class ColorLogger extends Logger {

    /**
     * Stores, whether the Logger is detailed, meaning it will print its method of origin as well as its class
     */
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

    /**
     * Creates a new {@link Logger} with the passed name, {@link Logger#setLevel(Level) sets} the {@link Handler}s and
     * the {@link Logger}s {@link Level} to log {@link Level#ALL all} messages and adds the {@link LogFormatter}.
     *
     * @param name A {@link String}: The name of the logger
     * @return A {@link Logger}: A {@link Logger}, customised with the {@link LogFormatter}
     */
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

    /**
     * Sets {@link #isDetailed} to true and then returns the {@link Logger} from
     * {@link #newLogger(String) newLogger()}. <br>
     * This logger will also print its method of origin as well as its class.
     *
     * @param name A {@link String}: The name of the logger
     * @return A {@link Logger}: A detailed {@link Logger}, customised with the {@link LogFormatter}
     */
    public static Logger newDetailedLogger(String name) {
        isDetailed = true;
        return newLogger(name);
    }
}

