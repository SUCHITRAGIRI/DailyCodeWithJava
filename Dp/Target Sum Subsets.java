//Tabullation approach!

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        System.out.print(targetSum(0, arr, target));
     
    }

    public static boolean targetSum(int idx, int[] arr, int target){
        boolean[][] dp = new boolean[arr.length + 1][target + 1];

        for(int r = 0; r < dp.length; r++){
            for(int c = 0; c < dp[0].length; c++){
                if(r == 0)dp[r][c] = false;
                else if(c == 0) dp[r][c] = true;
                
                else if(arr[r - 1] == c)dp[r][c] = true;
                else if(arr[r - 1] > c)dp[r][c] = dp[r - 1][c];
                else if(arr[r - 1] < c)dp[r][c] = dp[r - 1][c] || dp[r - 1][c - arr[r - 1]];
                
            }
            if(dp[r][target] == true && arr[r - 1] != 0)return true;
        }

        return false;
    }
}
