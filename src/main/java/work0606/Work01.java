package work0606;

import java.util.Scanner;

/**
 * 1.一个整数，大于0，不用循环和本地变量，按照 n，2n，4n，8n 的顺序递增，当值大于5000时，把值按照指定顺序输出来。(20分)
 *  例：n=1237
 *  则输出为：1237，2474，4948，9896
 *
 * @Author junhi
 * @Date 2019/6/6 9:03
 */
public class Work01 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true){
            int num = scanner.nextInt();
            get(num);
        }

    }

    /**
     * 传入需要计算的整数
     * @param num
     */
    public static void get(int num){
        if(num >= 5000){
            System.out.println(num);
            return;
        }

        if((num * 8) > 5000){
            System.out.println(num + "\t" + num * 2 + "\t" + num *4 + "\t" + num * 8);
            return;
        }
        num = 2 * num;
        get(num);
    }

}
