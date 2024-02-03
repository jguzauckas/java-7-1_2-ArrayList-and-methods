import java.util.ArrayList;

public class NotesRemove1 {
    public static void main(String[] args) {
        ArrayList<String> strList = new ArrayList<String>();
        strList.add("Hi");
        strList.add("Hey");
        strList.add("Hello");
        // The ArrayList is ["Hi", "Hey", "Hello"]
        strList.remove(1);
        // Now the ArrayList is ["Hi", "Hello"]
        System.out.println(strList.remove(1));
    }
}
