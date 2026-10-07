class Node {
    int val;
    int wt;

    Node(int val, int wt) {
        this.val = val;
        this.wt = wt;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Node>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int wt = times[i][2];

            adj.get(u).add(new Node(v, wt));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);

        int[] dist = new int[n+1];
        for (int i = 0; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        pq.add(new Node(k, 0));
        dist[k] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int value = curr.val;
            int curr_wt = curr.wt;

            for (Node ele : adj.get(value)) {
                int next_val = ele.val;
                int next_wt = ele.wt;
                if (curr_wt + next_wt < dist[next_val]) {
                    dist[next_val] = curr_wt + next_wt;
                    pq.add(new Node(next_val, dist[next_val]));
                }
            }
        }

        int max = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            max = Math.max(max, dist[i]);
        }

        return max;

    }
}