package fashionette.qa.automation.utils;

import fashionette.qa.automation.base.BaseTest;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class CommonMethods extends BaseTest {

    /**
     *
     * @return random String of 2 characters
     */

    public String generateRandomChars() {

        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            sb.append(chars.charAt(random.nextInt(chars
                    .length())));
        }

        return sb.toString();
    }

    /**
     * This method is to read test data from csv file
     * (We can also use excel for passing test data, since the test data for the implemented scenario are very less we
     * have used csv)
     * @param key Name of the parameter
     * @return value of the parameter provided
     */
    public  String getData(String key) {

        try {

            //Defining HashMap to store all the values of CSV file in key value pairs
            Map<String, String> keyValueData = new HashMap<>();

            //Creating File Object To Read The TestData CSV file
            File file = new File(prop.getProperty("testdataPath"));

            //Checking if the file exists in the given path
            if (!file.exists())
                System.out.println("Test Data File Is not Found");

            String line;

            //Reading the csv file data and taking it in HashMap
            try (BufferedReader br1 = new BufferedReader(new FileReader(file))) {
                while ((line = br1.readLine()) != null) {
                    String[] data = line.split(Pattern.quote(","));
                    keyValueData.put(data[0], data[1]);
                }
                return keyValueData.get(key);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}


