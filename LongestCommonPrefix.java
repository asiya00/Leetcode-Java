import java.util.*;


class Solution {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        String temp = "";
        if (strs.length == 1){
            return strs[0];
        }
        int k = 0;
        while (true){
            if (k<strs[0].length() && k<strs[1].length()){
                if (strs[0].charAt(k)==strs[1].charAt(k)){
                    result += strs[0].charAt(k);
                    k += 1;
                }
                else{
                    break;
                }
            }
            else{
                break;
            }
        }
        
        if (result.length() > 0){
            for (int i=2; i<strs.length; i++){
                int j = 0;
                while (j<result.length() && j<strs[i].length()){
                    if (result.charAt(j)==strs[i].charAt(j)){
                        temp += strs[i].charAt(j);
                        j += 1;
                    }
                    else{ break; }
                }   
                if (temp.length() > 0){
                    result = temp;
                    temp = "";
                }
                else{
                    return "";
                }
            }
    }
        return result;
    }
}

class LongestCommonPrefix{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String user_input = sc.nextLine();
        String[] stringsArray = user_input.split(" ");
        Solution res = new Solution();
        System.out.println(res.longestCommonPrefix(stringsArray));
    }
}