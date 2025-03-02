import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
    public static void main(String[] args) {
        Properties props = new Properties();
        InputStream readFile = null;

        try{
            readFile = new FileInputStream("config.properties");
            props.load(readFile);
            System.out.println("Reading properties file");
            System.out.println("DB Name: " + props.getProperty("DBName"));
            System.out.println("DB Server Name: " + props.getProperty("DBServer"));
            System.out.println("DB Username: " + props.getProperty("DBUsername"));
            System.out.println("DB Password: " + props.getProperty("DBPassword"));
        }catch(IOException io){
            io.printStackTrace();
        }finally{
            if(readFile != null){
                try{
                    readFile.close();
                }catch(IOException io){
                    io.printStackTrace();
                }

            }
        }
    }
}
