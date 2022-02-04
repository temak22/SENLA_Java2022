package tasks.task3;

import java.util.*;

import static java.lang.String.valueOf;

public class Task3 {

    static char[] vowels={'а', 'о', 'и', 'е', 'ё', 'э', 'ы', 'у', 'ю', 'я'};
    static ArrayList<Word> words = new ArrayList<Word>();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Input a string: ");
        String str = in.nextLine();
        str = str.toLowerCase();
        //добавляем в конец строки пробел
        str = str.concat(" ");

        while (str.contains(" ")) {
            //берем подстроку от начала строки до пробела
            String strLocal = str.substring(0, str.indexOf(" "));
            Word word = new Word(vowelsCount(strLocal), strLocal);
            words.add(word);
            //убираем из строки эту подстроку
            str = str.substring(str.indexOf(" ") + 1);
        }

        //делаем первую гласную букву заглавной
        for(int i = 0; i < words.size(); i++) {
            words.get(i).text = makeUpperFirstVowel(words.get(i).text);
        }

        //сортируем список по убыванию гласных
        sort();

        //выводим слова из списка
        for(int i = 0; i < words.size(); i++) {
            System.out.println(words.get(i).text);
        }
    }

    public static int vowelsCount(String word) {
        int count = 0;

        for(int i = 0; i < word.length(); i++) {
            char letter = word.toCharArray()[i];
            for(char vowel : vowels){
                if (letter == vowel){
                    count++;
                }
            }
        }
        return count;
    }

    public static String makeUpperFirstVowel(String word) {

        for (int i = 0; i < word.length(); i++) {
            char letter = word.toCharArray()[i];
            for (char vowel : vowels) {
                if (letter == vowel) {
                    char letterUpper = valueOf(word.charAt(i)).toUpperCase().charAt(0);
                    word = replaceChar(word, letterUpper, i);
                    return word;
                }
            }
        }
        return word;
    }

    public static String replaceChar(String str, char ch, int index) {
        return str.substring(0, index) + ch + str.substring(index + 1);
    }

    public static void sort() {
        Object[] objArray = words.toArray();
        Word[] wordsArray = new Word[objArray.length];
        for(int i = 0; i < objArray.length; i++) {
            wordsArray[i] = (Word) objArray[i];
        }
        Arrays.sort(wordsArray, new SortByNumOfVowels());
        words.clear();
        words.addAll(List.of(wordsArray));
    }
}

class Word
{
    int numOfVowels;
    String text;

    public Word(int numOfVowels, String text)
    {
        this.numOfVowels = numOfVowels;
        this.text = text;
    }

    public String toString()
    {
        return this.numOfVowels + " " + this.text;
    }
}

class SortByNumOfVowels implements Comparator<Word>
{
    public int compare(Word a, Word b)
    {
        //-1 используется для сортировки по убыванию (без нее будет сортировка по возрастанию)
        return (a.numOfVowels - b.numOfVowels) * (-1);
    }
}
