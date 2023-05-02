package VickyVtigerGenericUtilitiesPratice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists of generic methods related to properties
 * @author vikra
 *
 */
public class PropertyFileUtility {
     public String readDataFromProperties(String key) throws IOException
     {
    	 FileInputStream fis=new FileInputStream(ConstantsUtility.propertiesfilepath);
    	 Properties prop=new Properties();
    	 String value=prop.getProperty(key);
    	 return value;
     }

		
}
