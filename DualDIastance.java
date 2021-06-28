import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Vector;

public class DualDIastance {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static void addEdge(Vector<Integer> edges[], int u, int v){
        edges[u].add(v);
        edges[v].add(u);
    }

    public static int minEdgeBFS(Vector <Integer> edges[], int u, int v, int n){
        Vector<Boolean> visited = new Vector<Boolean>(n);

        for (int i = 0; i < n; i++) {
            visited.addElement(false);
        }

        Vector<Integer> distance = new Vector<Integer>(n);

        for (int i = 0; i < n; i++) {
            distance.addElement(0);
        }

        Queue<Integer> Q = new LinkedList<>();
        distance.setElementAt(0, u);

        Q.add(u);
        visited.setElementAt(true, u);
        while (!Q.isEmpty())
        {
            int x = Q.peek();
            Q.poll();

            for (int i=0; i<edges[x].size(); i++)
            {
                if (visited.elementAt(edges[x].get(i)))
                    continue;

                // update distance for i
                distance.setElementAt(distance.get(x) + 1,edges[x].get(i));
                Q.add(edges[x].get(i));
                visited.setElementAt(true,edges[x].get(i));
            }
        }
        return distance.get(v);
    }

    public static void main(String[] args) {
        FastReader in =new FastReader();
        PrintWriter writer = new PrintWriter(System.out);
        int test = in.nextInt();
        for (int z = 0; z < test; z++) {
            int n = in.nextInt();
            int q =in.nextInt();
            Vector <Integer> edges[] = new Vector[n];
            for (int i = 0; i < edges.length; i++) {
                edges[i] = new Vector<>();
            }

            for (int i = 0; i < n-1; i++) {
                addEdge(edges,in.nextInt()-1,in.nextInt()-1);
            }
            for (int i = 0; i < q; i++) {
                int u=in.nextInt()-1;
                int v=in.nextInt()-1;
                int ans=0;
                for (int j = 0; j < n; j++) {
                    ans+=Math.min(minEdgeBFS(edges,j,u,n),minEdgeBFS(edges,j,v,n));
                }
                writer.println(ans);
            }
        }
        writer.flush();
        writer.close();
    }
}
