package com.company;

import java.util.Arrays;

/*      https://www.acmicpc.net/problem/11727       */
/*      2×n 직사각형을 2×1과 2×2 타일로 채우는 방법의
        수를 구하는 프로그램을 작성하시오.               */
/*      11726과 같은 방법을 활용하지만 2*2 타일이 추가됨 */
public class Main {
    public static int[] d;
    public static void main(String[] args) {
	// write your code here
        int n = 8;
        d = new int[n+1];
        Arrays.fill(d,0);
        System.out.println(rectan2(n));
    }

    public static int rectan2(int n){
        d[0] = d[1] = 1;
        for(int i=2; i<=n; i++){
            d[i] = 2*d[i-2] + d[i-1];
        }
        return d[n]%10007;
    }
}
