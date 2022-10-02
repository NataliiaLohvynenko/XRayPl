package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ParamReader {
    public static String getParameter(String paramName){


        try (InputStream input = ParamReader.class.getClassLoader().getResourceAsStream("parameters.properties")){
            Properties appProps = new Properties();
            appProps.load(input);
            return appProps.getProperty(paramName);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return " ";
    }

}
