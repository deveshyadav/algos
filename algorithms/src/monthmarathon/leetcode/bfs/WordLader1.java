package monthmarathon.leetcode.bfs;

import java.util.*;

public class WordLader1 {
    public static void main(String[] args) {
        String bs = "a";
        String es = "c";
        List<String> strList  = Arrays.asList("a","b","c");
        int minPath = getMinPAth(bs,es,strList);
        System.out.println("Converted in steps: "+ minPath);
    }

    private static int getMinPAth(String bs, String es, List<String> strList) {


        Set<String> strSet = new HashSet<>(strList);
        if(!strSet.contains(es)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(bs);
        Set<String> visited = new HashSet<>();
        visited.add(bs);
        int count = 1;

        while(!queue.isEmpty()) {
            int size  = queue.size();
            for(int s=0;s<size;s++) {
                String curr = queue.poll();
                char[] temp = curr.toCharArray();
                for (int i = 0; i < temp.length; i++) {
                    char original = temp[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (original==j) {
                           continue;
                        }
                            temp[i] = j;
                            String t = String.valueOf(temp);
                            if (es.equals(t)) return count+1;
                            if (!visited.contains(t)) {
                                visited.add(t);
                                if (strSet.contains(t)) {
                                    System.out.println(t + "->");
                                    queue.offer(t);
                                }
                            }
                    }
                    temp[i]=original;
                }
            }
            count++;
        }

        return 0;
    }
}
