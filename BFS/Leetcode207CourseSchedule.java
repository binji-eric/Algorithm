// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

// For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
// Return true if you can finish all courses. Otherwise, return false.



public boolean canFinish(int numCourses, int[][] prerequisites) {
    // write your code here
    List<Integer>[] adjList = new ArrayList[numCourses];
    int[] indegrees = new int[numCourses];
    for(int i = 0; i < numCourses; i++) {
        adjList[i] = new ArrayList<Integer>();
    }
    // build indegrees and adjacent list
    for(int[] course: prerequisites) {
        int first = course[1];
        int second = course[0];
        indegrees[second]++;
        adjList[first].add(second);
    }
    
    LinkedList<Integer> queue = new LinkedList<Integer>();
    // check which course should be taken first
    for(int i = 0; i < numCourses; i++) {
        if(indegrees[i] == 0) {
            queue.offer(i);
        }
    }
    
    int count = 0;
    // topological sort
    while(!queue.isEmpty()) {
        int node = queue.poll();
        count++;
        for(int neighbor: adjList[node]) {
            indegrees[neighbor]--;
            if(indegrees[neighbor] == 0) {
                queue.offer(neighbor);
            }
        }
    }
    return count == numCourses;
}