import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String str;
    static int T;
    static List<Character> list;
    static ListIterator<Character> it;
    static StringBuilder sb = new StringBuilder();

    static void input() {
        str = sc.next();
        T = sc.nextInt();
        list = new LinkedList<>();

        for (char ch : str.toCharArray()) {
            list.add(ch);
        }

        it = list.listIterator(str.length());
    }

    static void process() {
        char word = sc.next().charAt(0);

        switch (word) {
            case 'L':
                if (it.hasPrevious())
                    it.previous();
                break;
            case 'D':
                if (it.hasNext())
                    it.next();
                break;
            case 'B':
                if (it.hasPrevious()) {
                    it.previous();
                    it.remove();
                }
                break;
            case 'P':
                it.add(sc.next().charAt(0));
                break;
        }
    }

    public static void main(String[] args) {
        input();
        while (T-- > 0)
            process();

        for (Character character : list) {
            sb.append(character);
        }

        System.out.println(sb);
    }
}