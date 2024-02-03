import java.util.ArrayList;

public class NotesAdd2 {
    public static void main(String[] args) {
        ArrayList<String> strList = new ArrayList<String>();
        strList.add("Hi");
        strList.add("Hello");
        strList.add("Hey");
        // The list is currently ["Hi", "Hello", "Hey"]
        strList.add(1, "Yo");
        // Now the list is ["Hi", "Yo", "Hello", "Hey"]
        strList.add(strList.size(), "Hola");
        // Now the list is ["Hi", "Yo", "Hello", "Hey", "Hola"]
    }
}
