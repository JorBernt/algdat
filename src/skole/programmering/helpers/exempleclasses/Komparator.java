package skole.programmering.helpers.exempleclasses;
@FunctionalInterface
public interface Komparator<T> {
    int compare(T x, T y);
}
