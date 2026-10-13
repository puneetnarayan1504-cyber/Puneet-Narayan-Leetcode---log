class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0;i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];
            adj.get(prerequisite).add(course);
            inDegree[course]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses ; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int completedCourses =0;
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            completedCourses++ ;
            
            for (int dependentCourse : adj.get(currentCourse)) {
                inDegree[dependentCourse]--;
                if (inDegree[dependentCourse] == 0) {
                    queue.offer(dependentCourse);
                }
            }
        }
        return completedCourses == numCourses;
    } 
    
}