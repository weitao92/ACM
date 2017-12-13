package NY_regional_2016;

import java.util.Scanner;

public class ProblemA {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int k = scan.nextInt();
            long num = scan.nextLong();
            long[] res = convert(num);
            long oct = res[0];
            long hex = res[1];
            ans.append(k + " " + oct + " " + num + " " + hex + "\n");
        }
        
        System.out.print(ans);

    }
    
    static long[] convert(long num) {
        int exp = 0;
        long oct = 0;
        long hex = 0;
        boolean isValid = true;
        while (num > 0) {
            long n = num % 10;
            if (n > 7) {
                isValid = false;
            }
            if (isValid) {
                oct += n * Math.pow(8, exp);
            }
            
            hex += n * Math.pow(16, exp);
            num /= 10;
            exp++;
        }
        long[] ans = new long[2];
        ans[0] = isValid ? oct : 0;
        ans[1] = hex;
        return ans;
    }
    
}
