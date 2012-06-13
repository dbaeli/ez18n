package org.ez18n.sample;

import org.apache.commons.io.IOUtils;

import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 */
public class OldFashionSample {


  public static void main(String[] args) throws IOException {

    ResourceBundle bundle_default = ResourceBundle.getBundle("i18n");
    System.out.println("Default : " + bundle_default.getString("helloWorld"));

    ResourceBundle bundle_fr = ResourceBundle.getBundle("i18n", Locale.FRENCH);
    System.out.println("FR : " + bundle_fr.getString("helloWorld"));

    ResourceBundle bundle_ja = ResourceBundle.getBundle("i18n", Locale.JAPANESE);
    System.out.println("JA : " + bundle_ja.getString("helloWorld"));
    System.out.println("JA is stored as " + IOUtils.toString(OldFashionSample.class.getResourceAsStream("/i18n_ja.properties")).substring(11));


    ResourceBundle bundle_it = ResourceBundle.getBundle("i18n", Locale.ITALY);
    System.out.println("IT : " + bundle_it.getString("helloWorld"));

    //testResourceBundleReload();

  }

  public static void testResourceBundleReload() throws IOException {
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
    FileWriter fw2 = new FileWriter(propertiesFile);
    p.store(fw2, "");
    fw2.flush();
    fw2.close();
    ResourceBundle rb2 = ResourceBundle.getBundle("myproperty");
    System.out.println("Bundle2 : " + rb2.getString("key"));
    System.out.println("Bundle1 : " + rb.getString("key"));
  }
}
