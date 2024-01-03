package utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Utility {

  static WebDriver driver;

    //TODO: Method To generate random firstname
//    public static String getRandomFirstName() {
//        String[] firstNames = {
//                "Noah", "Ahmed", "Shady", "Dalida", "Amr", "Nesma", "Nada", "Elijah", "Alexander", "Oliver"
//        };
//
//        Random random = new Random();
//        int index = random.nextInt(firstNames.length);
//        return firstNames[index];
//    }

    //TODO: Method to generate random lastname
//    public static String getRandomLastName() {
//        String[] lastNames = {
//                "Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Taylor", "Anderson", "Thomas"
//        };
//
//        Random random = new Random();
//        int index = random.nextInt(lastNames.length);
//        return lastNames[index];
//    }


    //TODO: Method To select Random Index

//    public static int generaterandom(int max) {
//        Random random = new Random();
//        return random.nextInt(max) + 1;
//
//    }



    //TODO: Method to generate random email
//    public static String generateRandomEmail() {
//
//        // Generate a random first name
//        String firstName = getRandomFirstName();
//
//        // Generate a random last name
//        String lastName = getRandomLastName();
//
//        // Generate a random domain from a list of common domains
//        String[] domains = {"gmail.com", "yahoo.com", "outlook.com", "hotmail.com", "aol.com"};
//        Random random = new Random();
//        String domain = domains[random.nextInt(domains.length)];
//
//        // Generate a random number between 1 and 1000 for the email address prefix
//        int prefix = random.nextInt(1000) + 1;
//
//        // Combine the generated parts to form the email address
//        String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + prefix + "@" + domain;
//
//        // Return the generated email address
//        return email;
//    }


//TODO: generate 3 random numbers from 1 to 6
public static int generateRandomNumber() {
    Random random = new Random();
    return random.nextInt(6) + 1; // Generate random number between 1 and 6 inclusive


}


    // TODO: Capture Screenshot
    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        Date currntDate=new Date();
        screenshotName=screenshotName+" "+currntDate.toString().replace(" ","-").replace(":","-");
        try {
            FileHandler.copy(takesScreenshot.getScreenshotAs(OutputType.FILE), new File(System.getProperty("user.dir")
                    + "/src/test/resources/Screenshots/"+ screenshotName + ".png"));
        } catch (WebDriverException | IOException e) {
            e.printStackTrace();
        }
    }
    // TODO:  generate random desciption
    private static final List<String> colors = List.of("black", "white", "red", "blue", "green", "yellow", "purple", "pink", "orange", "teal");
    private static final List<String> patterns = List.of("striped", "polka dot", "floral", "plaid", "solid", "checkered");
    private static final List<String> materials = List.of("cotton", "silk", "linen", "wool", "denim", "leather", "cashmere");
    private static final List<String> styles = List.of("casual", "formal", "sporty", "chic", "vintage", "edgy", "bohemian");
    private static final List<String> adjectives = List.of("soft", "comfortable", "stylish", "versatile", "flattering", "eye-catching", "unique");
    private static final Random random = new Random();

    public static String generateDescription() {
        StringBuilder description = new StringBuilder();

        // Choose a random color, pattern, material, style, and adjective
        String color = randomElement(colors);
        String pattern = randomElement(patterns);
        String material = randomElement(materials);
        String style = randomElement(styles);
        String adjective = randomElement(adjectives);

        // Build the description using sentence variations
        description.append(chooseOne(
                "This " + adjective + " " + color + " " + pattern + " " + material + " " + style + " piece is perfect for any occasion.",
                "Add a touch of " + style + " to your wardrobe with this " + color + " " + material + " beauty.",
                "Feel confident and comfortable in this " + material + " " + pattern + " garment, perfect for both casual and dressy looks."
        ));

        return description.toString();
    }

    private static String randomElement(List<String> list) {
        return list.get(random.nextInt(list.size()));
    }

    private static String chooseOne(String... options) {
        return options[random.nextInt(options.length)];
    }

    public static String getSingleJsonData(String jsonFilePath,String jsonField) throws IOException, ParseException, ParseException {
        JSONParser jsonParser = new JSONParser();

        FileReader fileReader = new FileReader(jsonFilePath);
        Object obj = jsonParser.parse(fileReader);

        JSONObject jsonObject = (JSONObject) obj;
        return jsonObject.get(jsonField).toString();
    }

    public static String getExcelData(int RowNum, int ColNum, String SheetName) {
        XSSFWorkbook workBook;
        XSSFSheet sheet;
        String projectPath = System.getProperty("user.dir");
        String cellData = null;
        try {
            workBook = new XSSFWorkbook(projectPath + "/src/test/resources/data_driven/logindata.xlsx");
            sheet = workBook.getSheet(SheetName);
            cellData = sheet.getRow(RowNum).getCell(ColNum).getStringCellValue();

        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
        return cellData;
    }

    }



