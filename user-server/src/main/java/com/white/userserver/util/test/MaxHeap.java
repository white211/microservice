package com.white.userserver.util.test;

/**
 * @Program: MaxHeap
 * @Description:
 * @Author: White
 * @DateTime: 2019-07-08 14:17:03
 **/

public class MaxHeap {

    public static void main(String[] args) {
        int i, size, data[] = {51, 32, 73, 23, 42, 62, 99, 14, 24, 3934, 58, 65, 80, 120};
        size = data.length;
        System.out.print("原始数据");
        for (i = 1; i < size; i++) {
            System.out.print("[" + data[i] + "]");
        }

        System.out.println("");

        MaxHeap.heap(data, size);

    }

    private static void heap(int[] data, int size) {
        int i, j, tmp;
        for (i = (size / 2); i > 0; i--) {
            MaxHeap.ad_heap(data, i, size - 1);
        }
        System.out.println("堆积内容：");
        for (i = 1; i < size; i++) {
            System.out.print("[" + data[i] + "]");
        }

    }

    private static void ad_heap(int[] data, int i, int size) {
        int j, tmp, post;
        j = 2 * i;
        tmp = data[i];
        post = 0;
        while (j <= size && post == 0) {
            if (j < size) {
                if(data[j]>data[j+1]) //小顶堆的比较
                //if (data[j] < data[j + 1])   //找出两个子节点最大值
                    j++;
            }
            if(tmp<=data[j])          //小顶堆的比较
            //if (tmp >= data[j])            //若树根较大，结束比较过程
                post = 1;
            else {
                data[j / 2] = data[j];      //若树根较小，则继续比较，这里将最大子节点赋值给父节点
                j = 2 * j;
            }
        }
        data[j / 2] = tmp;                   //指定树根为父节点
    }

}
