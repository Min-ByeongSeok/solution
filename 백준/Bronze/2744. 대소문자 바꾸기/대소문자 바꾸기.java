/**
 * 문제 : 알파벳으로만 이루어진 문자열이 주어질 때 소문자는 대문자로,
 * 대문자는 소문자로 변경한 문자열을 출력
 *
 * 1. 문자가 주어졌을 때, 소문자/대문자를 어떻게 판별할 수 있을까
 * 2. 소문자 혹은 대문자가 주어졌을 때 대문자 혹은 소문자로 어떻게 바꿀 수 있을까
 */
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String N;
    static StringBuilder sb = new StringBuilder();

    static void input(){
        // 띄어쓰기나 공백으로 구분된 첫번째 단어 혹은 문자
        N = sc.next();
    }

    static void process(){
        for (int i = 0; i < N.length(); i++) {

            char ch = N.charAt(i);

            // 대문자인지 판별
            if('A' <= ch && ch <= 'Z'){
//                System.out.print((char)('a' + ch - 'A'));
                sb.append((char)('a' + ch - 'A'));
            }
            // 대문자가 아니라면 즉, 소문자라면
            else {
//                System.out.print((char)('A' + ch - 'a'));
                sb.append((char)('A' + ch - 'a'));
            }
        }

        System.out.println(sb.toString());
    }
    
    public static void main(String[] args) {
        input();
        process();
    }
}