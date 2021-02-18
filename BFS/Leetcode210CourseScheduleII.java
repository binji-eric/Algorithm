// There are a total of n courses you have to take labelled from 0 to n - 1.

// Some courses may have prerequisites, for example, if prerequisites[i] = [ai, bi] this means you must take the course bi before the course ai.

// Given the total number of courses numCourses and a list of the prerequisite pairs, return the ordering of courses you should take to finish all courses.

// If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

public int[] findOrder(int numCourses, int[][] prerequisites) {
    if (numCourses == 0) return null;
 // Convert graph presentation from edges to indegree of adjacent list.
 int indegree[] = new int[numCourses];
 int order[] = new int[numCourses];
 List<Integer>[] list = new List[numCourses];
 int index = 0;
  for(int j =0; j<numCourses; j++)
      list[j]= new ArrayList<Integer>();
 for (int i = 0; i < prerequisites.length; i++){ // Indegree - how many prerequisites are needed.
     indegree[prerequisites[i][0]]++;    
     list[prerequisites[i][1]].add(prerequisites[i][0]);
 }

 Queue<Integer> queue = new LinkedList<Integer>();
 for (int i = 0; i < numCourses; i++) 
     if (indegree[i] == 0) {
         // Add the course to the order because it has no prerequisites.
         order[index++] = i;
         queue.offer(i);
     }

 // How many courses don't need prerequisites. 
 while (!queue.isEmpty()) {
     int prerequisite = queue.poll(); // Already finished this prerequisite course.
     for (int ele: list[prerequisite])  {
             indegree[ele]--; 
             if (indegree[ele] == 0) {
                 // If indegree is zero, then add the course to the order.
                 order[index++] = ele;
                 queue.offer(ele);
             }
     }
 }

 return (index == numCourses) ? order : new int[0];
 }