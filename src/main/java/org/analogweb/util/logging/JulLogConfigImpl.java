package org.analogweb.util.logging;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;


public class JulLogConfigImpl extends JulLogConfig {
    
    protected Logger createLoggerInternal(String name, LogManager manager) {
        Logger logger = Logger.getLogger(name);
        logger.setLevel(Level.INFO);
        logger.addHandler(createConsoleHandler());
        manager.addLogger(logger);
        return logger;
    }

    private ConsoleHandler createConsoleHandler() {
        ConsoleHandler console = new ConsoleHandler();
        console.setFormatter(new JulLogFormatter());
        console.setLevel(Level.INFO);
        return console;
    }
}
