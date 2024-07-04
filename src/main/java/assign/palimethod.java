package assign;

public class palimethod {
	public static boolean ispali(int num) {
	    
		
		int safe = num;
		int rev = 0, rem=0;
		while(num!=0) {
			rem = num%10;
			num/=10;
			rev = rev*10 + rem;
		}
		if(safe==rev) {
			return true;
		}
		else {
			return false;
		}
	}	
}
