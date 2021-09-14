package skole.programmering.helpers.exempleclasses;

public class Student extends Person{
    private final Studium studium;

    public Student(String firstName, String lastName, Studium studium) {
        super(firstName, lastName);
        this.studium = studium;
    }
    @Override
    public String toString() {
        return super.toString() + " " + studium.name();
    }

    public Studium studium() { return studium; }

}
