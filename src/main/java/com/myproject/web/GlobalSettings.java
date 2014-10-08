package com.myproject.web;

/**
 * Created by IntelliJ IDEA.
 * User: lnex
 * Date: 14.06.13
 * Time: 14:51
 * To change this template use File | Settings | File Templates.
 */

public class GlobalSettings {

    private static String title = "MyProject";
    private static String prefix = "myproject";

    public static String lRStrip(String str){
        return str.replaceAll("^|\\s*(\\S+)\\s*|$", "$1");
    }

    public static String getTitle() {
        return title;
    }

    public static void setTitle(String title) {
        GlobalSettings.title = title;
    }

    public static String getPrefix() {
        return prefix;
    }

    public static void setPrefix(String prefix) {
        GlobalSettings.prefix = prefix;
    }
}
