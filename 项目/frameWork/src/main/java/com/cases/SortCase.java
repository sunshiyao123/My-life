package com.cases;

import com.Case;
import com.annotations.BenchMark;
import com.annotations.Measurement;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;


/**
 * 1.快速排序 和 归并的差别
 * 2.自己实现的归并排序和Array.sort对比
 * TODO.自己实现并发排序(ForkJoin)和Array.parallelSort
 */
@Measurement(iterations = 0,group = 3)
public class SortCase implements Case {
    /**
     * 快速排序
     * 1.确定一个基准值
     *  选最边上
     *  随机取
     *  几个数里取中值
     * 2.对待排序区做partition，结果让比基准值小的放左边，大的放右边
     * 3.按照同样的方式处理剩余的区间
     *
     */
//    public static void quickSort(int[] a) {
//        //确定基准值
//        int
//    }
//    //待排序区间(low,high)
//    private void quickSortInternal(int[] a,int low,int high) {
//        if (high <= low) {
//            return;
//        }
//        //基准值最终所在下标
//        int p
//    }


    @BenchMark
    public void testQuickSort() {
        int[] a = new int[100000];
        Random random = new Random(20190716);
        for (int i = 0;i < a.length;i++){
            a[i] = random.nextInt(100000);
        }

    }
    @BenchMark
    public void testMergeSort() {
        int[] a = new int[100000];
        Random random = new Random(20190716);
        for (int i = 0;i < a.length;i++){
            a[i] = random.nextInt(100000);
        }

    }

    @BenchMark
    public void testArraysSort() {
        int[] a = new int[100000];
        Random random = new Random(20190716);
        for (int i = 0;i < a.length;i++){
            a[i] = random.nextInt(100000);
        }

        Arrays.sort(a);

    }
}
