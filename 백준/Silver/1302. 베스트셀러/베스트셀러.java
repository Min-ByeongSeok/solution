import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N;
    static Map<String, Integer> map = new HashMap<>();

    static void input(){
        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            String bookName = sc.next();

            map.put(bookName, map.getOrDefault(bookName, 0) + 1);
        }
    }

    static void process(){
        String title = "";
        int max = -1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String bookName = entry.getKey();
            int count = entry.getValue();

            if(count > max || (count == max && bookName.compareTo(title) < 0)){
                title = bookName;
                max = count;
            }
        }

        System.out.println(title);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
