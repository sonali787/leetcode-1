class Node {
    int val;
    long dist;

    Node(int val, long dist) {
        this.val = val;
        this.dist = dist;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
         List<List<Node>> adj = new ArrayList<>();
       
        final int MOD = 1_000_000_007;

        PriorityQueue<Node> pq =
            new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
       for(int i=0;i<roads.length;i++){
            int u = roads[i][0];
            int v = roads[i][1];
            int wt = roads[i][2];

           adj.get(u).add(new Node(v, wt));
           adj.get(v).add(new Node(u, wt));
        }

            pq.add(new Node(0,0));
           
            long[] dist = new long[n];
            int[] ways= new int[n];
            
          Arrays.fill(dist, Long.MAX_VALUE);
             dist[0] = 0;
             ways[0]=1;



           while (!pq.isEmpty()) {

            Node curr = pq.poll();

            int u = curr.val;
            long distance = curr.dist;

            if (distance > dist[u]) {
                continue;
            }

            for (Node next : adj.get(u)) {

                int v = next.val;
                long newDist = distance + next.dist;

                // Found a strictly shorter path
                if (newDist < dist[v]) {

                    dist[v] = newDist;
                    ways[v] = ways[u];

                    pq.add(new Node(v, newDist));
                }

                // Found another equally short path
                else if (newDist == dist[v]) {

                    ways[v] = (int) (
                        ((long) ways[v] + ways[u]) % MOD
                    );
                }
            }
        }

            return ways[n-1];
           
    }
}