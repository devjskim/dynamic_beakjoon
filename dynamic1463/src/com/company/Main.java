package com.company;

import java.util.Arrays;

/*                  https://www.acmicpc.net/problem/1463                */
/*      n에 대하여 주어진 연산을 수행하여 1을 만드는 최소 연산 수 구하기       */
/*                        가능한 연산은 총 세가지                          */
/*                              n = n - 1                               */
/*                              n = n / 2                               */
/*                              n = n / 3                               */

public class Main {
    // 배열 d는 중간 결과 값을 임시 저장하는 용도 (memoization or cache)
    public static int[] d;
    public static void main(String[] args) {
	// write your code here
        int n = 10;
        d = new int[n+1];
        Arrays.fill(d,0);
        d[0] = 0;
        d[1] = 0;
        System.out.println(make1(n));
    }

    public static int make1(int n){
        int temp;
        if(n == 1) return 0;
        if(d[n] > 0)    return d[n];
        else{
            d[n] = make1(n-1) + 1;
            if(n%2 == 0){
                temp = make1(n/2) + 1;
                if(temp < d[n]) d[n]=temp;
            }
            if(n%3 == 0){
                temp = make1(n/3) + 1;
                if(temp < d[n]) d[n] = temp;
            }
        }
        return d[n];
    }
}
