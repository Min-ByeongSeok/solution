import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String nowTime, soltTime;
    static int[] now, solt;

    static void input() {
        nowTime = sc.next();
        soltTime = sc.next();

        now = Arrays.stream(nowTime.split(":")).mapToInt(Integer::new).toArray();
        solt = Arrays.stream(soltTime.split(":")).mapToInt(Integer::new).toArray();
    }

    // 소금 14:36:22 04:00:00
    // 현재 12:34:56 20:00:00
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

    public static void main(String[] args) {
        input();
        process();
    }
}
