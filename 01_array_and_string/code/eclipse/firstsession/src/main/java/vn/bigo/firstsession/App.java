package vn.bigo.firstsession;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
    	Scanner argumentScanner = new Scanner(System.in);
    	
    	int numberOfKnots = argumentScanner.nextInt();
    	
    	List<Integer> knots = new ArrayList<Integer>();
    	
    	for (int i = 0; i < numberOfKnots; i++) {
    		knots.add(argumentScanner.nextInt());
    	}
    	
    	argumentScanner.close();
    	
    	if (isFashionable(knots)) {
    		System.out.println("YES");
    	} else {
    		System.out.println("NO");
    	}
    	
    }
    
    public static boolean isFashionable(List<Integer> knots) {
    	if (knots.size() == 1) {
    		if (knots.get(0) == 0) {
    			return false;
    		} else {
    			return true;
    		}
    		
    	}
    	
    	int notFastenedKnot = 0;
    	for (Integer knot : knots) {
    		if (knot == 0) {
    			notFastenedKnot++;
    		}
    	}
    	return notFastenedKnot == 1;
    }
}
