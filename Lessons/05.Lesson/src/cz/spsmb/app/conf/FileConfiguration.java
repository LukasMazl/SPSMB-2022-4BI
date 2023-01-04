package cz.spsmb.app.conf;

import cz.spsmb.app.logger.Logger;

public class FileConfiguration implements Configuration {

    private boolean inited;
    private Logger logger;

    public FileConfiguration(Logger logger) {
        this.inited = false;
        this.logger = logger;
    }

    public void init() {
        this.inited = true;
    }

    @Override
    public Integer get(String key) {
        if (!inited) {
            throw new IllegalArgumentException("You must call 'init()' before using config.");
        }
        logger.info("This is file configuration");
        return 12;
    }
}
