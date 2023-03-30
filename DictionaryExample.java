import java.util.HashMap; // dictionary/table

public class DictionaryExample {
    public static void main(String[] args) {
        HashMap<Integer, String> courses = new HashMap<>();

        // add coures to the dictionary
        courses.put(1302, "Principles");
        courses.put(2302, "Programming");
        courses.put(3302, "Data Structures");
        courses.put(2311, "Event Driven");
        courses.put(2314, "Architecture");
        courses.put(3333, "Discrete");

        // construction
        System.out.println(courses);

        // contains (check if something is in the dictionary)
        System.out.println("--------Contains");
        for (int i = 2000; i < 3000; i++)
            if (courses.containsKey(i))
                System.out.println("Number: " + i + " Name: " + courses.get(i));

        // remove
        System.out.println("--------remove");
        courses.remove(2314);

        // travese keys
        for (Integer key : courses.keySet())
            System.out.println("Key: " + key + " Value: " + courses.get(key));

        // travese values
        System.out.println();
        System.out.println();
        for (String val : courses.values()) 
            System.out.println(val);

    }
}
