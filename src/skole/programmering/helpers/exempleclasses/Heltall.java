package skole.programmering.helpers.exempleclasses;

public class Heltall implements Comparable<Heltall>{
    private final int value;

    public Heltall(int value) {
        this.value = value;
    }

    public int intValue() {
        return value;
    }


    @Override
    public int compareTo(Heltall o) {
        return value < o.value ? -1 : (value == o.value ? 0 : 1);
    }

    public boolean equals(Object o) {
       if(o == this) return true;
       if(!(o instanceof Heltall)) return false;
       return ((Heltall) o).value == value;
    }

    public boolean equals(Heltall o) {
        return o.value == value;
    }

    public int hashCode() {
        return 31+value;
    }

    public String toString() {
        return Integer.toString(value);
    }
}
