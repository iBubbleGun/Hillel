package edu.hillel.homework.logger.log4hillel.managers;

import edu.hillel.homework.logger.log4hillel.Logger;
import edu.hillel.homework.logger.log4hillel.config_loader.DatabaseLoggerConfigLoader;
import edu.hillel.homework.logger.log4hillel.config_loader.LoggerConfigLoaderInterface;
import edu.hillel.homework.logger.log4hillel.config_loader.ConsoleLoggerConfigLoader;
import edu.hillel.homework.logger.log4hillel.config_loader.FileLoggerConfigLoader;
import edu.hillel.homework.logger.log4hillel.core.configuration.ConsoleLoggerConfiguration;
import edu.hillel.homework.logger.log4hillel.core.configuration.DatabaseLoggerConfiguration;
import edu.hillel.homework.logger.log4hillel.core.configuration.FileLoggerConfiguration;
import edu.hillel.homework.logger.log4hillel.core.MultiLogger;
import edu.hillel.homework.logger.log4hillel.loggers.ConsoleLogger;
import edu.hillel.homework.logger.log4hillel.loggers.DatabaseLogger;
import edu.hillel.homework.logger.log4hillel.loggers.FileLogger;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class LoggerManager {

    private Logger fileLogger;
    private Logger consoleLogger;
    private Logger databaseLogger;

    public LoggerManager(@NotNull List<LoggerConfigLoaderInterface> configurationList) {
        for (LoggerConfigLoaderInterface config : configurationList) {
            if (config instanceof FileLoggerConfigLoader) {
                this.fileLogger = new FileLogger((FileLoggerConfiguration) config.load());
            } else if (config instanceof ConsoleLoggerConfigLoader) {
                this.consoleLogger = new ConsoleLogger((ConsoleLoggerConfiguration) config.load());
            } else if (config instanceof DatabaseLoggerConfigLoader) {
                this.databaseLogger = new DatabaseLogger((DatabaseLoggerConfiguration) config.load());
            }
        }
    }

    public Logger getLogger() {
        return new MultiLogger(consoleLogger, fileLogger, databaseLogger);
    }
}
