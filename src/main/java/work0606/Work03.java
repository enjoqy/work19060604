package work0606;

import java.util.Arrays;

/**
 * 3.重排问题(20分)
 * 给定含有n个元素的整型数组a，其中包括0元素和非0元素，对数组进行排序，要求：
 * 1、排序后所有0元素在前，所有非零元素在后，且非零元素排序前后相对位置不变
 * 2、不能使用额外存储空间
 * 例子如下
 * 输入 0、3、0、2、1、0、0
 * 输出 0、0、0、0、3、2、1
 *
 * @Author junhi
 * @Date 2019/6/6 9:29
 */
public class Work03 {

    public static void main(String[] args) {
        int[] a = {0, 3, 0, 2, 1, 0, 0};
        int[] sort = sort(a);

    }

    static int count = 0;
    public static int[]  sort(int[] a) {
        System.out.println(Arrays.toString(a));
        for (int i = 1; i < a.length; i++) {
           if( a[i] == 0){
               int tmp = a[i-1];
               a[i - 1] = a[i];
               a[i] = tmp;
           }
        }
        count++;
        if(count == a.length){
            return a;
        }
        sort(a);
        return a;
    }
}
