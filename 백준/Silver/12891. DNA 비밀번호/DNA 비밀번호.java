import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int S, P;
    static char[] seq;
    static int[] miniCnt;

    static void input(){
        S = sc.nextInt();
        P = sc.nextInt();

        seq = sc.next().toCharArray();

        miniCnt = new int[4]; // a c g t
        for (int i = 0; i < 4; i++) {
            miniCnt[i] = sc.nextInt();
        }
    }

    static int baseToIdx(char alp) {
        if(alp == 'A') return 0;
        else if(alp == 'C') return 1;
        else if(alp == 'G') return 2;
        else if(alp == 'T') return 3;

        return -1;
    }

    static void process(){
        int ans = 0;
        int[] cnt = new int[4];

        for (int i = 0; i < P - 1; i++) {
            cnt[baseToIdx(seq[i])]++;
        }
        
        for (int i = P-1; i < S; i++) {
            // 이번 윈도우의 끝값 추가
            cnt[baseToIdx(seq[i])]++;
            if(isValid(cnt, miniCnt)){
                ans++;
            }
            // 이번 윈도우의 첫값 제거
            cnt[baseToIdx(seq[i - P + 1])]--;
        }


        System.out.println(ans);
    }

    private static boolean isValid(int[] cnt, int[] miniCnt) {

        for (int i = 0; i < 4; i++) {
            if(cnt[i] < miniCnt[i]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
