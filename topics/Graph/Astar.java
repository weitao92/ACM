package Graph;
import java.util.*;

/**
 * https://pcs.cs.cloud.vt.edu/problems/283
 */
public class Astar
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
    static class state implements Comparable<state>
    {
        point current;
        int length;
        int heur;

        public state(point p, int l, int h)
        {
            current = p;
            length = l;
            heur = h;
        }

        public int compareTo(state another)
        {
            return Integer.compare(heur, another.heur);
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

        PriorityQueue<state> queue = new PriorityQueue<state>();
        boolean[][] visited = new boolean[row][col];
        queue.add(new state(start,0,0));
        while(!queue.isEmpty())
        {
            state current = queue.poll();
            if(current.current.row == end.row && current.current.col == end.col)
            {
                System.out.println(current.length);
                System.exit(0);
            }
            if(visited[current.current.row][current.current.col])
            {
                continue;
            }
            visited[current.current.row][current.current.col] = true;
            point[] neighbors = neighbors(current.current);
            for(point p : neighbors)
            {
                if(inRange(row, col, p) && world[p.row][p.col] != -1)
                {
                    int heur = Math.abs(end.row - p.row) + Math.abs(end.col - p.col);
                    queue.add(new state(p,current.length+1,current.length+1+heur));
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