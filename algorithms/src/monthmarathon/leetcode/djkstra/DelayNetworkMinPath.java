package monthmarathon.leetcode.djkstra;

import java.util.*;

public class DelayNetworkMinPath {


        public static void main(String[] args) {
            int[][] nodes = new int[][]{{2,1,1,},{2,3,1},{3,4,1}};
            int n = 4;
            int k = 2;
            int res = getMinimumDelay(nodes, n, k);
            System.out.println(res);
        }


    private static int getMinimumDelay(int[][] times, int n, int k) {
            List<int[]>[] graph = new ArrayList[n+1];
            for(int i=0;i<=n;i++) graph[i] = new ArrayList<>();

            for(int[] aa:times){
                int u = aa[0];
                int v = aa[1];
                int w = aa[2];
                graph[u].add(new int[]{v,w});
            }

            int[] dist = new int[n+1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[k]=0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node-> node.time));
        pq.add(new Node(k,0));

        boolean[] visited = new boolean[n+1];

        while(!pq.isEmpty()){
            Node curr = pq.poll();
            int u = curr.id;
            if(visited[u]) continue;

            visited[u]=true;

            for(int[] i:graph[u]){
                int v = i[0];
                int w = i[1];
                if(!visited[v] &&  dist[u] + w < dist[v]){
                    dist[v] = dist[u] + w;
                    pq.offer(new Node(v, dist[v]));
                }
            }

        }

        int maxTime = 0;
        for(int i=1;i<=n;i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;

            maxTime  = Math.max(maxTime, dist[i]);
        }




        return maxTime;
    }

    static class Node{
        int id;
        int time;
        Node(int id, int time){
            this.id=id;
            this.time=time;
        }
    }

}
