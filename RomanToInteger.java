import java.util.*;

class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] S = s.toCharArray();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0;
        int i = 0;
        while (i<S.length-1){
            if (map.get(S[i])<map.get(S[i+1])){
                result += (map.get(S[i+1]) - map.get(S[i]));
                i += 2;
            }
            else{
                result += map.get(S[i]);
                i+=1;
            }
        }
        if (i==S.length-1){
            result += map.get(S[i]);
        }
        return result;
        
    }
}

class RomanToInteger{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution ans = new Solution();
        String s = sc.next();
        int result = ans.romanToInt(s);
        System.out.println(result);
    }
}