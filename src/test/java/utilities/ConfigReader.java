package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    //1-properties objesi olusturmak
    //bu obj nin projenin her yerinden cagrilabilmesi icin static yapiyoruz
    //bu obj ye class disindan mudahale olmamasi icin private yapiyoruz(opsiyonel)

   static private Properties properties;

   static {
       String path="src/configuration.properties";
       try {
           FileInputStream fileInputStream=new FileInputStream(path);//configuration.properties filenina gitmek icin

           properties=new Properties();

           //Bu class calistiginda static block calisacak ve bir tek islem yapacak.
           //fileInputStream obj si calisacak ve okudugu bilgileri
           //properties objesine yukleyecek.
           properties.load(fileInputStream);

           fileInputStream.close();


       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

   public static String getProperty(String key){

       String value=properties.getProperty(key);

       return value;
   }


}
