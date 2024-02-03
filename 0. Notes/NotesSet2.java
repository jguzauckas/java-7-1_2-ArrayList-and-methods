import java.util.ArrayList;

public class NotesSet2 {
    public static void main(String[] args) {
        ArrayList<Double> doubleList = new ArrayList<Double>();
        doubleList.add(67.2);
        double val = 21.4;

        val = doubleList.set(0, val);
        System.out.println(doubleList.get(0) + " " + val);

        val = doubleList.set(0, val);
        System.out.println(doubleList.get(0) + " " + val);

        val = doubleList.set(0, val);
        System.out.println(doubleList.get(0) + " " + val);
    }
}
