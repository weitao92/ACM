package Combinatorics;

import java.util.Scanner;

public class countLarger {
	
	static long MOD = 1000000007;
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int base = in.nextInt();
		int length = in.nextInt();
		in.close();
		
		System.out.println(pow(base, length)%MOD);
	}
	
	public static long pow(int base, int exponent){
	  	if(exponent == 0){
	    		return 1;
	  	}   
	  	if(exponent == 1){
	    		return base;
	  	}   
	  	long tmp = pow(base, exponent/2);
	  	long result = tmp * tmp;
	  	if(result >= MOD)
	  	{
	  		result %= MOD;
	  	}
	  	
	  	result = result * pow(base, exponent%2);
	  	
	  	if(result >= MOD)
	  	{
	  		result %= MOD;
	  	}
	  	return result;
	}   


}
