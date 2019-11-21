package lession06;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Создать генератор текстовых файлов, работающий по следующим правилам:
 * Предложение состоит из 1<=n1<=15 слов. В предложении после произвольных слов могут находиться запятые.
 * Слово состоит из 1<=n2<=15 латинских букв
 * Слова разделены одним пробелом
 * Предложение начинается с заглавной буквы
 * Предложение заканчивается (.|!|?)+" "
 * Текст состоит из абзацев. в одном абзаце 1<=n3<=20 предложений. В конце абзаца стоит разрыв строки и перенос каретки.
 * Есть массив слов 1<=n4<=1000. Есть вероятность probability вхождения одного из слов этого массива в следующее предложение (1/probability).
 * <p>
 * Необходимо написать метод getFiles(String path, int n, int size, String[] words, int probability),
 * который создаст n файлов размером size в каталоге path. words - массив слов, probability - вероятность.
 */
public class Task02 {

    public static final String MY_PATH = "/Users/internet/IdeaProjects/STC-20/stc20work/src/main/resources/words_lession06.txt";
    public static final String TASK02_PATH = "/Users/internet/IdeaProjects/STC-20/stc20work/src/main/resources/06_textGen";
    public static final int WORDS = 15;
    public static final int SENTENCE = 20;
    public static final int PARAGRAPH = 3;

    public static void main(String[] args) throws IOException {

        List<String> listWords = readFile(MY_PATH);

        String[] strLanguages = listWords.toArray(new String[listWords.size()]);


        System.out.println("------------- START -------------");
        for (int i = 0; i < PARAGRAPH; i++) {
            paragraphGen(listWords);
        }
        System.out.print("\n" + "------------- END -------------");

        getFiles(TASK02_PATH, 2, 1, strLanguages, 2);
//todo fix getFiles

        // sentenceGenerate(listWords);
    }

    public static void getFiles(String path, int n, int size, String[] words, int probability) {

    }

    public static void sentenceGenerate(List<String> listWords) {

        String words;

        int wordsCount = getRandomInt(WORDS);
        int mark = getRandomInt(2);

        String[] signs = {"? ", "! ", ". "};
        String[] marks = {" ", " ", ", ", " "};


        for (int i = 0; i < wordsCount; i++) {
            int elements = getRandomInt(listWords.size());
            // System.out.println(i);
            words = listWords.get(elements);
            if (i == 0) {
                words = words.substring(0, 1).toUpperCase() + words.substring(1);
            }
            if (i == wordsCount - 1) {
                words = words + getMarks(signs);
                ;
            }
            if (i > 0 && i < wordsCount - 1) {
                words = words + getMarks(marks);
            }
            System.out.print(words);

        }

    }

    public static void paragraphGen(List<String> listWords) {
        int sentenceCount = getRandomInt(SENTENCE);
        System.out.println("sentenceCount - " + sentenceCount);

        for (int i = 0; i < sentenceCount; i++) {
            sentenceGenerate(listWords);
        }
        System.out.print(" \n");
    }

    private static List<String> readFile(String path) throws IOException {

        List<String> result = new ArrayList<>();

        try {

            File f = new File(path);

            BufferedReader b = new BufferedReader(new FileReader(f));

            String readLine = "";

            System.out.println("Reading file..");

            while ((readLine = b.readLine()) != null) {
                result.add(readLine);
                //    System.out.println(readLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    private static int getRandomInt(int range) {
        range -= 1;
        return (int) (Math.random() * ++range) + 1;
    }

    private static String getMarks(String[] items) {
        Random rand = new Random();
        return items[rand.nextInt(items.length)];
    }

}
