import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr;
        arr = new int[2];
        for (int i=0; i<nums.length; i++){
            int a = target - nums[i];
            for (int j=i+1; j<nums.length; j++){
                if (nums[j] == a){
                    arr[0] = i;
                    arr[1] = j;
                    return(arr);
                }
            }
        }
        return(arr);
    }
}

public class TwoSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        System.out.print("Enter the elements: ");
        int[] inp = new int[n];
        for (int i=0; i<n; i++){
            inp[i] = sc.nextInt();
        }
        System.out.println("Enter the target element: ");
        int target = sc.nextInt();
        Solution s = new Solution();
        int[] result = s.twoSum(inp, target);
        for (Integer i:result){
            System.out.print(i+" ");
        }
    }
}