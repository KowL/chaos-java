package org.chaos.leetcode;

/**
 * @Author: lijun
 * @Description:
 * @Date: Created in 2020-08-19 10:46
 * @Modified By:
 */
public class Solution {

    public int insertBits(int N, int M, int i, int j) {
        N &= ~((1 << (j-i+1) - 1) << i);
        N |= (M << i);
        return N;
    }

    public int[] findClosedNumbers(int num) {
        System.out.println(Integer.toBinaryString(num));
        int a = -1;
        // 找到最右侧的01, 01 -> 10
        int mask = 1;
        int i = 0;
        while ((num & mask) != mask) {
            i++;
            mask <<= 1;
        }
        if (i < 31) {
            a = num & (0x7fffffff - (1 << i) - (1 << i + 1)) | (1 << i + 1);
        }

        // 找到最右侧的10, 10 -> 01 右侧剩下的 1 移到右侧的高位，右侧剩下的位置0。
        int b = -1;
        i = 0;
        mask = 2;
        while ((num & mask) != mask) {
            i++;
            mask <<= 1;
        }
        System.out.println(i);
        if (i < 31) {
            b = num & (0x7fffffff - (1 << i) - (1 << i + 1)) | (1 << i);
        }
        System.out.println(Integer.toBinaryString(b));
        return new int[]{a, b};
    }


    public static void main(String[] args) {
        int[] res = new Solution().findClosedNumbers(1837591841);
        System.out.println(res[0]);
//        [1837591842,1837591832]
        System.out.println(Integer.toBinaryString(1837591842));
        System.out.println(res[1]);
        System.out.println(Integer.toBinaryString(1837591832));
        int num = 1837591841;
        int mask = 1;
        int i = 0;
        while ((num & mask) != mask) {
            i++;
            mask <<= 1;
        }
        System.out.println(i);
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE - (1 << i) - (1 << i + 1)));
        System.out.println(Integer.toBinaryString(mask));

//        1101101100001110110110100100010
//        1101101100001110110110100100001
//        1101101100001110110110100011000
    }
}
