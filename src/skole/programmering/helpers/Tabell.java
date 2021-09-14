package skole.programmering.helpers;

import skole.programmering.helpers.exempleclasses.Komparator;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

public class Tabell {

    private Tabell() {
    }

    public static void fromToValidate(int arrayLength, int from, int to) {
        if (from < 0) {
            throw new ArrayIndexOutOfBoundsException
                    ("from(" + from + ") < 0");
        }
        if (to > arrayLength) {
            throw new ArrayIndexOutOfBoundsException
                    ("to(" + to + ") > array length(" + arrayLength + ")");
        }
        if (from > arrayLength) {
            throw new ArrayIndexOutOfBoundsException
                    ("from(" + from + ") > to(" + to + ") - illegal interval");
        }
        if (from == to) {
            throw new NoSuchElementException
                    ("from(" + from + ") = to(" + to + ") - empty array interval");
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void swap(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

    public static void reverse(int[] a, int from, int to) {
        fromToValidate(a.length, from, to);
        for (int i = from, j = to - 1; i < j; i++, j--) {
            swap(a, i, j);
        }
    }

    public static void reverse(int[] a) {
        reverse(a, 0, a.length);
    }

    public static void reverse(char[] a, int from, int to) {
        fromToValidate(a.length, from, to);
        for (int i = from, j = to - 1; i < j; i++, j--) {
            swap(a, i, j);
        }
    }

    public static void reverse(char[] a) {
        reverse(a, 0, a.length);
    }

    public static void write(int[] a, int from, int to) {
        fromToValidate(a.length, from, to);
        for (int i = from; i < to; i++) {
            System.out.print(a[i] + (i < to - 1 ? " " : ""));
        }
    }

    public static void write(int[] a) {
        if (a == null) return;
        write(a, 0, a.length);
    }

    public static void writeln(int[] a, int from, int to) {
        write(a, from, to);
        System.out.println();
    }

    public static void writeln(int[] a) {
        write(a);
        System.out.println();
    }

    public static void write(char[] a, int from, int to) {
        fromToValidate(a.length, from, to);
        for (int i = from; i < to; i++) {
            System.out.print(a[i] + (i < to - 1 ? " " : ""));
        }
    }

    public static void write(char[] a) {
        if (a == null) return;
        write(a, 0, a.length);
    }

    public static void writeln(char[] a, int from, int to) {
        write(a, from, to);
        System.out.println();
    }

    public static void writeln(char[] a) {
        write(a);
        System.out.println();
    }

    public static int[] naturalNumbers(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Number must be >= 1, was " + n);
        }
        int[] a = new int[n];
        Arrays.setAll(a, i -> i + 1);
        return a;
    }

    public static int[] integers(int from, int to) {
        if (from > to) {
            throw new IllegalArgumentException("Illegal interval");
        }
        int[] a = new int[to - from];
        if (from == to) return a;
        for (int i = from, j = 0; i < to; i++, j++) {
            a[j] = i;
        }
        return a;
    }

    public static int[] randPerm(int n)  // en effektiv versjon
    {
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k + 1);        // en tilfeldig tall fra 0 til k
            swap(a, k, i);                   // bytter om
        }

        return a;                        // permutasjonen returneres
    }

    public static void randPerm(int[] a)  // stokker om a
    {
        Random r = new Random();     // en randomgenerator

        for (int k = a.length - 1; k > 0; k--) {
            int i = r.nextInt(k + 1);  // tilfeldig tall fra [0,k]
            swap(a, k, i);
        }
    }

    public static int randNumber(int n) {
        Random r = new Random();
        return r.nextInt(n);
    }

    public static int max(int[] array, int from, int to) {
        if (array == null) {
            throw new NullPointerException
                    ("The given array can't be null");
        }
        fromToValidate(array.length, from, to);
        int max = Integer.MIN_VALUE;
        int index = from;
        for (int i = from; i < to; i++) {
            if (array[i] > max) {
                max = array[i];
                index = i;
            }
        }
        return index;
    }

    public static int max(int[] array) {
        return max(array, 0, array.length);
    }

