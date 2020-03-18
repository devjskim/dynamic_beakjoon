package com.company;

import java.util.Arrays;

/*              https://www.acmicpc.net/problem/11726               */
/*              2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는
                방법의 수를 구하는 프로그램을 작성하시오.
                2×n 크기의 직사각형을 채우는 방법의 수를
                10,007로 나눈 나머지를 출력한다.                       */

public class Main {
    public static int[] d;
    public static void main(String[] args) {
	// write your code here
        int n = 9;
        d = new int[n+1];
        Arrays.fill(d, 0);
        d[0] = d[1] = 1;
        System.out.println(rectan(n));
    }

    /*      dynamic programming top-down approach       */
    public static int rectan(int n){

        if(n <= 1)  return d[n];
        if(d[n] > 0)    return d[n];

        d[n] = rectan(n-1) + rectan(n-2);
        return d[n]%10007;


    }

    /*      dynamic programming bottom-up approach       */
/*
    public static int rectan(int n){
        d[0] = 1;
        d[1] = 1;
        for(int i=2; i<=n; i++){
            d[i] = d[i-1] + d[i-2];
            d[i] = d[i]%10007;
        }
        return d[n];
    }
    */

}
