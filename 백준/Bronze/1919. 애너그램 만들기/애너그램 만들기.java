import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String N, M;
    static int[] NCount, MCount;

    static void input(){
        N = sc.next();
        M = sc.next();

        NCount = new int[26];
        MCount = new int[26];
    }

    static void process(){
        for (char x : N.toCharArray()){
            NCount[x - 'a']++;
        }

        for (char y : M.toCharArray()){
            MCount[y - 'a']++;
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if(NCount[i] == MCount[i]) continue;

            if(NCount[i] > MCount[i]){
                ans += NCount[i] - MCount[i];
            } else {
                ans += MCount[i] - NCount[i];
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
