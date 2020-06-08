package DynamicProgrammingI;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BytelandianGoldCoins {
	public static Map<Long, Long> MAXES = new HashMap<>();
	
	public static void main(String[] args) {
    	Scanner argumentScanner = new Scanner(System.in);
    	
    	while (argumentScanner.hasNext()) {
    		long n = argumentScanner.nextLong();
    		
			System.out.println(coins(n));
    	}
    	
    	argumentScanner.close();
	}
	
	public static long coins(long n) {
		if (n < 12) {
			return n;
		}
		
		if (MAXES.containsKey(n)) {
			return MAXES.get(n);
		}
		
		long result = Math.max(n, coins(n / 2) + coins(n / 3) + coins(n / 4));
		
		MAXES.put(n, result);
		
		return result;
	}
}
