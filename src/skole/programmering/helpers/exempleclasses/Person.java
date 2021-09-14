package skole.programmering.helpers.exempleclasses;

import java.util.Objects;

public class Person implements Comparable<Person>{

    private final String firstName, lastName;

    public Person(String firstName, String lastName) {
        if(firstName == null) {
            throw new NullPointerException("Firstname is null");
        }
        if(lastName == null) {
            throw new NullPointerException("Lastname is null");
        }
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String firstName() { return firstName; }
    public String lastName() { return lastName; }

    @Override
    public int compareTo(Person p) {
        int cmp = lastName.compareTo(p.lastName);
        if(cmp != 0) return cmp;
        return firstName.compareTo(p.firstName);
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Person p = (Person) o;
        return equals(p);

    }

    public boolean equals(Person p) {
        if(p == null) return false;
        return firstName.equals(p.firstName()) && lastName.equals(p.lastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() { return String.join(" ", firstName, lastName); }
}
