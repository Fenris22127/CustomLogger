package de.custom.godlogger;

import java.util.logging.Logger;

import static java.util.logging.Level.*;

public class Main {
    public static void main(String[] args) {
        godLoggerNormalDemo();
        godLoggerDetailedDemo();
    }

    private static void godLoggerNormalDemo() {
        Logger normalLogger = GodLogger.newLogger(Main.class.getName());

        normalLogger.log(SEVERE,"Normal GodLogger: Severe");
        normalLogger.log(WARNING,"Normal GodLogger: Warning");
        normalLogger.log(INFO,"Normal GodLogger: Info");
        normalLogger.log(CONFIG,"Normal GodLogger: Config");
        normalLogger.log(FINE,"Normal GodLogger: Fine");
        normalLogger.log(FINER,"Normal GodLogger: Finer");
        normalLogger.log(FINEST,"Normal GodLogger: Finest");
    }

    private static void godLoggerDetailedDemo() {
        Logger detailedLogger = GodLogger.newDetailedLogger(Main.class.getName());

        detailedLogger.log(SEVERE,"Detailed GodLogger: Severe");
        detailedLogger.log(WARNING,"Detailed GodLogger: Warning");
        detailedLogger.log(INFO,"Detailed GodLogger: Info");
        detailedLogger.log(CONFIG,"Detailed GodLogger: Config");
        detailedLogger.log(FINE,"Detailed GodLogger: Fine");
        detailedLogger.log(FINER,"Detailed GodLogger: Finer");
        detailedLogger.log(FINEST,"Detailed GodLogger: Finest");
    }
}