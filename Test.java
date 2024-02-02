import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int x = 5;
        arr.add(x);
        x++;
        System.out.println(x);
        System.out.println(arr.get(0));
    }
}