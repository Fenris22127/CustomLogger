package de.custom.logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

@SuppressWarnings("unused")
public class LogFormatter extends Formatter {

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
     * Stores, whether the Logger is detailed, meaning it will print its method of origin as well as its class
     */
    private final boolean isDetailed;

    /**
     * The Constructor: Sets, whether the created {@link Logger Logger} is a detailed logger, meaning
     * it will print its method of origin as well as its class
     * @param isDetailedLogger Whether the Logger is detailed or not
     */
    public LogFormatter(boolean isDetailedLogger) {
        isDetailed = isDetailedLogger;
    }

    /**
     * This method is called each time a {@link Logger} {@link Logger#log(Level, String) logs} anything into the
     * console.
     * @param logRecord the log record to be formatted.
     * @return A {@link String}: The formatted log record
     */
    @Override
    public String format(LogRecord logRecord) {
        // This example will print date/time, class, and log level in yellow,
        // followed by the log message and it's parameters in white .
        StringBuilder builder = new StringBuilder();
        builder.append(getLevelColor(logRecord.getLevel()));

        builder.append("[");
        builder.append(calcDate(logRecord.getMillis()));
        builder.append("]");

        builder.append(" [");
        builder.append(logRecord.getSourceClassName());
        if (isDetailed) {
            builder.append("#");
            builder.append(logRecord.getSourceMethodName());
        }
        builder.append("]");

        builder.append(" [");
        builder.append(logRecord.getLevel().getName());
        builder.append("]");

        builder.append(FormatColor.WHITE);
        builder.append(" - ");
        builder.append(logRecord.getMessage());

        Object[] params = logRecord.getParameters();

        if (params != null) {
            builder.append("\t");
            for (int i = 0; i < params.length; i++) {
                builder.append(params[i]);
                if (i < params.length - 1)
                    builder.append(", ");
            }
        }

        builder.append(FormatColorEnum.RESET);
        builder.append("\n");
        return builder.toString();
    }

    /**
     * Gets the time of the log message and formats it to show the date and time.
     * @param milliSecs A {@link Long}: The time of the log message
     * @return The time of the log message, converted to <code>yyyy-MM-dd HH:mm:ss</code>
     */
    private static String calcDate(long milliSecs) {
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


}