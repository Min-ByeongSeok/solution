import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N;
    static String[] arr;

    static void input() {
        N = sc.nextInt();

        arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.next();
        }
    }

    static void process() {
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length())
                    return o1.compareTo(o2);

                return o1.length() - o2.length();
            }
        });

        Object[] array = Arrays.stream(arr).distinct().toArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
