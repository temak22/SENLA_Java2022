package tasks.task4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Task4 {

    static ArrayList<Integer> digits = new ArrayList<Integer>();
    static char[][] field;
    static int maxDigit;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input a number: ");
        int num = in.nextInt();

        while (num > 0) {
            digits.add(num % 10);
            num /= 10;
        }
        //в список цифры были помещены в обратном порядке
        //меняем порядок цифр на исходный
        Collections.reverse(digits);


        //находим наибольшую цифру
        maxDigit = 0;
        for (int digit : digits)
            if (digit > maxDigit)
                maxDigit = digit;

        //вызовем метод, который создаст и распечатает поле с цифрами из звездочек или самих этих цифр
        makeField();

    }

    public static void makeField()
    {
        //одна цифра занимает 7х5 клеток и между цифрами пробел в два столбца
        int width = 5 * digits.size() + (digits.size() * 2 - 1);
        int height = 7;

        //создаем пустое поле
        field = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++)
                field[i][j] = ' ';
        }

        //заполняем поле
        int startCell = 0;
        for (int k = 0; k < digits.size(); k++) {
            int curDigit = digits.get(k);
            if (curDigit == maxDigit)
                //символом для заполнения берется сама цифра
                fillDigitFieldWithChar((char) (curDigit + 48), startCell, curDigit);
            else
                //заполнение звездочками
                fillDigitFieldWithChar('*', startCell, curDigit);
            startCell += 7;
        }

        //выводим поле
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++)
                System.out.print(field[i][j]);
            System.out.println();
        }
    }

    public static void fillDigitFieldWithChar(char ch, int startCell, int curDigit) {
        switch (curDigit) {
            case 1:
                field[0][startCell + 2] = ch;
                field[1][startCell + 1] = ch;
                field[1][startCell + 2] = ch;
                field[2][startCell + 0] = ch;
                field[2][startCell + 2] = ch;
                field[3][startCell + 2] = ch;
                field[4][startCell + 2] = ch;
                field[5][startCell + 2] = ch;
                field[6][startCell + 0] = ch;
                field[6][startCell + 1] = ch;
                field[6][startCell + 2] = ch;
                field[6][startCell + 3] = ch;
                field[6][startCell + 4] = ch;
                break;
            case 2:
                field[0][startCell + 1] = ch;
                field[0][startCell + 2] = ch;
                field[0][startCell + 3] = ch;
                field[1][startCell + 0] = ch;
                field[1][startCell + 4] = ch;
                field[2][startCell + 0] = ch;
                field[2][startCell + 3] = ch;
                field[3][startCell + 2] = ch;
                field[4][startCell + 1] = ch;
                field[5][startCell + 0] = ch;
                field[6][startCell + 0] = ch;
                field[6][startCell + 1] = ch;
                field[6][startCell + 2] = ch;
                field[6][startCell + 3] = ch;
                field[6][startCell + 4] = ch;
                break;
            case 3:
                field[0][startCell + 1] = ch;
                field[0][startCell + 2] = ch;
                field[0][startCell + 3] = ch;
                field[1][startCell + 0] = ch;
                field[1][startCell + 4] = ch;
                field[2][startCell + 4] = ch;
                field[3][startCell + 2] = ch;
                field[3][startCell + 3] = ch;
                field[4][startCell + 4] = ch;
                field[5][startCell + 0] = ch;
                field[5][startCell + 4] = ch;
                field[6][startCell + 1] = ch;
                field[6][startCell + 2] = ch;
                field[6][startCell + 3] = ch;
                break;
            case 4:
                field[0][startCell + 3] = ch;
                field[1][startCell + 2] = ch;
                field[1][startCell + 3] = ch;
                field[2][startCell + 1] = ch;
                field[2][startCell + 3] = ch;
                field[3][startCell + 0] = ch;
                field[3][startCell + 3] = ch;
                field[4][startCell + 0] = ch;
                field[4][startCell + 1] = ch;
                field[4][startCell + 2] = ch;
                field[4][startCell + 3] = ch;
                field[4][startCell + 4] = ch;
                field[5][startCell + 3] = ch;
                field[6][startCell + 3] = ch;
                break;
            case 5:
                field[0][startCell + 0] = ch;
                field[0][startCell + 1] = ch;
                field[0][startCell + 2] = ch;
                field[0][startCell + 3] = ch;
                field[0][startCell + 4] = ch;
                field[1][startCell + 0] = ch;
                field[2][startCell + 0] = ch;
                field[3][startCell + 0] = ch;
                field[3][startCell + 1] = ch;
                field[3][startCell + 2] = ch;
                field[3][startCell + 3] = ch;
                field[4][startCell + 4] = ch;
                field[5][startCell + 4] = ch;
                field[6][startCell + 0] = ch;
                field[6][startCell + 1] = ch;
                field[6][startCell + 2] = ch;
                field[6][startCell + 3] = ch;
                break;
            case 6:
                field[0][startCell + 1] = ch;
                field[0][startCell + 2] = ch;
                field[0][startCell + 3] = ch;
                field[1][startCell + 0] = ch;
                field[2][startCell + 0] = ch;
                field[3][startCell + 0] = ch;
                field[3][startCell + 1] = ch;
                field[3][startCell + 2] = ch;
                field[3][startCell + 3] = ch;
                field[4][startCell + 0] = ch;
                field[4][startCell + 4] = ch;
                field[5][startCell + 0] = ch;
                field[5][startCell + 4] = ch;
                field[6][startCell + 1] = ch;
                field[6][startCell + 2] = ch;
                field[6][startCell + 3] = ch;
                break;
            case 7:
                field[0][startCell + 0] = ch;
                field[0][startCell + 1] = ch;
                field[0][startCell + 2] = ch;
                field[0][startCell + 3] = ch;
                field[0][startCell + 4] = ch;
                field[1][startCell + 4] = ch;
                field[2][startCell + 3] = ch;
                field[3][startCell + 2] = ch;
                field[4][startCell + 1] = ch;
                field[5][startCell + 0] = ch;
                field[6][startCell + 0] = ch;
                break;
            case 8:
                field[0][startCell + 1] = ch;
                field[0][startCell + 2] = ch;
                field[0][startCell + 3] = ch;
                field[1][startCell + 0] = ch;
                field[1][startCell + 4] = ch;
                field[2][startCell + 0] = ch;
                field[2][startCell + 4] = ch;
                field[3][startCell + 1] = ch;
                field[3][startCell + 2] = ch;
                field[3][startCell + 3] = ch;
                field[4][startCell + 0] = ch;
                field[4][startCell + 4] = ch;
                field[5][startCell + 0] = ch;
                field[5][startCell + 4] = ch;
                field[6][startCell + 1] = ch;
                field[6][startCell + 2] = ch;
                field[6][startCell + 3] = ch;
                break;
            case 9:
                field[0][startCell + 1] = ch;
                field[0][startCell + 2] = ch;
                field[0][startCell + 3] = ch;
                field[1][startCell + 0] = ch;
                field[1][startCell + 4] = ch;
                field[2][startCell + 0] = ch;
                field[2][startCell + 4] = ch;
                field[3][startCell + 1] = ch;
                field[3][startCell + 2] = ch;
                field[3][startCell + 3] = ch;
                field[3][startCell + 4] = ch;
                field[4][startCell + 4] = ch;
                field[5][startCell + 4] = ch;
                field[6][startCell + 1] = ch;
                field[6][startCell + 2] = ch;
                field[6][startCell + 3] = ch;
                break;
            case 0:
                field[0][startCell + 1] = ch;
                field[0][startCell + 2] = ch;
                field[0][startCell + 3] = ch;
                field[1][startCell + 0] = ch;
                field[1][startCell + 4] = ch;
                field[2][startCell + 0] = ch;
                field[2][startCell + 4] = ch;
                field[3][startCell + 0] = ch;
                field[3][startCell + 4] = ch;
                field[4][startCell + 0] = ch;
                field[4][startCell + 4] = ch;
                field[5][startCell + 0] = ch;
                field[5][startCell + 4] = ch;
                field[6][startCell + 1] = ch;
                field[6][startCell + 2] = ch;
                field[6][startCell + 3] = ch;
                break;
        }
    }
}
