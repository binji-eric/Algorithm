# Algorithm
LintCode 178 Graph Valid Tree
    The defination of Tree:
        (1) There will be n - 1 edges for n nodes
        (2) All the nodes are reached from any node

LeetCode 133 Clone Graph
    (1) use Map to track the relation between old and new node
    (2) add neighbors to new node


LintCode 127 Topological Sorting
    (1) get indegree map of graph
    (2) get startNodes of topological sort
    (3) use bfs get full order

Leetcode200 Number of Islands
    (1) once visited, value of node should be flipped
    (2) check boundary eveny time
    BFS: create new Class Coordinate(x, y)
    DFS: much easier for this problem


Leetcode300 Longest Increasing Subsequence
    (1) sequence可以不连续，但是subarray必须连续