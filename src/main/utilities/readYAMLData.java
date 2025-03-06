import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class readYAMLData {
    public static void main(String[] args) throws FileNotFoundException, YamlException {
        String filePath = System.getProperty("user.dir") + "//testData.yaml";
        FileReader fileReader = new FileReader(filePath);

        YamlReader yamlReader = new YamlReader(fileReader);

        Map testData = (Map) yamlReader.read();

        List testCases = (List) testData.get("testdata");
        System.out.println(testCases);

        Map loginTestdata = (Map) testCases.get(0);
        System.out.println(loginTestdata.get("data"));

        System.out.println("******** Printing Test Data ********");
        System.out.println("Test Case Name is -- " + loginTestdata.get("testName"));
        System.out.println("\n");

        List testDataList = (List) loginTestdata.get("data");

        Iterator iterator = testDataList.iterator();
        while (iterator.hasNext()) {
            Map testCase = (Map) iterator.next();
            // Store each value in a variable before printing
            String runMode = (String) testCase.get("run_mode");
            String browser = (String) testCase.get("browser");
            String username = (String) testCase.get("username");
            String password = (String) testCase.get("password");

            // Now print the values
            System.out.println("Run mode: " + runMode);
            System.out.println("Browser: " + browser);
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
            System.out.println("\n");
        }
    }
}
