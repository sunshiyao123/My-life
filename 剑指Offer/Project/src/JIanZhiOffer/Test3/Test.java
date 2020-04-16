package JIanZhiOffer.Test3;

/**
 * 找一个数组中重复的数字
 * 数组长度为n里面数字范围为(0-n-1)
 * 1.先排序后遍历
 * 2.遍历每个数据判读哈希表中有没有
 */
public class Test {
    public static void main(String[] args) {
        int[] data = new int[]{2,3,5,4,3,2,6,7};
        System.out.println(solution2(data,data.length));
    }
    /**
     * 最优解：遍历判断对应i下标的数字是否等于i，如果否再判断数据是否与以数据为下标的数据相等，
     * 不相等则交换，相等则找到一个重复数字
     * 时间复杂度O(n),空间复杂度O(1)
     */
    private static int solution1(int[] array,int n) {
        if (array == null || n <= 0)
            return -1;
        for (int i = 0;i < n;i++){
            if (array[i] < 0 || array[i] > n-1)
                return -1;
        }
        int i = 0;
        while (i < n) {
            if (array[i] != i) {
                int data = array[i];
                if (array[data] == data)
                    return data;
                else {
                    int temp = array[data];
                    array [data] = data;
                    array[i] = temp;
                    i = 0;
                }
            } else
                i++;
        }
        return -1;
    }

    /**
     * 题目改为长度为n+1长度，数字范围为(1-n)
     * 不修改数组找出重复的数字
     * 1.创建辅助数组，遍历原数组将数据放置数据作为下标的位置   2->array[2]   如目标位置有数据则找到
     * 2.数组长度为8的数组，数据大小(1-7),则1-4只可能出现4次，5-7只可能出现3次，哪个多了就有重复
     * 用二分查找思路一半一半考虑
     */
    private static int solution2(int[] array,int n) {
        if (array == null || n < 0)
            return -1;
        int start = 1;
        int end = n-1;
        while (start <= end) {
            //middle定义时必须加start，否则当end等于start时middle不对
            int middle = ((end - start)>>1)+start;
            int count = countRange(array,n,start,middle);
            //结束条件
            if (end == start) {
                if (count > 1)
                    return start;
                else
                    break;
            }
            if (count > middle - start + 1) {
                end = middle-1;
            } else {
                start = middle+1;
            }
        }
        return 0;
    }
    private static int countRange(int[] array,int n,int start,int end) {
        if (array == null)
            return 0;
        int count = 0;
        for (int i = 0;i < n;i++) {
            if (array[i] >= start && array[i] <= end)
                count++;
        }
        return count;
    }
}
