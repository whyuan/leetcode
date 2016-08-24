import java.util.LinkedList;

/**
 * Created by wanghaoyuan on 2016/7/29.
 */
public class Solution {

    public boolean isPalindrome(int x) {
        int y = 0;
        if (x < 0) return false;
        if (x > 0 && (x%10 == 0)) return false;
        int a = x;
        while (a > y) {
            y = y*10+a%10;
            a /= 10;
        }
        return (a == y || a == y/10);
    }

    public boolean isPalindrome1(int x) {
        int y = 0;
        if (x < 0) return false;
        int a = x;
        while (a > 0) {
            y = y*10+a%10;
            a /= 10;
        }
        return (y == x);
    }

    public boolean isPalindrome0(int x) {
        LinkedList<Integer> as = new LinkedList<Integer>();
        if (x < 0) return false;
        while (x != 0) {
            int a = x%10;
            x = x/10;
            as.push(a);
        }
        int l = as.size()/2;
        for (int i = 0; i < l; i++) {
            if (as.get(i) != as.get(as.size()-i-1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(10));
        System.out.println(solution.isPalindrome(1));
        System.out.println(solution.isPalindrome(0));
        System.out.println(solution.isPalindrome(-1));
        System.out.println(solution.isPalindrome(34));
        System.out.println(solution.isPalindrome(3443));
        System.out.println(solution.isPalindrome(343));
    }
}
