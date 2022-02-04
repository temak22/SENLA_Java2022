package tasks.task2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Input a number: ");

        try{
            int num = in.nextInt();
            System.out.println("Prime factors: ");
            if (num < 2)
                System.out.println("no factors");
            factorize(num,2);
        }
        catch(InputMismatchException ex){

            System.out.println("Number is not integer!");
        }
    }

    public static void factorize(int num, int k)
    {
        //рекурсия продолжается, пока делимое не меньше делителя
        if (k > num) return;
        //если число делится на делитель k нацело
        if (num % k == 0)
        {
            //выводим простой множитель
            System.out.println(k);
            //делим число на этот множитель, пока оно на него делится
            while(num % k == 0)
            {
                num=num/k;
            }
        }
        //проделываем это со делителем, который будет на 1 больше предыдущего (составные множители не возникнут благодаря предыдущему действию)
        factorize(num,k+1);
    }
}