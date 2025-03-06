import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.LinkedHashMap;

public class writeJSON {
    public static void main(String[] args) {

        //I used LinkedHashMap becasue I want the order as we all know that JSONObject is not maintain insertion order becasue
        //it is based on HashMap, which does not guarantee order.

        // Employee 1 Address
        LinkedHashMap<String, Object> employee01Address = new LinkedHashMap<String, Object>();
        employee01Address.put("Street", "4940 Rocky Road");
        employee01Address.put("Zipcode", "74300");
        employee01Address.put("City", "Philadelphia");
        employee01Address.put("State", "Pennsylvania");
        employee01Address.put("Country", "USA");

        JSONArray employee01Addresses = new JSONArray();
        employee01Addresses.add(employee01Address);

        // Employee 1 Details (Adding fields in order)
        LinkedHashMap<String, Object> employee01Details = new LinkedHashMap<String, Object>();
        employee01Details.put("name", "John Doe");
        employee01Details.put("salary", 10000);
        employee01Details.put("department", "Electrical Engineering");
        employee01Details.put("address", employee01Addresses);

        // Employee 2 Address
        LinkedHashMap<String, Object> employee02Address = new LinkedHashMap<String, Object>();
        employee02Address.put("Street", "1771 Alexander Avenue");
        employee02Address.put("Zipcode", "94520");
        employee02Address.put("City", "Concord");
        employee02Address.put("State", "California");
        employee02Address.put("Country", "USA");

        JSONArray employee02Addresses = new JSONArray();
        employee02Addresses.add(employee02Address);

        // Employee 2 Details (Adding fields in order)
        LinkedHashMap<String, Object> employee02Details = new LinkedHashMap<String, Object>();
        employee02Details.put("name", "Alex Brat");
        employee02Details.put("salary", 35000);
        employee02Details.put("department", "Mechanical Engineering");
        employee02Details.put("address", employee02Addresses);

        // Create EmployeesDetails Array
        JSONArray employeesDetails = new JSONArray();
        employeesDetails.add(employee01Details);
        employeesDetails.add(employee02Details);

        // Final JSON Object
        JSONObject employeeDetails = new JSONObject();
        employeeDetails.put("EmployeesDetails", employeesDetails);

        // Print JSON Output
        System.out.println(employeeDetails.toJSONString());
    }
}