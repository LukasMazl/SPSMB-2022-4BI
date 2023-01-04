package cz.spsmb.app.service;

import cz.spsmb.app.conf.Configuration;
import cz.spsmb.app.logger.Logger;
import cz.spsmb.app.repository.UserRepository;

public class SimpleUserService implements UserService {

    private Logger logger;
    private Configuration configuration;
    private UserRepository userRepository;

    public SimpleUserService(Logger logger, Configuration configuration, UserRepository userRepository) {
        this.logger = logger;
        this.configuration = configuration;
        this.userRepository = userRepository;
    }

    @Override
    public void printCountOfUsers() {
        logger.debug("Getting user count");
        int count = userRepository.count();

        if(configuration.get("min-count") > count) {
            logger.warn("Min. count of user is reached.");
        }

        logger.debug("printCountOfUsers is done.");
    }
}
