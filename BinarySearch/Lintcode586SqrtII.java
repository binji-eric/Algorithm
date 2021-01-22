public sqrtII(x) {
	double l = 0;
	// 如果x < 1, 那么右边界一定要>=1, 
	// 比如0.81的的结果是0.9, 如果不加Math.max(x, 1.0)， 
	// 右边界是0.81, 得不到正确的值
	double r = Math.max(x, 1.0);
	// 精确度
	double eps = 1e-12;
	while(l + eps < r) {
		double mid = l + (r-l)/2;
		if(mid*mid < x) {
			l = mid;
		} else {
			r = mid;
		}
	}
	return l;
}