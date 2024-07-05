package com.sansilvestre.desktop.app.util.log;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Console {

    public enum InfoCode {

        I001,
        I200

    }

    public enum WarnCode {

        W001

    }

    public enum ErrorCode {

        E001,
        E002

    }

    private static final Logger logger = Logger.getLogger(Console.class.getName());

    private static final String LOG_DIRECTORY = "logs/";
    private static final String LOG_FILE_NAME = "log_%s.txt";

    private static final String INFO_LOG = "INFO";
    private static final String WARN_LOG = "WARN";

    private static final String ERROR_LOG = "ERROR";

    static {
        // Crear directorio de logs si no existe
        File logDir = new File(LOG_DIRECTORY);
        if (!logDir.exists()) {
            logDir.mkdirs();
        }
    }

    private static String build(String type, String code, String message) {
        return "[" + getDateTimeF() + "]" + " " + type + " - " + code + ": " + message;
    }

    private static String build(String type, String code, String message, String cause) {
        return "[" + getDateTimeF() + "]" + " " + type + " - " + code + ": " + message + "\n" +
                "Cause: " + cause;
    }

    public static void info(InfoCode code, String message) {
        String logMessage = build(INFO_LOG, code.name(), message);
        System.out.println(logMessage);
        writeToFile(logMessage);
    }

    public static void warn(String code, String message, String cause) {
        String logMessage = build(WARN_LOG, code, message);
        System.out.println(logMessage);
        writeToFile(logMessage);
    }

    public static void warn(WarnCode code, String message) {
        String logMessage = build(WARN_LOG, code.name(), message);
        System.out.println(logMessage);
        writeToFile(logMessage);
    }

    public static void error(String message) {
        String logMessage = build("ERROR", "", message);
        logger.log(Level.SEVERE, logMessage);
        writeToFile(logMessage);
    }

    public static void error(ErrorCode code, String message, Exception exception) {
        String logMessage = build(ERROR_LOG, code.name(), message + "\n" + "Exception: " + exception);
        logger.log(Level.SEVERE, logMessage);
        writeToFile(logMessage);
    }

    private static String getDateTimeF() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm:ss", Locale.ENGLISH));
    }

    private static void writeToFile(String message) {
        /*String fileName = String.format(LOG_DIRECTORY + LOG_FILE_NAME, getDateTime());
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            writer.println(message);
        } catch (IOException e) {
            ViewStateController.getInstance().isFailure(e.getMessage(), null);
        }*/
    }

    private static String getDateTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yy_HH:mm:ss"));
    }

}