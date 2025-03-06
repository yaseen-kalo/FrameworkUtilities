import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class readJsonData {
    public static void main(String[] args) throws ParseException, IOException {
        String filePath = System.getProperty("user.dir") + "//testData.json";
        FileReader fileReader = new FileReader(filePath);

        JSONParser jsonParser = new JSONParser();
        JSONObject json = (JSONObject) jsonParser.parse(fileReader);
        //System.out.println(json);

        JSONArray testData = (JSONArray) json.get("testdata");
        //System.out.println(testData);

        JSONObject loginTest = (JSONObject) testData.get(0);
        //System.out.println(loginTest.toJSONString());
        //System.out.println(loginTest.get("testName"));

        JSONArray loginTestData = (JSONArray) loginTest.get("data");
        //System.out.println(loginTestData);

        System.out.println("******Printing Test Data******");
        System.out.println("Test Case Name : " + loginTest.get("testName"));
        System.out.println("\n");

        Iterator iterator = loginTestData.iterator();
        while (iterator.hasNext()) {
            JSONObject loginTestDataDetail = (JSONObject) iterator.next();
            System.out.println("Run mode : " + loginTestDataDetail.get("run_mode"));
            System.out.println("Browser : " + loginTestDataDetail.get("browser"));
            System.out.println("UserName : " + loginTestDataDetail.get("username"));
            System.out.println("Password : " + loginTestDataDetail.get("password"));
            System.out.println("\n");


        }

    }
}
