import java.util.ArrayList;

public class Try {
    public static void main (String[] args){
        ArrayList<> intList = new ArrayList<>(); // Should hold int values
        intList(17); // Append the number 17 to the end of the list
        intList(0, 14); // Insert the number 14 at index 0 in the list
        System.out.println(intList()); // Print the size of the list
        System.out.println(intList(1)); // Print the element at index 1
        System.out.println(intList(1, 18)); // Change the element at index 1 to 18
        System.out.println(intList(0)); // Delete the element at index 0
    }
}
