package palindromenumber;

public class Main {
    public static void main(String[] args) {
        int x = 11221;
        System.out.println(new Main().isPalindrome(x));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        int copyOfX = x;
        int reversedX = 0;
        while(copyOfX > 0) {
            reversedX *= 10;
            reversedX += copyOfX % 10;
            copyOfX /= 10;
        }
        return x == reversedX;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        char[] chars = String.valueOf(x).toCharArray();
        for (int i = 0, j = chars.length - 1; i <= j; ++i, --j) {
            if (chars[i] != chars[j]) return false;
        }
        return true;
    }
}
