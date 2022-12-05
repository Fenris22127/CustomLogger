package de.custom.godlogger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.MissingResourceException;
import java.util.logging.*;

@SuppressWarnings("unused")
public class GodLogger extends Logger {

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
    protected GodLogger(String name, String resourceBundleName) {
        super(name, resourceBundleName);
    }

    /**
     * Creates a new {@link Logger} with the passed name, {@link Logger#setLevel(Level) sets} the {@link Handler}s and
     * the {@link Logger}s {@link Level} to log {@link Level#ALL all} messages and adds the {@link LogFormatter}.
     * @param name A {@link String}: The name of the logger
     * @return A {@link Logger}: A {@link Logger}, customised with the {@link LogFormatter}
     */
    public static Logger newLogger(String name) {
        Logger logger = Logger.getLogger(name);
        Handler handlerObj = new ConsoleHandler();
        handlerObj.setLevel(Level.ALL);
        Formatter f = new LogFormatter();
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
     * @param name A {@link String}: The name of the logger
     * @return A {@link Logger}: A detailed {@link Logger}, customised with the {@link LogFormatter}
     */
    public static Logger newDetailedLogger(String name) {
        isDetailed = true;
        return newLogger(name);
    }

    /**
     * An inner class, providing the {@link Formatter} for the {@link Logger} that customises the colors of the console
     * outputs for the different {@link Level}s.
     */
    public static class LogFormatter extends Formatter {
        /**
         * The {@link String} storing the {@link FormatColor color} for the {@link Level} {@link Level#SEVERE SEVERE}
         */
        private static String severeColor = FormatColor.RED_BOLD_BRIGHT;

        /**
         * The {@link String} storing the {@link FormatColor color} for the {@link Level} {@link Level#WARNING WARNING}
         */
        private static String warningColor = FormatColor.YELLOW_BRIGHT;

        /**
         * The {@link String} storing the {@link FormatColor color} for the {@link Level} {@link Level#INFO INFO}
         */
        private static String infoColor = FormatColor.GREEN_BACKGROUND;

        /**
         * The {@link String} storing the {@link FormatColor color} for the {@link Level} {@link Level#CONFIG CONFIG}
         */
        private static String configColor = FormatColor.CYAN;

        /**
         * The {@link String} storing the {@link FormatColor color} for the {@link Level} {@link Level#FINE FINE}
         */
        private static String fineColor = FormatColor.BLUE;

        /**
         * The {@link String} storing the {@link FormatColor color} for the {@link Level} {@link Level#FINER FINER}
         */
        private static String finerColor = FormatColor.PURPLE;

        /**
         * The {@link String} storing the {@link FormatColor color} for the {@link Level} {@link Level#FINEST FINEST}
         */
        private static String finestColor = FormatColor.BLACK_BRIGHT;

        /**
         * This method is called each time a {@link Logger} {@link Logger#log(Level, String) logs} anything into the
         * console.
         * @param logRecord the log record to be formatted.
         * @return A {@link String}: The formatted log record
         */
        @Override
        public String format(LogRecord logRecord) {
            StringBuilder builder = new StringBuilder();

            //sets the color depending on the level by calling getLevelColor()
            builder.append(getLevelColor(logRecord.getLevel()));

            //add the date and time of the log message
            builder.append("[");
            builder.append(calcDate(logRecord.getMillis()));
            builder.append("]");

            //add the source class of the log message
            builder.append(" [");
            builder.append(logRecord.getSourceClassName());
            //if the logger is a detailed logger, the method of origin is added as well
            if (isDetailed) {
                builder.append("#");
                builder.append(logRecord.getSourceMethodName());
            }
            builder.append("]");

            //adds the level
            builder.append(" [");
            builder.append(logRecord.getLevel().getName());
            builder.append("]");

            //sets the color to white and adds the message
            builder.append(FormatColor.WHITE);
            builder.append(" - ");
            builder.append(logRecord.getMessage());

            //gets the parameters of the message
            Object[] params = logRecord.getParameters();
            //adds  the parameters to the message
            if (params != null) {
                builder.append("\t");
                for (int i = 0; i < params.length; i++) {
                    builder.append(params[i]);
                    if (i < params.length - 1) {
                        builder.append(", ");
                    }
                }
            }

            //resets the color and adds a line break
            builder.append(FormatColor.RESET);
            builder.append(System.lineSeparator());
            return builder.toString();
        }

        /**
         * Gets the time of the log message and formats it to show the date and time.
         * @param milliSecs A {@link Long}: The time of the log message
         * @return The time of the log message, converted to <code>yyyy-MM-dd HH:mm:ss</code>
         */
        private String calcDate(long milliSecs) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date resultDate = new Date(milliSecs);
            return dateFormat.format(resultDate);
        }

        /**
         * Determines the color for the log message depending on the {@link Level}.
         * @param level A {@link Level}: The {@link Level} of the log message
         * @return A {@link String}: The appropriate color for the log message
         */
        private String getLevelColor(Level level) {
            String color;
            switch (level.toString()) {
                case "SEVERE" -> color = severeColor;
                case "WARNING" -> color = warningColor;
                case "INFO" -> color = infoColor;
                case "CONFIG" -> color = configColor;
                case "FINE" -> color = fineColor;
                case "FINER" -> color = finerColor;
                case "FINEST" -> color = finestColor;
                default -> color = FormatColor.WHITE;
            }
            return color;
        }

        /**
         * Gets the {@link #severeColor color} for the {@link Level} {@link Level#SEVERE SEVERE}
         * @return A {@link String}: The {@link #severeColor color} for the {@link Level} {@link Level#SEVERE SEVERE}
         */
        public static String getSevereColor() {
            return severeColor;
        }

        /**
         * Sets the {@link #severeColor color} for the {@link Level} {@link Level#SEVERE SEVERE}
         * @param severeColor A {@link String}:    The {@link #severeColor color} for the {@link Level}
         *                                          {@link Level#SEVERE SEVERE}
         */
        public static void setSevereColor(String severeColor) {
            LogFormatter.severeColor = severeColor;
        }

        /**
         * Sets the {@link #warningColor color} for the {@link Level} {@link Level#WARNING WARNING}
         * @return A {@link String}: The {@link #warningColor color} for the {@link Level} {@link Level#WARNING WARNING}
         */
        public static String getWarningColor() {
            return warningColor;
        }

        /**
         * Sets the {@link #warningColor color} for the {@link Level} {@link Level#WARNING WARNING}
         * @param warningColor A {@link String}:    The {@link #warningColor color} for the {@link Level}
         *                                          {@link Level#WARNING WARNING}
         */
        public static void setWarningColor(String warningColor) {
            LogFormatter.warningColor = warningColor;
        }

        /**
         * Gets the {@link #infoColor color} for the {@link Level} {@link Level#INFO INFO}
         * @return A {@link String}: The {@link #infoColor color} for the {@link Level} {@link Level#INFO INFO}
         */
        public static String getInfoColor() {
            return infoColor;
        }

        /**
         * Sets the {@link #infoColor color} for the {@link Level} {@link Level#INFO INFO}
         * @param infoColor A {@link String}:    The {@link #infoColor color} for the {@link Level}
         *                                          {@link Level#INFO INFO}
         */
        public static void setInfoColor(String infoColor) {
            LogFormatter.infoColor = infoColor;
        }

        /**
         * Gets the {@link #configColor color} for the {@link Level} {@link Level#CONFIG CONFIG}
         * @return A {@link String}: The {@link #configColor color} for the {@link Level} {@link Level#CONFIG CONFIG}
         */
        public static String getConfigColor() {
            return configColor;
        }

        /**
         * Sets the {@link #configColor color} for the {@link Level} {@link Level#CONFIG CONFIG}
         * @param configColor A {@link String}:    The {@link #configColor color} for the {@link Level}
         *                                          {@link Level#CONFIG CONFIG}
         */
        public static void setConfigColor(String configColor) {
            LogFormatter.configColor = configColor;
        }

        /**
         * Gets the {@link #fineColor color} for the {@link Level} {@link Level#FINE FINE}
         * @return A {@link String}: The {@link #fineColor color} for the {@link Level} {@link Level#FINE FINE}
         */
        public static String getFineColor() {
            return fineColor;
        }

        /**
         * Sets the {@link #fineColor color} for the {@link Level} {@link Level#FINE FINE}
         * @param fineColor A {@link String}:    The {@link #fineColor color} for the {@link Level}
         *                                          {@link Level#FINE FINE}
         */
        public static void setFineColor(String fineColor) {
            LogFormatter.fineColor = fineColor;
        }

        /**
         * Gets the {@link #finerColor color} for the {@link Level} {@link Level#FINER FINER}
         * @return A {@link String}: The {@link #finerColor color} for the {@link Level} {@link Level#FINER FINER}
         */
        public static String getFinerColor() {
            return finerColor;
        }

        /**
         * Sets the {@link #finerColor color} for the {@link Level} {@link Level#FINER FINER}
         * @param finerColor A {@link String}:    The {@link #finerColor color} for the {@link Level}
         *                                          {@link Level#FINER FINER}
         */
        public static void setFinerColor(String finerColor) {
            LogFormatter.finerColor = finerColor;
        }

        /**
         * Gets the {@link #finestColor color} for the {@link Level} {@link Level#FINEST FINEST}
         * @return A {@link String}: The {@link #finestColor color} for the {@link Level} {@link Level#FINEST FINEST}
         */
        public static String getFinestColor() {
            return finestColor;
        }

        /**
         * Sets the {@link #finestColor color} for the {@link Level} {@link Level#FINEST FINEST}
         * @param finestColor A {@link String}:    The {@link #finestColor color} for the {@link Level}
         *                                          {@link Level#FINEST FINEST}
         */
        public static void setFinestColor(String finestColor) {
            LogFormatter.finestColor = finestColor;
        }

        /**
         * An inner class storing the available colors in ANSI-Format. <br>
         * @see <a href="https://en.wikipedia.org/wiki/ANSI_escape_code#Colors">ANSI Escape Sequences</a>
         */
        public static class FormatColor {

            /**
             * A private constructor to hide the implicitly public one
             */
            private FormatColor(){}

            /**
             * Resets the text color
             */
            public static final String RESET = "\033[0m";

            // Regular Colors
            /**
             * Sets the color to <span color="rgb(12, 12, 12)">Black</span>
             */
            public static final String BLACK = "\033[0;30m";
            /**
             * Sets the color to <span color="#C50F1F">Red</span>
             */
            public static final String RED = "\033[0;31m";
            /**
             * Sets the color to <span color="rgb(19,161,14)">Green</span>
             */
            public static final String GREEN = "\033[0;32m";
            /**
             * Sets the color to <span color="rgb(193,156,0)">Yellow</span>
             */
            public static final String YELLOW = "\033[0;33m";
            /**
             * Sets the color to <span color="rgb(0,55,218)">Blue</span>
             */
            public static final String BLUE = "\033[0;34m";
            /**
             * Sets the color to <span color="rgb(136,23,152)">Purple</span>
             */
            public static final String PURPLE = "\033[0;35m";
            /**
             * Sets the color to <span color="rgb(58,150,221)">Cyan</span>
             */
            public static final String CYAN = "\033[0;36m";
            /**
             * Sets the color to <span color="#CCCCCC">White</span>
             */
            public static final String WHITE = "\033[0;37m";

            // Bold
            /**
             * Sets the color and font weight to <b color="rgb(12, 12, 12)">Black</b>
             */
            public static final String BLACK_BOLD = "\033[1;30m";
            /**
             * Sets the color and font weight to <b color="#C50F1F">Red</b>
             */
            public static final String RED_BOLD = "\033[1;31m";
            /**
             * Sets the color and font weight to <b color="rgb(19,161,14)">Green</b>
             */
            public static final String GREEN_BOLD = "\033[1;32m";
            /**
             * Sets the color and font weight to <b color="rgb(193,156,0)">Yellow</b>
             */
            public static final String YELLOW_BOLD = "\033[1;33m";
            /**
             * Sets the color and font weight to <b color="rgb(0,55,218)">Blue</b>
             */
            public static final String BLUE_BOLD = "\033[1;34m";
            /**
             * Sets the color and font weight to <b color="rgb(136,23,152)">Purple</b>
             */
            public static final String PURPLE_BOLD = "\033[1;35m";
            /**
             * Sets the color and font weight to <b color="rgb(58,150,221)">Cyan</b>
             */
            public static final String CYAN_BOLD = "\033[1;36m";
            /**
             * Sets the color and font weight to <b color="#CCCCCC">White</b>
             */
            public static final String WHITE_BOLD = "\033[1;37m";

            // Underline
            /**
             * Sets the color and text-decoration to <span style="text-decoration: underline; color: rgb(12, 12, 12);">Black</span>
             */
            public static final String BLACK_UNDERLINED = "\033[4;30m";
            /**
             * Sets the color and text-decoration to <span style="text-decoration: underline; color: #C50F1F;">Red</span>
             */
            public static final String RED_UNDERLINED = "\033[4;31m";
            /**
             * Sets the color and text-decoration to <span style="text-decoration: underline; color: rgb(19,161,14);">Green</span>
             */
            public static final String GREEN_UNDERLINED = "\033[4;32m";
            /**
             * Sets the color and text-decoration to <span style="text-decoration: underline; color: rgb(193,156,0);">Yellow</span>
             */
            public static final String YELLOW_UNDERLINED = "\033[4;33m";
            /**
             * Sets the color and text-decoration to <span style="text-decoration: underline; color: rgb(0,55,218);">Blue</span>
             */
            public static final String BLUE_UNDERLINED = "\033[4;34m";
            /**
             * Sets the color and text-decoration to <span style="text-decoration: underline; color: rgb(136,23,152);">Purple</span>
             */
            public static final String PURPLE_UNDERLINED = "\033[4;35m";
            /**
             * Sets the color and text-decoration to <span style="text-decoration: underline; color: rgb(58,150,221);">Cyan</span>
             */
            public static final String CYAN_UNDERLINED = "\033[4;36m";
            /**
             * Sets the color and text-decoration to <span style="text-decoration: underline; color: #CCCCCC;">White</span>
             */
            public static final String WHITE_UNDERLINED = "\033[4;37m";

            // Background
            /**
             * Sets the color and background to <span style="background-color: rgb(12, 12, 12); color: #CCCCCC;">Black</span>
             */
            public static final String BLACK_BACKGROUND = "\033[40m";
            /**
             * Sets the color and background to <span style="background-color: #C50F1F; color: #CCCCCC;">Red</span>
             */
            public static final String RED_BACKGROUND = "\033[41m";
            /**
             * Sets the color and background to <span style="background-color: rgb(19,161,14); color: #CCCCCC;">Green</span>
             */
            public static final String GREEN_BACKGROUND = "\033[42m";
            /**
             * Sets the color and background to <span style="background-color: rgb(193,156,0); color: rgb(12, 12, 12);">Yellow</span>
             */
            public static final String YELLOW_BACKGROUND = "\033[43m";
            /**
             * Sets the color and background to <span style="background-color: rgb(0,55,218); color: #CCCCCC;">Blue</span>
             */
            public static final String BLUE_BACKGROUND = "\033[44m";
            /**
             * Sets the color and background to <span style="background-color: rgb(136,23,152); color: #CCCCCC;">Purple</span>
             */
            public static final String PURPLE_BACKGROUND = "\033[45m";
            /**
             * Sets the color and background to <span style="background-color: rgb(58,150,221); color: #CCCCCC;">Cyan</span>
             */
            public static final String CYAN_BACKGROUND = "\033[46m";
            /**
             * Sets the color and background to <span style="background-color: #CCCCCC; color: rgb(12, 12, 12);">White</span>
             */
            public static final String WHITE_BACKGROUND = "\033[47m";

            // High Intensity
            /**
             * Sets the color to <span color="rgb(118,118,118)">Black</span>
             */
            public static final String BLACK_BRIGHT = "\033[0;90m";
            /**
             * Sets the color to <span color="rgb(231,72,86)">Red</span>
             */
            public static final String RED_BRIGHT = "\033[0;91m";
            /**
             * Sets the color to <span color="rgb(19,161,14)">Green</span>
             */
            public static final String GREEN_BRIGHT = "\033[0;92m";
            /**
             * Sets the color to <span color="rgb(249,241,165)">Yellow</span>
             */
            public static final String YELLOW_BRIGHT = "\033[0;93m";
            /**
             * Sets the color to <span color="rgb(59,120,255)">Blue</span>
             */
            public static final String BLUE_BRIGHT = "\033[0;94m";
            /**
             * Sets the color to <span color="rgb(180,0,158)">Purple</span>
             */
            public static final String PURPLE_BRIGHT = "\033[0;95m";
            /**
             * Sets the color to <span color="rgb(97,214,214)">Cyan</span>
             */
            public static final String CYAN_BRIGHT = "\033[0;96m";
            /**
             * Sets the color to <span color="#FFFFFF">White</span>
             */
            public static final String WHITE_BRIGHT = "\033[0;97m";

            // Bold High Intensity
            /**
             * Sets the color and font weight to <b color="rgb(118,118,118)">Black</b>
             */
            public static final String BLACK_BOLD_BRIGHT = "\033[1;90m";
            /**
             * Sets the color and font weight to <b color="rgb(231,72,86)">Red</b>
             */
            public static final String RED_BOLD_BRIGHT = "\033[1;91m";
            /**
             * Sets the color and font weight to <b color="rgb(19,161,14)">Green</b>
             */
            public static final String GREEN_BOLD_BRIGHT = "\033[1;92m";
            /**
             * Sets the color and font weight to <b color="rgb(193,156,0)">Yellow</b>
             */
            public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";
            /**
             * Sets the color and font weight to <b color="rgb(0,55,218)">Blue</b>
             */
            public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";
            /**
             * Sets the color and font weight to <b color="rgb(136,23,152)">Purple</b>
             */
            public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";
            /**
             * Sets the color and font weight to <b color="rgb(0,255,255)">Cyan</b>
             */
            public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";
            /**
             * Sets the color and font weight to <b color="#FFFFFF">White</b>
             */
            public static final String WHITE_BOLD_BRIGHT = "\033[1;97m";

            // High Intensity backgrounds
            /**
             * Sets the color and background to <span style="background-color: rgb(118,118,118); color: #CCCCCC;">Black</span>
             */
            public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";
            /**
             * Sets the color and background to <span style="background-color: rgb(231,72,86); color: #CCCCCC;">Red</span>
             */
            public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";
            /**
             * Sets the color and background to <span style="background-color: rgb(19,161,14); color: #CCCCCC;">Green</span>
             */
            public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";
            /**
             * Sets the color and background to <span style="background-color: rgb(249,241,165); color: rgb(12, 12, 12);">Yellow</span>
             */
            public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";
            /**
             * Sets the color and background to <span style="background-color: rgb(59,120,255); color: #CCCCCC;">Blue</span>
             */
            public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";
            /**
             * Sets the color and background to <span style="background-color: rgb(180,0,158); color: #CCCCCC;">Purple</span>
             */
            public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m";
            /**
             * Sets the color and background to <span style="background-color: rgb(97,214,214); color: rba();">Cyan</span>
             */
            public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";
            /**
             * Sets the color and background to <span style="background-color: #FFFFFF; color: rgb(12, 12, 12);">White</span>
             */
            public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";
        }
    }
}
