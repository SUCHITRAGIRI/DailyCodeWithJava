package AllRecursion;
import java.util.*;
public class PowerLogarithamic {

	public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
int x=sc.nextInt();
int n=sc.nextInt();
int power=powerLog(x,n);
System.out.println(power);
sc.close();
	}
	public static int powerLog(int x, int n) {
		if(n==0) {
			return 1;
		}
		int pow=powerLog(x,n/2);
	
		
			int xn=pow*pow;
			
		
		if(n%2==1) {
			xn=xn*x;
		}
		return xn;
				}

}
