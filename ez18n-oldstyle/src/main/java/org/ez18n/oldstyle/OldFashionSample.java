package org.ez18n.oldstyle;

import java.io.*;
import java.text.MessageFormat;
import java.util.*;

/**
 */
public class OldFashionSample {


  public static void main(String[] args) throws IOException {

    System.out.println();

    ResourceBundle bundle_default = ResourceBundle.getBundle("i18n");
    System.out.println("Default : " + bundle_default.getString("helloWorld"));

    ResourceBundle bundle_fr = ResourceBundle.getBundle("i18n", Locale.FRENCH);
    System.out.println("FR : " + bundle_fr.getString("helloWorld"));

    ResourceBundle bundle_ja = ResourceBundle.getBundle("i18n", Locale.JAPANESE);
    System.out.println("JA : " + bundle_ja.getString("helloWorld"));

    ResourceBundle bundle_it = ResourceBundle.getBundle("i18n", Locale.ITALIAN);
    System.out.println("IT : " + bundle_it.getString("helloWorld"));

    //messageFormatSamples();

    String pattern =  bundle_default.getString("diskFile");

    System.out.println();
    System.out.println("MessageFormat Test:");
    System.out.println("* " + MessageFormat.format(pattern, "disk0", 0));
    System.out.println("* " + MessageFormat.format(pattern, "disk1", 1));
    System.out.println("* " + MessageFormat.format(pattern, "disk2", 120));
  }

  public static void testResourceBundleReload() {
    try {

    System.out.println("Clearing the resource bundle cache");

    File propertiesFile = new File("ez18n-sample/target/classes/myproperty.properties");

    Properties p = new Properties();
    p.setProperty("key", "the string");
    FileWriter fw = new FileWriter(propertiesFile);
    p.store(fw, "");
    fw.flush();
    fw.close();

    ResourceBundle rb = ResourceBundle.getBundle("myproperty");
    System.out.println("Bundle1 : " + rb.getString("key"));

    rb.clearCache();

    p.setProperty("key", "the string 2");

    System.out.println("Bundle1 : " + rb.getString("key"));

    } catch (IOException e) {
    }
  }
}
