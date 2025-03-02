import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class WriteProperties {
    public static void main(String[] args) throws IOException {
        Properties props = new Properties();
        OutputStream writeProperties = null;

        try{
            writeProperties = new FileOutputStream("config.properties");

            props.setProperty("DBServer", "ins_240_localhost:5500");
            props.setProperty("DBName", "MS SQL Server 2022");
            props.setProperty("DBUsername", "root");
            props.setProperty("DBPassword", "root");

            props.store(writeProperties, null);
            System.out.println("Properties file has been created successfully");
        } catch(IOException io){
            io.printStackTrace();
        }finally{
            if (writeProperties != null){
                try{
                    writeProperties.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
