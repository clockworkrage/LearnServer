package utils;

import org.jetbrains.annotations.NotNull;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ServerConfiguration {
    private static final String CONF_DIR = "src/main/resources/";

    @NotNull
    private Map<String, String> serverProperties = new HashMap<>();

    private static ServerConfiguration s_instance = new ServerConfiguration("config.properties");

    public static ServerConfiguration getInstance(){
        return s_instance;
    }

    private ServerConfiguration(String propertiesFile){
        try (final FileInputStream fis = new FileInputStream(CONF_DIR + propertiesFile)) {
            final Properties properties = new Properties();
            properties.load(fis);

            serverProperties.put("port", properties.getProperty("server.port"));

            serverProperties.put("dialect", properties.getProperty("hibernate.dialect"));
            serverProperties.put("driver_class", properties.getProperty("hibernate.connection.driver_class"));
            serverProperties.put("connection_url", properties.getProperty("hibernate.connection.url"));
            serverProperties.put("connection_username", properties.getProperty("hibernate.connection.username"));
            serverProperties.put("connection_password", properties.getProperty("hibernate.connection.password"));
            serverProperties.put("show_sql", properties.getProperty("hibernate.show_sql"));
            serverProperties.put("hbm2ddl_auto", properties.getProperty("hibernate.hbm2ddl.auto"));
            serverProperties.put("hbm2ddl_auto_test", properties.getProperty("hibernate.hbm2ddl.auto_test"));
            serverProperties.put("connection_url_test", properties.getProperty("hibernate.connection.url_test"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getPort() {
        return Integer.parseInt(serverProperties.get("port"));
    }

    public String getDialect(){
        return serverProperties.get("dialect");
    }

    public String getDriverClass(){
        return serverProperties.get("driver_class");
    }

    public String getConnectionUrl(){
        return serverProperties.get("connection_url");
    }

    public String getConnectionUrlTest(){
        return serverProperties.get("connection_url_test");
    }

    public String getConnectionUsername(){
        return serverProperties.get("connection_username");
    }

    public String getConnectionPassword(){
        return serverProperties.get("connection_password");
    }

    public String getShowSql(){
        return serverProperties.get("show_sql");
    }

    public String getHbm2ddAuto(){
        return serverProperties.get("hbm2ddl_auto");
    }

    public String getHbm2ddAutoTest(){
        return serverProperties.get("hbm2ddl_auto_test");
    }

}
