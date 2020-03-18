package com.company;

import java.util.Arrays;

/*          https://www.acmicpc.net/problem/9095            */
/*          정수 4를 1, 2, 3의 합으로 나타내는 방법은
            총 7가지가 있다. 합을 나타낼 때는 수를 1개
            이상 사용해야 한다.                                */
public class Main {
    public static int[] d;
    public static int[][] d1;
    public static void main(String[] args) {
	// write your code here
        int n = 10;
        d = new int[n+1];
        Arrays.fill(d,0);
        System.out.println(sum123(n));

        d1 = new int[n+1][4];
        for(int i=0; i<=n; i++) Arrays.fill(d1[i], 0);
        System.out.println(sum123_1(n));

    }

    public static int sum123(int n){
        d[0] = 1;
        d[1] = 1;
        d[2] = 2;
        for(int i=3; i<=n; i++){
            d[i] = d[i-3] + d[i-2] + d[i-1];
        }
        return d[n];
    }
    /*          https://www.acmicpc.net/problem/15990            */
    /*          정수 4를 1, 2, 3의 합으로 나타내는 방법은
                총 3가지가 있다. 합을 나타낼 때는 수를 1개
                이상 사용해야 한다. 단, 같은 수를 두 번 이상
                연속해서 사용하면 안 된다.                           */
    /*          sum123과 기본 메커니즘은 같지만 연속해서 같은
                수를 사용할 수 없다는 조건이 추가됨                   */
    public static int sum123_1(int n){
        for(int i=0; i<=n; i++){
            if(i<1){
                d1[i][1] = 0;
                d1[i][2] = 0;
                d1[i][3] = 0;
            }
            if(i == 1){
                d1[i][1] = 1;
                d1[i][2] = 0;
                d1[i][3] = 0;
            }
            if(i == 2){
                d1[i][1] = d1[i-1][2] + d1[i-1][3];
                d1[i][2] = 1;
                d1[i][3] = 0;
            }
            if(i==3){
                d1[i][1] = d1[i-1][2] + d1[i-1][3];
                d1[i][2] = d1[i-2][1] + d1[i-2][3];
                d1[i][3] = 1;
            }
            if(i>3){
                d1[i][1] = d1[i-1][2] + d1[i-1][3];
                d1[i][2] = d1[i-2][1] + d1[i-2][3];
                d1[i][3] = d1[i-3][1] + d1[i-3][2];
            }
        }
        return d1[n][1] + d1[n][2] + d1[n][3];
    }

}
