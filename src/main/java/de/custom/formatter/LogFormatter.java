package de.custom.formatter;

import de.custom.colors.FormatColor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

@SuppressWarnings("unused")
public class LogFormatter extends Formatter {

    private static String severeColor = FormatColor.RED_BOLD_BRIGHT;
    private static String warningColor = FormatColor.YELLOW_BRIGHT;
    private static String infoColor = FormatColor.GREEN_BACKGROUND;
    private static String configColor = FormatColor.CYAN;
    private static String fineColor = FormatColor.BLUE;
    private static String finerColor = FormatColor.PURPLE;
    private static String finestColor = FormatColor.BLACK_BRIGHT;
    private final boolean isDetailed;

    public LogFormatter(boolean isDetailedLogger) {
        isDetailed = isDetailedLogger;
    }

    // format is called for every console log message
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

        builder.append(FormatColor.RESET);
        builder.append("\n");
        return builder.toString();
    }

    private String calcDate(long milliSecs) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date resultDate = new Date(milliSecs);
        return dateFormat.format(resultDate);
    }

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

    public static String getSevereColor() {
        return severeColor;
    }

    public static void setSevereColor(String severeColor) {
        LogFormatter.severeColor = severeColor;
    }

    public static String getWarningColor() {
        return warningColor;
    }

    public static void setWarningColor(String warningColor) {
        LogFormatter.warningColor = warningColor;
    }

    public static String getInfoColor() {
        return infoColor;
    }

    public static void setInfoColor(String infoColor) {
        LogFormatter.infoColor = infoColor;
    }

    public static String getConfigColor() {
        return configColor;
    }

    public static void setConfigColor(String configColor) {
        LogFormatter.configColor = configColor;
    }

    public static String getFineColor() {
        return fineColor;
    }

    public static void setFineColor(String fineColor) {
        LogFormatter.fineColor = fineColor;
    }

    public static String getFinerColor() {
        return finerColor;
    }

    public static void setFinerColor(String finerColor) {
        LogFormatter.finerColor = finerColor;
    }

    public static String getFinestColor() {
        return finestColor;
    }

    public static void setFinestColor(String finestColor) {
        LogFormatter.finestColor = finestColor;
    }

}