package de.custom;

import de.custom.logger.ColorLogger;

import java.util.logging.Logger;

import static java.util.logging.Level.*;

public class Main {
    public static void main(String[] args) {
        Logger logger = ColorLogger.newLogger(Main.class.getName());

        logger.log(SEVERE,"Severe");
        logger.log(WARNING,"Warning");
        logger.log(INFO,"Info");
        logger.log(CONFIG,"Config");
        logger.log(FINE,"Fine");
        logger.log(FINER,"Finer");
        logger.log(FINEST,"Finest");
    }
}
