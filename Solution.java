import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



class Result {
    public static int getBingoNumber(List<List<Integer>> mat, List<Integer> arr) {
        HashMap<Integer, String> di = new HashMap<>();
        int n = mat.size();
        int m = mat.get(0).size();

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                di.put(mat.get(i).get(j), Integer.toString(i)+Integer.toString(j));
            }
        }

        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int i=0; i<m; i++){
            rows[i] = m;
        }
        for (int j=0; j<n; j++){
            cols[j] = n;
        }
        for (Integer k:arr){
            String val = di.get(k);
            int a = Character.getNumericValue(val.charAt(0));
            int b = Character.getNumericValue(val.charAt(1));
            rows[a] = rows[a] - 1;
            cols[b] = cols[b] - 1;
            if (rows[a] == 0 || cols[b] == 0){
                return k;
            }
        }

    return 0;
    }

}

public class Solution {
    public static void main(String[] args) {
        List<List<Integer>> mat = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine(); 
        for (int i = 0; i < n; i++) {
            String user_input = sc.nextLine();
            String[] matRowTempItems = user_input.split(" ");

            List<Integer> matRowItems = new ArrayList<>();

            for (int j = 0; j < m; j++) {
                int matItem = Integer.parseInt(matRowTempItems[j]);
                matRowItems.add(matItem);
            }
            mat.add(matRowItems);
        }
        int arrCount = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < arrCount; i++) {
            int arrItem = sc.nextInt();
            arr.add(arrItem);
        }
        int result = Result.getBingoNumber(mat, arr);
        System.out.println(result);
    }
}
