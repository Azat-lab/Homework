/*
 * Copyright (c) 2023. Java Web Test Automation project.
 * Homework assessment.
 * Created by Azat Ann.
 */
package utils;

import java.util.ResourceBundle;
public class PropertiesManager {
    static String propertiesFile = "app";
    public static ResourceBundle properties = ResourceBundle.getBundle(propertiesFile);
}