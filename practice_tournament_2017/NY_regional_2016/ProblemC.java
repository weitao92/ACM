package NY_regional_2016;

import java.util.*;

/**
 * https://open.kattis.com/problems/marypartitions
 * @author weitao92
 *
 */
public class ProblemC {

    static HashMap<Long, Long> map;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        map = new HashMap<Long, Long>();
 
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int a = 0; a < n; a++) {
            int tmp = input.nextInt();
            int m = input.nextInt();
            int value = input.nextInt();
            int startPower = 1;
            while (startPower < value) {
                startPower *= m;
            }
            long dynamic = solve(value, startPower, m);
            System.out.println(tmp + " " + dynamic);
        }
    }

    private static long solve(int value, int startPower, int m2) {
    	long hash = value*1000000000000l + startPower*1000000l
    			+ m2;
		
        if(value == 0){
            return 1;
        }
        if(startPower == 0){
            return 0;
        }
        if(map.containsKey(hash)){
            return map.get(hash);
        }
        long ans = 0;
        if(value >= startPower){
            ans += solve(value-startPower, startPower, m2);
        }
        ans += solve(value, startPower/m2, m2);
        // TODO Auto-generated method stub
        map.put(hash, ans);
        return ans;
    }

}