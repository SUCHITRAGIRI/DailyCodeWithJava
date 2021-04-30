package cpPackage;
import java.util.*;

public class UniquePathUsingCombination {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		sc.close();
		System.out.println(uniquePaths(m, n));
	}

    public static int uniquePaths(int m, int n) {
        //More efficient approach
        int N = m + n - 2;
        int r = n - 1;
        double res = 1;
        for(int i = 1; i <= r; i++){
            res = res * (N - r + i) / i;
        }
        return (int)res;
    }
}
//This problem is solved by using Combination approach:
// here we have to move only in two direstion Right and Bottom
//so, here N or r are in this way Ncr
//trick of calculating combination: - 
//let 5C3 = 5 * 4 * 3 / 3 * 2 * 1
