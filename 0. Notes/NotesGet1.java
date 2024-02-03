import java.util.ArrayList;

public class NotesGet1 {
    public static void main(String[] args) {
        ArrayList<Person> peopleList = new ArrayList<Person>();
        peopleList.add(new Person("Mr. G", 25));
        peopleList.add(new Person("Sam", 34));
        peopleList.add(new Person("Will", 26));
        System.out.println(peopleList.get(2));
        System.out.println(peopleList.get(1).getName());
        System.out.println(peopleList.get(0).getAge());
    }
}
