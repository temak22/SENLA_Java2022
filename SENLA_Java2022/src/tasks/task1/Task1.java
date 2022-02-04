package tasks.task1;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input a string: ");
        String str = in.nextLine();

        int sumOfNumbers = 0;
        for(char c : str.toCharArray()) {
            if (Character.isDigit(c))
                sumOfNumbers += (int) c - 48; //учитываем код ASCII
        }

        System.out.println(sumOfNumbers);
    }
}