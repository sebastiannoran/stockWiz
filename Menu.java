import java.util.ArrayList;

public abstract class Menu {
    private ArrayList<String> itemList; // Creating an ArrayList to store menu item names.
    private ArrayList<Integer> itemId;  // Creating an ArrayList to store menu item IDs.
    private ArrayList<Integer> dateAddition; // Creating an ArrayList to store date additions.

    public Menu() {
        itemList = new ArrayList<>(); // Initializing the itemList ArrayList.
        itemId = new ArrayList<>();    // Initializing the itemId ArrayList.
        dateAddition = new ArrayList<>(); // Initializing the dateAddition ArrayList.
    }

    public ArrayList<String> getItemList() {
        return itemList;
    }
    public ArrayList<Integer> getItemId() {
        return itemId;
    }
    public ArrayList<Integer> getDateAddition() {
        return dateAddition;
    }
    public void setItemList(ArrayList<String> itemList) {
        this.itemList = itemList;
    }
    public void setItemId(ArrayList<Integer> itemId) {
        this.itemId = itemId;
    }
    public void setDateAddition(ArrayList<Integer> dateAddition) {
        this.dateAddition = dateAddition;
    }
    
    public void display() {
        if (itemList.isEmpty()) { // Checking if the itemList is empty.
            System.out.println("The menu is empty.");
        } else {
            for (int i = 0; i < itemList.size(); i++) {
                // Iterating through the itemList ArrayList and displaying item details.
                System.out.println("Id: " + itemId.get(i) + " " + itemList.get(i) + " (Add on: " + dateAddition.get(i) + ")");
            }
        }
    }

    // Make the 'addItem' method abstract, as it should be implemented by concrete subclasses
    public abstract void addItem(String item, int id, int date);

    // Make the 'deleteItem' method abstract, as it should be implemented by concrete subclasses
    public abstract void deleteItem(String id);
}
