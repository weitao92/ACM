package Graph;
import java.util.*;

/**
 * https://pcs.cs.cloud.vt.edu/problems/283
 */
public class A_BFS
{
    static class point
    {
        int row;
        int col;
        public point(int r, int c)
        {
            row = r;
            col = c;
        }
    }
    static class state
    {
        point current;
        int length;

        public state(point p, int l)
        {
            current = p;
            length = l;
        }
    }
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int col = in.nextInt();
        in.nextLine();
        int[][] world = new int[row][col];
        point start = null;
        point end = null;

        for(int i = 0; i < row; i++)
        {
            String line = in.nextLine();
            for(int j = 0; j < col; j++)
            {
                char c = line.charAt(j);
                if(c == '#')
                {
                    world[i][j] = -1;
                }
                else if(c == 's')
                {
                    start = new point(i,j);
                }
                else if(c == 't')
                {
                    end = new point(i,j);
                }
            }
        }

        ArrayDeque<state> queue = new ArrayDeque<state>();
        boolean[][] visited = new boolean[row][col];
        queue.addLast(new state(start,0));
        while(!queue.isEmpty())
        {
            state current = queue.removeFirst();
            if(current.current.row == end.row && current.current.col == end.col)
            {
                System.out.println(current.length);
                System.exit(0);
            }
 
            point[] neighbors = neighbors(current.current);
            for(point p : neighbors)
            {
                if(inRange(row, col, p) && world[p.row][p.col] != -1 && visited[p.row][p.col] == false)
                {
                    visited[p.row][p.col] = true;
                    queue.add(new state(p,current.length+1));
                }
            }
        }
    }
    
    public static boolean inRange(int row, int col, point p)
    {
        return p.row >= 0 && p.row < row && p.col >= 0 && p.col < col;
    }

    public static point[] neighbors(point current)
    {
        point[] result = new point[4];
        result[0] = new point(current.row-1,current.col);
        result[1] = new point(current.row,current.col+1);
        result[2] = new point(current.row+1,current.col);
        result[3] = new point(current.row,current.col-1);
        return result;
    }
}