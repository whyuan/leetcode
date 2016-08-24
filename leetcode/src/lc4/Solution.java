/**
 * Created by wanghaoyuan on 2016/7/27.
 */

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] ns1 = nums1, ns2 = nums2;
        int h1 = 0;
        int h2 = 0;
        int l = 0;
        int total = (int)((((double)ns1.length+ns2.length)/2)+.7);
        int pos = 0;
        while (true) {
            int p;
            if (h1 < ns1.length) {
                int target = ns1[h1];

                int h = h2;
                int t = ns2.length;
                while (h < t) {
                    int m = ((h+t)%2==0)?(h+t)/2:((int)(h+t)/2+1);
                    if (ns2[m-1] <= target) {
                        h = m;
                    } else if (ns2[m-1] > target) {
                        t = m;
                    }
                    if (t == h+1 && ns2[h] > target) break;
                }
                p = h-1;
            } else {
                p = ns2.length-1;
            }

            // 处理边界问题
            if (p >= h2 && p-h2+l+1 >= total) {
                pos = total-l+h2-1;
                if ((ns1.length+ns2.length)%2 == 0) {
                    if (pos+1 < ns2.length && (h1>=ns1.length || ns2[pos+1]<=ns1[h1])) {
                        return ((double)ns2[pos]+ns2[pos+1])/2;
                    } else {
                        return ((double)ns2[pos]+ns1[h1])/2;
                    }
                } else {
                    return (double)ns2[pos];
                }
            } else {
                h2 = p+1;
                l = h1+h2;
                int[] temp = ns1;
                ns1 = ns2;
                ns2 = temp;
                int tempN = h1;
                h1 = h2;
                h2 = tempN;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {};
        int[] b = {2, 3};
        Solution solu = new Solution();
        System.out.print(solu.findMedianSortedArrays(a, b));
    }
}
