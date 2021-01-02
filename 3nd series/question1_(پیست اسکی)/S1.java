import java.util.LinkedList;
import java.util.Scanner;


class V
{
    int i, j;

    public V(int i, int j)
    {
        this.i = i;
        this.j = j;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof V))
            return false;

        V hold = (V) obj;

        return (this.i == hold.i && this.j == hold.j);
    }
}


public class S1
{
    private static int n, m;
    private static Scanner in = new Scanner(System.in);



    public static boolean isInRange(int y, int x)
    {
        if (x < 0 || y < 0)
            return false;

        if (x >= m)
            return false;

        if (y >= n)
            return false;

        return true;
    }




    public static void main(String[] args) 
    {
        String line = in.nextLine();
        n = Integer.parseInt(line.split(" ")[0]);
        m = Integer.parseInt(line.split(" ")[1]);

        boolean[][] visited = new boolean[n][m];
        int[][] dis = new int[n][m];


        LinkedList<V> q = new LinkedList<>();
        
        
        for (int i = 0; i < n; i++)
        {
            line = in.nextLine();

            for (int j = 0; j < line.length(); j++)
            {
                visited[i][j] = false;

                if (line.charAt(j) == 'M')
                {
                    q.add(new V(i, j));
                    visited[i][j] = true;
                    dis[i][j] = 0;
                }

                else if (line.charAt(j) == 'X')
                {
                    visited[i][j] = true;
                    dis[i][j] = -1;
                }

                else
                    dis[i][j] = -1;
            }
        }


        while (q.size() != 0)
        {
            V s = q.removeFirst();

            if (isInRange(s.i-1, s.j) && !visited[s.i-1][s.j])
            {
                q.add(new V(s.i-1, s.j));
                dis[s.i-1][s.j] = dis[s.i][s.j] + 1;
                visited[s.i-1][s.j] = true;
            }

            if (isInRange(s.i+1, s.j) && !visited[s.i+1][s.j])
            {
                q.add(new V(s.i+1, s.j));
                dis[s.i+1][s.j] = dis[s.i][s.j] + 1;
                visited[s.i+1][s.j] = true;
            }

            if (isInRange(s.i, s.j-1) && !visited[s.i][s.j-1])
            {
                q.add(new V(s.i, s.j-1));
                dis[s.i][s.j-1] = dis[s.i][s.j] + 1;
                visited[s.i][s.j-1] = true;
            }
            if (isInRange(s.i, s.j+1) && !visited[s.i][s.j+1])
            {
                q.add(new V(s.i, s.j+1));
                dis[s.i][s.j+1] = dis[s.i][s.j] + 1;
                visited[s.i][s.j+1] = true;
            }           
        }


        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
                System.out.print(dis[i][j] + " ");

            System.out.println();
        }
    }
}