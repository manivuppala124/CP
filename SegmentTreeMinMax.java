/*Malika taught a new fun time program practice for Engineering Students.
As a part of this she has given set of N numbers, and asked the students 
to perform the operations listed below:
1. sumRange(start, end) - return the sum of numbers between the indices start and end, both are inclusive.
2. update(ind, val) - update the value at the index 'ind' to 'val'.
3. Find the min value in the given range
4. Find the max value in the given range 

Your task is to solve this problem using Segment Tree concept.

Input Format:
-------------
Line-1: Two integers N and Q, size of the array(set of numbers) and query count.
Line-2: N space separated integers.
next Q lines: Three integers option, start/ind and end/val.

Output Format:
--------------
An integer result, for every sumRange query.


Sample Input:
-------------
8 7
4 2 13 3 25 16 17 8
1 2 6		//sumRange
1 0 7		//sumRange
3 2 6       //get max value in the range
2 2 18	    //update
2 4 17	    //update
1 2 6		//sumRange
4 1 5       // get min value in the range
 

Sample Output:
--------------
74
88
25
71
2 */
import java.util.*;

public class SegmentTreeMinMax {
    private int[] nums, sumTree, minTree, maxTree;
    private int n;

    public SegmentTreeMinMax(int[] arr) {
        n = arr.length;
        nums = Arrays.copyOf(arr, n);
        sumTree = new int[4 * n]; // Segment tree for sum
        minTree = new int[4 * n]; // Segment tree for min
        maxTree = new int[4 * n]; // Segment tree for max
        build(0, 0, n - 1);
    }

    private void build(int node, int left, int right) {
        if (left == right) {
            sumTree[node] = nums[left];
            minTree[node] = nums[left];
            maxTree[node] = nums[left];
        } else {
            int mid = left + (right - left) / 2;
            build(2 * node + 1, left, mid);
            build(2 * node + 2, mid + 1, right);
            sumTree[node] = sumTree[2 * node + 1] + sumTree[2 * node + 2];
            minTree[node] = Math.min(minTree[2 * node + 1], minTree[2 * node + 2]);
            maxTree[node] = Math.max(maxTree[2 * node + 1], maxTree[2 * node + 2]);
        }
    }

    public void update(int index, int value) {
        nums[index] = value;
        update(0, 0, n - 1, index, value);
    }

    private void update(int node, int left, int right, int index, int value) {
        if (left == right) {
            sumTree[node] = value;
            minTree[node] = value;
            maxTree[node] = value;
        } else {
            int mid = left + (right - left) / 2;
            if (index <= mid) {
                update(2 * node + 1, left, mid, index, value);
            } else {
                update(2 * node + 2, mid + 1, right, index, value);
            }
            sumTree[node] = sumTree[2 * node + 1] + sumTree[2 * node + 2];
            minTree[node] = Math.min(minTree[2 * node + 1], minTree[2 * node + 2]);
            maxTree[node] = Math.max(maxTree[2 * node + 1], maxTree[2 * node + 2]);
        }
    }

    public int sumRange(int start, int end) {
        return querySum(0, 0, n - 1, start, end);
    }

    private int querySum(int node, int left, int right, int ql, int qr) {
        if (ql > right || qr < left) return 0; // Out of range
        if (ql <= left && qr >= right) return sumTree[node]; // Fully covered
        int mid = left + (right - left) / 2;
        return querySum(2 * node + 1, left, mid, ql, qr) +
               querySum(2 * node + 2, mid + 1, right, ql, qr);
    }

    public int getMin(int start, int end) {
        return queryMin(0, 0, n - 1, start, end);
    }

    private int queryMin(int node, int left, int right, int ql, int qr) {
        if (ql > right || qr < left) return Integer.MAX_VALUE; // Out of range
        if (ql <= left && qr >= right) return minTree[node]; // Fully covered
        int mid = left + (right - left) / 2;
        return Math.min(queryMin(2 * node + 1, left, mid, ql, qr),
                        queryMin(2 * node + 2, mid + 1, right, ql, qr));
    }

    public int getMax(int start, int end) {
        return queryMax(0, 0, n - 1, start, end);
    }

    private int queryMax(int node, int left, int right, int ql, int qr) {
        if (ql > right || qr < left) return Integer.MIN_VALUE; // Out of range
        if (ql <= left && qr >= right) return maxTree[node]; // Fully covered
        int mid = left + (right - left) / 2;
        return Math.max(queryMax(2 * node + 1, left, mid, ql, qr),
                        queryMax(2 * node + 2, mid + 1, right, ql, qr));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), Q = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        SegmentTreeMinMax segmentTree = new SegmentTreeMinMax(arr);

        for (int i = 0; i < Q; i++) {
            int option = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (option == 1) {
                System.out.println(segmentTree.sumRange(a, b));
            } else if (option == 2) {
                segmentTree.update(a, b);
            } else if (option == 3) {
                System.out.println(segmentTree.getMax(a, b));
            } else if (option == 4) {
                System.out.println(segmentTree.getMin(a, b));
            }
        }

        sc.close();
    }
}

