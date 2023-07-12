import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String N, M;

    static void input() {
        N = sc.nextLine();
        M = sc.nextLine();
    }

    static void process() {
        String str = N.replace(M, "");
        
        int ans = (N.length() - str.length()) / M.length();
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}