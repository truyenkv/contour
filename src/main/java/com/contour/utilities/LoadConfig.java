package com.contour.utilities;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class LoadConfig {

    private final Config config;
    public final static LoadConfig CONFIG = getInstance();

    public LoadConfig() {
        this.config = ConfigFactory.load("configs/appInfo.conf");
    }

    public String getPropertyByEnv(String key) {
        String environment = System.getProperty("env");
        Config conf = config.getConfig(environment);
        return conf.getString(key);
    }

    public static LoadConfig getInstance(){
        return new LoadConfig();
    }

}
