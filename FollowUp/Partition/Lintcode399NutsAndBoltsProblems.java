public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
    // write your code here
    if(nuts == null || bolts == null) {
        return;
    } else if(nuts.length != bolts.length) {
        return;
    }
    sort(nuts, bolts, 0, nuts.length - 1, compare);
}

public void sort(String[] nuts, String[] bolts, int left, int right, NBComparator compare) {
    // 结束条件
    if(left >= right) {
        return;
    }
    // 得到nuts的划分结果的index
    int pivotIndex = nutsPartition(nuts, bolts[left], left, right, compare);
    // bolts做同样的处理
    boltsPartition(bolts, nuts[pivotIndex], left, right, compare);
    // 左右两部分别sort
    sort(nuts, bolts, left, pivotIndex-1, compare);
    sort(nuts, bolts, pivotIndex+1, right, compare);
}

public int nutsPartition(String[] nuts, String pivot, int left, int right, NBComparator compare) {
    for(int i = left; i<= right; i++) {
        // 找到对应值
        if(compare.cmp(nuts[i], pivot) == 0) {
            swap(nuts, i, left);
            break;
        }
    }
    // val是与pivot相匹配的值
    String val = nuts[left];
    while(left < right) {
        while(left < right && compare.cmp(nuts[right], pivot) == 1) {
            right--;
        }
        nuts[left] = nuts[right];
        while(left < right && compare.cmp(nuts[left], pivot) == -1) {
            left++;
        }
        nuts[right] = nuts[left];
    }
    nuts[left] = val;
    return left;
}

 public int boltsPartition(String[] bolts, String pivot, int left, int right, NBComparator compare) {
    for(int i = left; i<= right; i++) {
        if(compare.cmp(pivot, bolts[i]) == 0) {
            swap(bolts, i, left);
            break;
        }
    }
    // val是与pivot相匹配的值
    String val = bolts[left];
    while(left < right) {
        // 此时bolts[right] > pivot
        while(left < right && compare.cmp(pivot, bolts[right]) == -1) {
            right--;
        }
        bolts[left] = bolts[right];
         // 此时bolts[right] < pivot
        while(left < right && compare.cmp(pivot, bolts[left]) == 1) {
            left++;
        }
        bolts[right] = bolts[left];
    }
    bolts[left] = val;
    return left;
}

public void swap(String[] strs, int index1, int index2) {
    String temp = strs[index1];
    strs[index1] = strs[index2];
    strs[index2] = temp;
}