package RockyMountain2016;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * https://open.kattis.com/problems/cups
 * @author weitao92
 *
 */
public class I {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        TreeMap<Double, ArrayList<String>> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String s = scan.next();
            double r = -1;
            try {
                r = Double.parseDouble(s);
                r /= 2;
                s = scan.next();
            } catch (Exception e) {
                r = scan.nextDouble();
            }
            ArrayList<String> list = map.get(r);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(s);
            map.put(r, list);
        }
        
        StringBuilder ans = new StringBuilder();
        for (double k : map.keySet()) {
            ArrayList<String> list = map.get(k);
            for (String color : list) {
                ans.append(color).append("\n");
            }
        }
        System.out.print(ans);

    }

}