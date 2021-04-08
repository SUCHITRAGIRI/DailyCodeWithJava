package AllRecursion;
import java.util.*;
public class TowerOfHanoi {

	//recursion is a leap of faith
	
	public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int N = sc.nextInt();// no. of plates
    int td1 = sc.nextInt();// tower 1
    int td2 = sc.nextInt();// tower 2
    int td3 = sc.nextInt();// tower 3 
    sc.close();
    //plates shift from tower 1 to tower 2 using tower 3
    shift(N, td1, td2, td3);
    
	}
	
	public static void shift(int N, int td1, int td2, int td3) {
		if(N==0) {
			return;
		}
		shift(N-1,td1, td3, td2);
		System.out.println(td1 +"-->"+ td2);
		shift(N-1, td3, td2, td1);
	}

}
