package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    //This class reads the configguration.properties file.

    //1-properties objesi olusturmak
    //bu obj nin projenin her yerinden cagrilabilmesi icin static yapiyoruz
    //bu obj ye class disindan mudahale olmamasi icin private yapiyoruz(opsiyonel)
    //Creat Properties instance.
   static private Properties properties;


   static {
       //path of the confirugation file.
       String path="src/configuration.properties";
       try {
           //Opening confirugation.properties file using FileInputStream
           //opening the  file
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

   //This method will get the key from properties file,
    //And return the value as String
    //We creat this method to read the file
   public static String getProperty(String key){

       String value=properties.getProperty(key);

       return value;
   }

//   //Test if logic Works
//    //public static void main(String[] args) {
//        System.out.println(properties.getProperty("qa_environment"));
//    }
}
