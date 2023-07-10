import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int T;

    static void input(){
        T = sc.nextInt();
    }

    static boolean process(int target){
        boolean isPalindrome = false;
        for (int i = 2; i <= 64; i++) {
            isPalindrome = isPalindrome(target, i);

            if(isPalindrome) {
                return true;
            }
        }
        return false;
    }

    private static boolean isPalindrome(int target, int digit) {
        List<Integer> list = new ArrayList<>();

        int isPalindromeTarget = target;

        while(isPalindromeTarget > 0){
            list.add(isPalindromeTarget % digit);
            isPalindromeTarget /= digit;
        }

        for (int i = 0; i < list.size()/2; i++) {
            if(!Objects.equals(list.get(i), list.get(list.size() - 1 - i))){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        input();
        while(T-- > 0){
            int x = sc.nextInt();
            System.out.println(process(x) ? "1" : "0");
        }
    }
}