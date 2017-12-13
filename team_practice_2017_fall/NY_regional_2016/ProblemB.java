package NY_regional_2016;

import java.util.HashMap;
import java.util.Scanner;

public class ProblemB {
    static HashMap<Character, Long> map;
    static {
        map = new HashMap<>();
        for (long i = 0; i < 10; i++) {
            String s = i + "";
            Character c = s.charAt(0);
            map.put(c, i);
        }
        map.put('A', 10L);
        map.put('B', 8L);
        map.put('C', 11L);
        map.put('D', 12L);
        map.put('E', 13L);
        map.put('F', 14L);
        map.put('G', 11L);
        map.put('H', 15L);
        map.put('I', 1L);
        map.put('J', 16L);
        map.put('K', 17L);
        map.put('L', 18L);
        map.put('M', 19L);
        map.put('N', 20L);
        map.put('O', 0L);
        map.put('P', 21L);
        map.put('Q', 0L);
        map.put('R', 22L);
        map.put('S', 5L);
        map.put('T', 23L);
        map.put('U', 24L);
        map.put('V', 24L);
        map.put('W', 25L);
        map.put('X', 26L);
        map.put('Y', 24L);
        map.put('Z', 2L);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int k = scan.nextInt();
            String s = scan.next();
            ans.append(k + " ");
            if (check(s)) {
                ans.append(convert(s) + "\n");
            }
            else {
                ans.append("Invalid\n");
            }
        }
        System.out.print(ans);

    }
    
    static boolean check(String s) {
        long checkVal = map.get(s.charAt(s.length() - 1));
        long val = 0;
        val += 2 * map.get(s.charAt(0));
        val += 4 * map.get(s.charAt(1));
        val += 5 * map.get(s.charAt(2));
        val += 7 * map.get(s.charAt(3));
        val += 8 * map.get(s.charAt(4));
        val += 10 * map.get(s.charAt(5));
        val += 11 * map.get(s.charAt(6));
        val += 13 * map.get(s.charAt(7));
        return checkVal == val % 27;
    }
    
    static long convert(String s) {
        long ans = 0;
        long exp = 0;
        for (int i = s.length() - 2; i >= 0; i--) {
            long digit = map.get(s.charAt(i));
            ans += digit * Math.pow(27, exp);
            exp++;
        }
        return ans;
    }

}
