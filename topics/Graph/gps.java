package Graph;
import java.util.*;

/**
 * https://pcs.cs.cloud.vt.edu/problems/242
 * implementation of A* algorithms.
 */
public class gps
{
    static class coordinate{
        int x;
        int y;
        public coordinate(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        public Double getDist(coordinate another)
        {
            return Math.sqrt(Math.pow(x-another.x, 2) + Math.pow(y-another.y, 2));
        }
    }

    static class road implements Comparable<road>
    {
        int src;
        int det;
        double len;
        double len1;
        public road(int s, int d, double l, double l1)
        {
            src = s;
            det = d;
            len = l;
            len1 = l1;
        }

        public int compareTo(road another)
        {
            return Double.compare(len+len1, another.len+another.len1);
        }
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int q = in.nextInt();
        HashMap<Integer,String> map1 = new HashMap<Integer,String>();
        HashMap<String,Integer> map2 = new HashMap<String,Integer>();
        coordinate[] coordinates = new coordinate[n];
        ArrayList<road>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++)
        {
            graph[i] = new ArrayList<road>();
            String name = in.next();
            map1.put(i, name);
            map2.put(name, i);
            coordinate c = new coordinate(in.nextInt(), in.nextInt());
            coordinates[i] = c;
        }
        for(int i = 0; i < m; i++)
        {
            String src = in.next();
            String det = in.next();
            float len = in.nextFloat();
            graph[map2.get(src)].add(new road(map2.get(src),map2.get(det),len, 0));
            graph[map2.get(det)].add(new road(map2.get(det),map2.get(src),len, 0));
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < q; i++)
        {
            int start = map2.get(in.next());
            int end = map2.get(in.next());
            PriorityQueue<road> queue = new PriorityQueue<road>();
            
            double[] results = new double[n];
            Arrays.fill(results, Double.MAX_VALUE);
            results[start] = 0;
            queue.add(new road(start,start,0,0));
            int[] prev = new int[n];

            /**
             * A* implementation, use current length of path + Euclidean distance to destination as compare
             * factor.
             */
            while(!queue.isEmpty())
            {
                road current = queue.poll();

                //remember the length of any road cannot be shorter than euclidean distance, so if current.det
                //equals end, this is the shortest path.
                if(current.det == end)
                {
                    break;
                }

                for(road next : graph[current.det])
                {
                    double possible = results[current.det] + next.len;
                    if(possible < results[next.det])
                    {
                        prev[next.det] = current.det;
                        results[next.det] = possible;
                        double distance = coordinates[next.det].getDist(coordinates[end]);
                        queue.add(new road(current.det,next.det,possible, distance));
                    }                
                }
            }
            StringBuilder temp = new StringBuilder();
            temp.append(results[end] + " ");
            ArrayList<String> tempList = new ArrayList<String>();
            int index = end;
            while(index != start)
            {
                tempList.add(map1.get(index));
                index = prev[index];
            }
            temp.append(map1.get(start));
            for(int j = tempList.size()-1; j >= 0; j--)
            {
                temp.append(" " + tempList.get(j));
            }
            temp.append("\n");
            sb.append(temp);
        }
        System.out.print(sb);
    }
}