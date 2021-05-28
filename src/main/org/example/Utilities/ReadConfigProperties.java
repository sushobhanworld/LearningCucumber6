package org.example.Utilities;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigProperties implements IReader{
    private Properties properties;

    private void initPropertiesFile(String fileName){
        if(fileName==null)
            properties= getDataFromPropertiesFile(System.getProperty("user.dir")+"/src/main/resources/config.properties");
        properties= getDataFromPropertiesFile(fileName);
    }

    public ReadConfigProperties(){
        initPropertiesFile("");
    }
    public ReadConfigProperties(String fileName){
        initPropertiesFile(fileName);
    }

    private Properties getDataFromPropertiesFile(String s) {
        String filePath= System.getProperty("user.dir")+"/src/main/resources/config.properties";
        Properties prop= new Properties();
        try {
            InputStream fileInputStream= new FileInputStream(filePath);
            prop.load(fileInputStream);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return prop;
    }


    @Override
    public String getApplicationURL() {
        return properties.getProperty("ApplicationUrl");
    }

    @Override
    public String getBrowserType() {
        return properties.getProperty("browser");
    }

    @Override
    public String getUsername() {
        return properties.getProperty("Username");
    }

    @Override
    public String getPassword() {
        return properties.getProperty("Password");
    }

    public static void main(String[] args) {
        String s=new ReadConfigProperties(System.getProperty("user.dir")+"/src/main/resources/config.properties").getBrowserType();
        System.out.println(s);
    }
}
