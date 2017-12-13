package bloomCon;


import java.util.ArrayDeque;
import java.util.Scanner;
//Your submission should *ONLY* use the following class name
public class field
{
    public static void main(String[] args)
    {

       Scanner in = new Scanner(System.in);
       int n = in.nextInt();
       String setter = in.next();
       String[][] field = new String[2][3];
       field[1][2] = in.next();
       field[0][2] = in.next();
       field[0][1] = in.next();
       field[0][0] = in.next();
       field[1][0] = in.next();
       field[1][1] = in.next();
       
       int m = in.nextInt();
       ArrayDeque<String> queue = new ArrayDeque<String>();
       for(int i = 0; i < m; i++)
       {
    	   queue.addLast(in.next());
       }
       
       for(int i = 0; i < n; i++)
       {
    	   boolean ro = true;
    	   String remover = field[0][2];
    	   if(field[0][2].equals(setter))
    	   {
    		   ro = false;
    	   }
    	   field[0][2] = field[0][1];
    	   field[0][1] = field[0][0];
    	   field[0][0] = field[1][0];
    	   field[1][0] = field[1][1];
    	   field[1][1] = field[1][2];
    	   if(ro)
    	   {
    		   field[1][2] = queue.removeFirst();
    		   queue.addLast(remover);
    	   }
    	   else
    	   {
    		   field[1][2] = setter;
    	   }
       }
       
       System.out.println(field[1][2] + " " + field[0][2] + " " + field[0][1] + " " + field[0][0]
    		    + " " + field[1][0] + " " + field[1][1]);
    }

}
