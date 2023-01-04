package cz.spsmb.app.logger;

public class ConsoleLogger implements Logger {

    @Override
    public void warn(String log, Object... args) {
        System.out.printf("'CONSOLE - %s' " + String.format(log, args) + "\n", "WARN");
    }

    @Override
    public void info(String log, Object... args) {
        System.out.printf("'CONSOLE - %s' " + String.format(log, args) + "\n", "INFO");
    }

    @Override
    public void debug(String log, Object... args) {
        System.out.printf("'CONSOLE - %s' " + String.format(log, args) + "\n", "DEBUG");
    }

    @Override
    public void error(String log, Object... args) {
        System.out.printf("'CONSOLE - %s' " + String.format(log, args) + "\n", "ERROR");
    }
}
