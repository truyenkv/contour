package com.contour.utilities;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import static com.contour.constant.ConfigsEnum.ENV;

public class LoadConfig {

    private final Config config;
    public final static LoadConfig CONFIG = getInstance();

    public LoadConfig() {
        this.config = ConfigFactory.load("configs/appInfo.conf");
    }

    public String getPropertyByEnv(String key) {
        String environment = System.getProperty(ENV.getName());
        Config conf = config.getConfig(environment);
        return conf.getString(key);
    }

    public static LoadConfig getInstance(){
        return new LoadConfig();
    }

}
