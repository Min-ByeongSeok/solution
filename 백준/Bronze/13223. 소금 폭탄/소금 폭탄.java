package baekjoon.string;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ13223 {
    static Scanner sc = new Scanner(System.in);
    static String nowTime, soltTime;
    static int[] now, solt;

    static void input() {
        nowTime = sc.next();
        soltTime = sc.next();

        now = Arrays.stream(nowTime.split(":")).mapToInt(Integer::new).toArray();
        solt = Arrays.stream(soltTime.split(":")).mapToInt(Integer::new).toArray();
    }

    static void process() {
        int[] ans = new int[3];

        if(solt[2] - now[2] < 0){
            solt[1]--;
            ans[2] = 60 - now[2] + solt[2];
        } else {
            ans[2] = solt[2] - now[2];
        }

        if(solt[1] - now[1] < 0){
            solt[0]--;
            ans[1] = 60 - now[1] + solt[1];
        } else {
            ans[1] = solt[1] - now[1];
        }

        if(solt[0] - now[0] < 0){
            solt[0] += 24;
        }
        ans[0] = solt[0] - now[0];

        if(ans[0] == 0 && ans[1] == 0 && ans[2] == 0)
            ans[0] = 24;

        System.out.printf("%02d:%02d:%02d", ans[0],ans[1],ans[2]);
    }

    // 계층적으로 표현되는 각 단위를 계산할 때 가장 작은 단위로 통일하면 더 편할 수 있다.
    static void process2(){
        int nowSecond = now[0]*3600 + now[1]*60 + now[2];
        int soltSecond = solt[0]*3600 + solt[1]*60 + solt[2];

        int ans = soltSecond - nowSecond;
        if(ans <= 0) ans += 24*3600;

        System.out.printf("%02d:%02d:%02d", ans/3600, (ans%3600)/60, ans%60);
    }

    public static void main(String[] args) {
        input();
        process2();
    }
}
