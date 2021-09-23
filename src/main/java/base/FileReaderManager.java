package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileReaderManager {

    public String getproperties(String value) throws IOException{
        File file= new File("src/main/resources/properties/data.properties");
        FileInputStream fileInput=null;
        try {
            fileInput = new FileInputStream(file);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }


        Properties prop = new Properties();
    prop.load(fileInput);
    return prop.getProperty(value);
    }
}
