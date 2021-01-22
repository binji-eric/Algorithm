// 给定一个整数矩阵 A, 它有如下特性:

//     相邻的整数不同
//     矩阵有 n 行 m 列，n和m不会小于3。
//     对于所有的 i < n, 都有 A[i][0] < A[i][1] && A[i][m - 2] > A[i][m - 1]
//     对于所有的 j < m, 都有 A[0][j] < A[1][j] && A[n - 2][j] > A[n - 1][j]

// 我们定义一个位置 [i,j] 是峰值, 当且仅当它满足:

//   A[i][j] > A[i + 1][j] && A[i][j] > A[i - 1][j] && 
//   A[i][j] > A[i][j + 1] && A[i][j] > A[i][j - 1]


public List<Integer> findPeakII(int[][] A) {
	int start = 1, end = A.length - 2;
	List<Integer> list = new ArrayList<>();
	while(start + 1 < end) {
		int mid = (start + end)/2;
		int col = findCol(mid, A);
		if(A[mid][col] < A[mid-1][col]) {
		// 一定可以在上半行找到peakElement
			end = mid;
		// 一定可以在下半行找到peakElement
		} else if(A[mid][col] < A[mid+1][col]) {
			start = mid;
		// 本来经过findCol求出的值，大于两边
		// 如果走到else，说明该值大于上下
		} else {
			start = mid;
			end = mid;
			break;
		}
	}
	int col = findCol(start, A);
	if(A[start][col] > A[end][col]) {
		list.add(start);
		list.add(col);
	} else {
		ans.add(end);
		list.add(findCol(end, A));
	}
	return list;
}

private int findCol(int row, int[][] A){
	int col = 0;
	for(int i = 1; i < A[0].length; i++) {
		if(A[row][i] > A[row][col]) {
			col = i;
		}
	}
	return col;
}