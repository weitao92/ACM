package NAQ_2016;

import java.util.Scanner;

public class bracket {

    public static void main(String[] args) 
    {
        
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        int[] reverseStart = new int[text.length() + 1];
        int start = 0;
        for (int a = text.length() - 1; a >= 0; a--) {
            if (text.charAt(a) == '(') {
                start -= 1;
            } else {
                start += 1;
            }
            if (start < 0) {
                start = Integer.MAX_VALUE / 2;
            }
            reverseStart[a] = start;
        }

        for (int startFlip = 0; startFlip < text.length(); startFlip++) {
            int st = 0;
            for (int a = 0; a < startFlip; a++) {
                st += text.charAt(a) == '(' ? 1 : -1;
                if (st < 0) {
                    st = Integer.MIN_VALUE / 2;
                }
            }
            for (int b = startFlip; b < text.length(); b++) {
                if(st == reverseStart[b]){
                    System.out.println("possible");
                    System.exit(0);
                }
                st += text.charAt(b) == ')' ? 1 : -1;
                if(st < 0){
                    st = Integer.MIN_VALUE / 2;
                }
                if(st == reverseStart[b+1]){
                    System.out.println("possible");
                    System.exit(0);
                }
            }
        }
        System.out.println("impossible");
    }

}