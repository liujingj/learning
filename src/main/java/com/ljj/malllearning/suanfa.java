package com.ljj.malllearning;

import java.util.Arrays;

/**
 * @author ljj
 * @date 2022/3/11
 */
public class suanfa {

    public static void main(String[] args) {
        //冒泡排序
        int[] arr={5,3,8,6};
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        // 插入排序
        //选择排序
        //快速排序
        //归并排序
        //贪心算法
        //递归
        //反转列表
        //二分查找
        //lru
        //树 小顶堆 大顶堆
        //分治
    }
}
