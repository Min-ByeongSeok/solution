import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String N;
    static int[] cnt;

    static void input(){
        N = sc.next().toUpperCase();
        cnt = new int[26];
    }

    static void process(){
        int max = -1;
        char maxAlpha = '?';

        for (char word : N.toCharArray()) {
            cnt[word - 'A']++;
        }

        for (int i = 0; i < cnt.length; i++) {
            if(cnt[i] > max){
                max = cnt[i];
                maxAlpha = (char)(i + 'A');
            } else if(max == cnt[i]) {
                maxAlpha = '?';
            }
        }

        System.out.println(maxAlpha);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
