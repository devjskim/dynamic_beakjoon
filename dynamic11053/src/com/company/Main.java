package com.company;

import java.util.Arrays;

public class Main {

    public static int[] d;
    public static void main(String[] args) {
	// write your code here
        int[] a = {10,20,10,30,20,50};
        d = new int[a.length];
        Arrays.fill(d,1);

        LIS(a);
    }

    public static void LIS(int[] a){
        int ans;
        for(int i=1; i<d.length; i++){
            for(int j=0; j<i; j++){
                ans = d[j] +1;
                if(a[i] > a[j]){
                    if(d[i] < ans) d[i] = ans;
                }
            }
        }
        int temp = d[0];
        for(int i=1; i<d.length; i++){
            if(temp < d[i]) temp = d[i];
        }

        System.out.println(temp);
    }
}
