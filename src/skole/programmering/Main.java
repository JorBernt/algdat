package skole.programmering;

import skole.programmering.helpers.Tabell;
import skole.programmering.helpers.exempleclasses.Komparator;
import skole.programmering.helpers.exempleclasses.Person;
import skole.programmering.helpers.exempleclasses.Student;
import skole.programmering.helpers.exempleclasses.Studium;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Person[] p = new Person[5];                   // en persontabell

        p[0] = new Person("Kari", "Svendsen");         // Kari Svendsen
        p[1] = new Person("Boris", "Zukanovic");       // Boris Zukanovic
        p[2] = new Person("Ali", "Kahn");              // Ali Kahn
        p[3] = new Person("Azra", "Zukanovic");        // Azra Zukanovic
        p[4] = new Person("Kari", "Pettersen");        // Kari Pettersen

        int m = Tabell.max(p);                       // posisjonen til den største
        System.out.println(p[m] + " er størst");      // skriver ut den største

        System.out.println(Arrays.toString(p));       // skriver ut sortert
        Arrays.stream(p).max(Comparator.naturalOrder()).ifPresent(System.out::println);
        for (Studium s : Studium.values()) {
            System.out.println(s.toString() + " (" + s.name() + ")");
        }
        Student[] s = new Student[5];
        s[0] = new Student("Kari", "Svendsen", Studium.ANVENDT);         // Kari Svendsen
        s[1] = new Student("Boris", "Zukanovic", Studium.DATA);       // Boris Zukanovic
        s[2] = new Student("Ali", "Kahn", Studium.IT);              // Ali Kahn
        s[3] = new Student("Azra", "Zukanovic", Studium.ANVENDT);        // Azra Zukanovic
        s[4] = new Student("Kari", "Pettersen", Studium.ELEKTRO);
        Komparator<Student> c = (a,b) -> {
            int cmp = a.studium().toString().compareTo(b.studium().toString());
            if(cmp != 0) return cmp;
            cmp = a.firstName().compareTo(b.firstName());
            if(cmp != 0) return cmp;
            return a.lastName().compareTo(b.lastName());
        };
        Tabell.insertionSort(s, c);
        Arrays.stream(s).forEach(System.out::println);

        String[] names = {"21","18","8","13","20","6","16","25","3","10"};
        Tabell.insertionSort(names, (a,b) -> {
            int cmp = Integer.compare(a.length(), b.length());
            if(cmp != 0) return cmp;
            return a.compareTo(b);
        });
        Arrays.stream(names).forEach(System.out::println);
    }
}
