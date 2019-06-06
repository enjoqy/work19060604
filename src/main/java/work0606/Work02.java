package work0606;

/**
 * 2.猴子吃桃问题，有一堆桃子，一只猴子每天吃掉一半加一个，到第10天早上，
 * 猴子发现只剩一个桃子了，问原来这堆桃子有多少？(10分)
 *
 * @Author junhi
 * @Date 2019/6/6 9:03
 */
public class Work02 {

    public static void main(String[] args) {
        get(9, 1);

    }

    /**
     *
     * @param count  总天数
     * @param num  剩余多少桃子
     */
    public static void get(int count, double num){
        if(count < 1){
            System.out.println("桃子总计有： " + num);
            return;
        }
        num = (num + 1) * 2;
        count--;
        get(count, num);
    }
}
