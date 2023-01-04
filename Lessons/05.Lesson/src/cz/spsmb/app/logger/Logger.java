package cz.spsmb.app.logger;

public interface Logger {

    void warn(String log, Object... args);

    void info(String log, Object... args);

    void debug(String log, Object... args);

    void error(String log, Object... args);

}
