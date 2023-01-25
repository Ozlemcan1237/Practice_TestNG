package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties properties;
    /*
          METHOD'U DEVREYE SOKABILMEK ICIN FileInputStream ILE DOSYA YOLUNU BELIRTMEMIZ GEREKIR
       METHOD'DAN ONCE CALISMASI ICIN STATIC BLOCK ICERISINE FileInputStream'i OLUSTURMAMIZ GEREKIR.
       */
    static {
        String dosyaYolu = "config.properties";
        try {
            FileInputStream fis = new FileInputStream(dosyaYolu);
            properties=new Properties();
            properties.load(fis); //fis'in okudugu bilgileri properties'e ekler

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getProperty(String Key){

        return properties.getProperty(Key);
        /*
       Test method'undan gonderdigimiz String Key degerini alip Properties class'indan
     getProperty() method'unu kullanarak bu key'e ait value'u bize getirir.
       */
    }
}
