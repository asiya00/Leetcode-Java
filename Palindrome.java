import java.util.*;

class Solution {
    public boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }
        if (x==0){
            return true;
        }
        String a = Integer.toString(x);
        String s ="";
        while (x!=0){
            s += x%10;
            x = x/10;
        }    
        if (a.equals(s)){
            return true;
        }
        else{
            return false;
        }
    }
}

class Palindrome{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        Solution s = new Solution();
        boolean result = s.isPalindrome(x);
        System.out.println(result);
    }
}