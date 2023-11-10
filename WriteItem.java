import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;

public class writeItem {
    public static void main(String[] args) {
        // Create a JSON array to hold the items
        JSONArray itemList = new JSONArray();

        // First Item
        JSONObject item1 = new JSONObject();// Create a JSON object for the first item
        item1.put("Item_Id", 1); // Set the "Item_Id" key to 1
        item1.put("Name", "Strawberry"); // Set the "Name" key to "Strawberry"
        item1.put("Quantity", 50); // Set the "Quantity" key to 50
        item1.put("Latest-Shipment", "2023-09-09T12:00:00Z"); // Set the "Latest-Shipment" key to a date and time
        item1.put("Description", "New shipment"); // Set the "Description" key to "New shipment"

        // Second Item 
        JSONObject item2 = new JSONObject();  // Create a JSON object for the second item
        item2.put("Item_Id", 2); // Set the "Item_Id" key to 2
        item2.put("Name", "Apple"); // Set the "Name" key to "Apple"
        item2.put("Quantity", 75); // Set the "Quantity" key to 75
        item2.put("Latest-Shipment", "2023-09-10T12:00:00Z"); // Set the "Latest-Shipment" key to a date and time
        item2.put("Description", "Fresh stock"); // Set the "Description" key to "Fresh stock"

         // Create a JSON array to hold the items
         JSONArray itemArray = new JSONArray();
         itemArray.put(item1);
         itemArray.put(item2);

        // Create an inventories(higher level) JSON object with "BOH" key and add the "BOH" array to it
        JSONObject inventoriesObject = new JSONObject();
        // Create inventories(higher level) JSON object with the "BOH" key and set its value to the "BOH" array
        inventoriesObject.put("BOH", itemArray);
        

        // Add the inventories(higher level) object to the list
        itemList.add(inventoriesObject); // Add the Inventories(higher level) JSON object to the list of items
       

        // Write JSON data to a file
        // Write the JSON data in the "itemList" to a file named "Items.json"
        try (FileWriter file = new FileWriter("Items.json")) {
            file.write(itemList.toString(2));
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}



/*
 * {
 * "Inventories": [
 * {
 * "Inventory_Id": 1,
 * "Name": "Shoprite",
 * "Password": "HelloHello8",
 * "Items": {
 * "BOH": [
 * {
 * "Item_Id": 1,
 * "Name": "Strawberry",
 * "Quantity": 50,
 * "Latest-Shipment": "2023-09-09T12:00:00Z",
 * "Description": "New shipment"
 * },
 * {
 * "Item_Id": 2,
 * "Name": "Tomatoes",
 * "Quantity": 20,
 * "Latest-Shipment": "2023-10-09T12:00:00Z",
 * "Description": "New shipment"
 * },
 * {
 * "Item_Id": 3,
 * "Name": "Bananas",
 * "Quantity": 10,
 * "Latest-Shipment": "2023-11-09T12:00:00Z",
 * "Description": "New shipment"
 * },
 * {
 * "Item_Id": 1,
 * "Name": "Strawberry",
 * "Quantity": 5,
 * "Latest-Shipment": "2023-11-09T12:00:00Z",
 * "Description": "New shipment"
 * }
 * ]
 * }
 * },
 * {
 * "Inventory_Id": 2,
 * "Name": "Pizzeria",
 * "Password": "CSI23",
 * "Items": {
 * "BOH": [
 * {
 * "Item_Id": 1,
 * "Name": "Tomato Sauce Can",
 * "Quantity": 10,
 * "Latest-Shipment": "2023-11-09T12:00:00Z",
 * "Description": "New Shipment"
 * }
 * ]
 * }
 * }
 * ]
 * }
 */