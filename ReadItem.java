import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;

public class ReadItems {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("Items.json")) {
            // Create a JSONParser instance to parse JSON data
            JSONParser parser = new JSONParser();

            // Parse the JSON data from the file and store it in an Object
            Object obj = parser.parse(reader);

            // Cast the parsed data to a JSONArray
            JSONArray itemList = (JSONArray) obj;

            // Iterate through the items in the list
            for (int i = 0; i < itemList.size(); i++) {
                // Get a JSON object from the JSONArray
                JSONObject inventoriesObject = (JSONObject) itemList.get(i);

                // Get a JSONArray named "BOH" from the JSON object
                JSONArray bohArray = (JSONArray) inventoriesObject.get("BOH");

                // Iterate through the items in the "BOH" array
                for (int j = 0; j < bohArray.size(); j++) {
                    // Get a JSON object representing an item
                    JSONObject item = (JSONObject) bohArray.get(j);

                    // Extract and convert values from the JSON object
                    int itemId = Integer.parseInt(item.get("Item_Id").toString());
                    String name = (String) item.get("Name");
                    int quantity = Integer.parseInt(item.get("Quantity").toString());
                    String latestShipment = (String) item.get("Latest-Shipment");
                    String description = (String) item.get("Description");

                    // Display the item information
                    System.out.println("Item ID: " + itemId);
                    System.out.println("Name: " + name);
                    System.out.println("Quantity: " + quantity);
                    System.out.println("Latest Shipment: " + latestShipment);
                    System.out.println("Description: " + description);
                    System.out.println();
                }
            }
        } catch (IOException | ParseException e) {
            // Handle exceptions (IOException and ParseException) by printing the stack trace
            e.printStackTrace();
        }
    }
}
