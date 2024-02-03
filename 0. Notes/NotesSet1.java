import java.util.ArrayList;

public class NotesSet1 {
    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<Integer>();
        intList.add(152);
        intList.add(234);
        intList.add(876);
        intList.set(1, 900);
        System.out.println(intList.set(2, 654));
    }
}