    public static int min(int[] array, int from, int to) {
        if (from < 0 || from >= to || to > array.length) {
            throw new IllegalArgumentException("Illegal interval");
        }

        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = from; i < to; i++) {
            if (array[i] < min) {
                min = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static int min(int[] array) {
        return min(array, 0, array.length);
    }

    public static int[] nextMax(int[] a) {
        int n = a.length;
        if (n < 2) {
            throw new NoSuchElementException(("a.length(" + n + ") < 2"));
        }
        int maxIndex = max(a);
        int nextMaxIndex;
        if (maxIndex == 0) {
            nextMaxIndex = max(a, 1, n);
        } else if (maxIndex == n - 1) {
            nextMaxIndex = max(a, 0, n - 1);
        } else {
            int left = max(a, 0, maxIndex);
            int right = max(a, maxIndex + 1, n);
            nextMaxIndex = a[left] > a[right] ? left : right;
        }
        return new int[]{maxIndex, nextMaxIndex};
    }

    public static int[] nextMaxSwapFirst(int[] a) {
        int n = a.length;
        if (n < 2) {
            throw new NoSuchElementException(("a.length(" + n + ") < 2"));
        }
        int maxIndex = max(a);
        swap(a, 0, maxIndex);
        int nextMaxIndex = max(a, 1, n);
        if (nextMaxIndex == maxIndex) nextMaxIndex = 0;
        swap(a, 0, maxIndex);
        return new int[]{maxIndex, nextMaxIndex};
    }

    public static int[] nextMaxSwapLast(int[] a) {
        int n = a.length;
        if (n < 2) {
            throw new NoSuchElementException(("a.length(" + n + ") < 2"));
        }
        int maxIndex = max(a);
        swap(a, n - 1, maxIndex);
        int nextMaxIndex = max(a, 0, n - 1);
        if (nextMaxIndex == maxIndex) nextMaxIndex = n - 1;
        swap(a, n - 1, maxIndex);
        return new int[]{maxIndex, nextMaxIndex};
    }

    public static void swapSortAsc(int[] a) {
        int n = a.length;
        for (int i = a.length; i > 0; i--) {
            int maxIndex = max(a, 0, i);
            swap(a, i - 1, maxIndex);
        }
    }

    public static void swapSortDesc(int[] a) {
        int n = a.length;
        for (int i = a.length; i > 0; i--) {
            int minIndex = min(a, 0, i);
            swap(a, i - 1, minIndex);
        }
    }

    public static void bubbleSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j > i; j--) {
                if (a[j] < a[j - 1]) {
                    swap(a, j, j - 1);
                }
            }
        }
    }

    public static void quicksort1(int[] a, int from, int to) {
        if (to - from == 2) {
            return;
        }
        int pivot = a[to - 1];
        for (int i = 0, j = to - 2; i <= j; ) {
            if (i == j) {
                if (a[i] > pivot)
                    swap(a, i, to - 1);
                quicksort1(a, from, i + 1);
                quicksort1(a, i, to);
            }
            if (a[i] > pivot) {
                if (a[j] < pivot) swap(a, i, j);
                else j--;
            } else i++;
        }
    }

    public static void quicksort(int[] a) {
        quicksort2(a, 0, a.length - 1);
    }

    private static int part(int[] a, int left, int right, int pivot) {
        while (true) {
            while (left <= right && a[left] < pivot) left++;
            while (right >= left && a[right] > pivot) right--;
            if (left < right) swap(a, left++, right--);
            else return left;
        }
    }

    private static int sPart(int[] a, int left, int right, int index) {
        swap(a, index, right);
        int pos = part(a, left, right - 1, a[right]);
        swap(a, pos, right);
        return pos;
    }

    public static void quicksort2(int[] a, int left, int right) {
        if (left >= right) return;
        int k = sPart(a, left, right, (left + right) / 2);
        quicksort2(a, left, k - 1);
        quicksort2(a, k + 1, right);
    }


    public static void insertionSort(int[] a) {
        insertionSort(a, 0);
    }

    public static void insertionSort(int[] a, int ind) {
        if (ind + 1 == a.length) return;
        int n = a[ind + 1];
        if (n < a[ind]) {
            for (int i = ind; i >= 0; i--) {
                if (a[i] > n) {
                    a[i + 1] = a[i];
                    a[i] = n;
                } else {
                    a[i + 1] = n;
                    break;
                }
            }
        }
        insertionSort(a, ind + 1);
    }

    public static <T extends Comparable<? super T>> void insertionSort(T[] a) {
        insertionSort(a, 0);
    }

    public static <T extends Comparable<? super T>> void insertionSort(T[] a, int ind) {
        if (ind + 1 == a.length) return;
        T n = a[ind + 1];
        if (n.compareTo(a[ind]) < 0) {
            for (int i = ind; i >= 0; i--) {
                if (a[i].compareTo(n) > 0) {
                    a[i + 1] = a[i];
                    a[i] = n;
                } else {
                    a[i + 1] = n;
                    break;
                }
            }
        }
        insertionSort(a, ind + 1);
    }

    public static <T> void insertionSort(T[] a, Komparator<? super T> c) {
        for (int i = 1; i < a.length; i++)  // starter med i = 1
        {
            T verdi = a[i];        // verdi er et tabellelemnet
            int j = i - 1;        // j er en indeks

            // sammenligner og forskyver:
            for (; j >= 0 && c.compare(verdi, a[j]) < 0; j--)
                a[j + 1] = a[j];

            a[j + 1] = verdi;      // j + 1 er rett sortert plass
        }
    }

    public static <T> int max(T[] a, Komparator<? super T> c) {
        T max = a[0];
        int m = 0;
        for(int i = 0; i < a.length; i++) {
            if(c.compare(max, a[0]) > 0) {
                max = a[i];
                m = i;
            }
        }
        return m;
    }

    public static int treeHeight(int n) {
        return (int) Math.ceil((Math.log(numberOfNodes(n + 1)) / Math.log(2))) - 1;
    }

    public static int numberOfNodes(int n) {
        return 2 * n - 1;
    }

    public static void delsortering1(int[] a) {
        int n = a.length;
        while (true) {
            int l = 0;
            int r = n - 1;
            while (a[l] % 2 == 1) l++;
            while (a[r] % 2 == 0) r--;
            if (l >= r) {
                System.out.println("Left: " + l);
                System.out.println("Right: " + r);
                quicksort2(a, 0, l - 1);
                quicksort2(a, r + 1, n - 1);
                break;
            }
            int temp = a[l];
            a[l] = a[r];
            a[r] = temp;
        }
    }


    public static <T extends Comparable<? super T>> int max(T[] a) {
        int m = 0;
        T max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[1].compareTo(max) > 0) {
                max = a[i];
                m = i;
            }
        }
        return m;
    }

    public static Integer[] randPermInteger(int n) {
        Integer[] a = new Integer[n];               // en Integer-tabell
        Arrays.setAll(a, i -> i + 1);               // tallene fra 1 til n

        Random r = new Random();   // hentes fra  java.util

        for (int k = n - 1; k > 0; k--) {
            int i = r.nextInt(k + 1);  // tilfeldig tall fra [0,k]
            swap(a, k, i);             // bytter om
        }
        return a;  // tabellen med permutasjonen returneres
    }

    public static void swap(Object[] a, int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


}
