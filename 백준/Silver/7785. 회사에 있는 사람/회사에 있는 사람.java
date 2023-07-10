import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int T;
    static String[] arr = new String[2];
    static Set<String> set = new TreeSet<>();

    static void input() {
        T = sc.nextInt();
    }

    static void process() {
        while (T-- > 0) {
            arr[0] = sc.next();
            arr[1] = sc.next();


            if ("enter".equals(arr[1])) {
                set.add(arr[0]);
            } else {
                set.remove(arr[0]);
            }
        }

        String[] name = set.toArray(new String[set.size()]);
        for (int i = name.length - 1; i >= 0; i--) {
            System.out.println(name[i]);
        }
    }

    public static void main(String[] args) {
        input();
        process();
    }
}