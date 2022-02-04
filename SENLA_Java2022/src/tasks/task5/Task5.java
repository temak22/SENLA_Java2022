package tasks.task5;

import java.util.ArrayList;
import java.util.Scanner;

public class Task5 {

    static Safe safe;
    static ArrayList<Subject> subjects = new ArrayList<Subject>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input a safe`s volume: ");
        int safeVolume = in.nextInt();
        safe = new Safe();
        safe.volume = safeVolume;

        //зададим следующий набор предметов:
        Subject subject1 = new Subject(5, 2);
        subjects.add(subject1);
        Subject subject2 = new Subject(3, 4);
        subjects.add(subject2);
        Subject subject3 = new Subject(6, 5);
        subjects.add(subject3);
        Subject subject4 = new Subject(2, 2);
        subjects.add(subject4);
        Subject subject5 = new Subject(2, 3);
        subjects.add(subject5);


        //в storage[i][j] будем хранить не просто возможность получить из первых i предметов набор веса j,
        //а максимальную суммарную стоимость такого набора. Если же такой набор получить невозможно, то это 0.
        int height = subjects.size() + 1;
        int width = safe.volume + 1;
        int[][] storage = new int[height][width];

        //заполняем массив нулями
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++)
                storage[i][j] = 0;
        }

        //заполняем хранилище максимальных стоимостей наборов из первых i предметов набор веса j
        for (int i = 1; i < height; i++) {
            for (int j = 0; j < width; j++) {
                storage[i][j] = storage[i - 1][j];
                if (subjects.get(i-1).volume <= j) {
                    storage[i][j] = Math.max(storage[i][j], storage[i - 1][j - subjects.get(i - 1).volume] + subjects.get(i - 1).value);
                }
            }
        }

        //самым ценным набором будет ячейка с наибольшим значением - ищем ее
        int result = 0, resI = 0, resJ = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (storage[i][j] > result) {
                    resI = i;
                    resJ = j;
                }
                result = Math.max(result, storage[i][j]);
            }
        }
        safe.value = result;

        //восстановление ответа - добавляем в сейф предметы из самой ценной комбинации
        while (resI > 0 && resJ >= 0) {
            if (storage[resI-1][resJ] != storage[resI][resJ]) {
                safe.safeSubjects.add(subjects.get(resI - 1));
                resJ -= subjects.get(resI-1).volume;
            }
            resI--;
        }

//        //вывод хранилища наборов
//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//                System.out.print(storage[i][j]);
//            }
//            System.out.println();
//        }

        //выводим ответ
        System.out.println("Max safe`s value:");
        System.out.println(safe.value);
        System.out.println("Subjects in safe ([volume value]):");
        System.out.println(safe.safeSubjects);
    }
}

class Subject
{
    int volume, value;

    public Subject(int volume, int value)
    {
        this.volume = volume;
        this.value = value;
    }

    public Subject()
    {
        this.volume = 0;
        this.value = 0;
    }

    public String toString()
    {
        return this.volume + " " + this.value;
    }
}

class Safe extends Subject
{
    ArrayList<Subject> safeSubjects = new ArrayList<Subject>();

    public Safe(int volume, int value)
    {
        super(volume, value);
    }

    public Safe()
    {
        super();
    }
}
