package lession06;

import java.io.*;
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

        String[] jvmLangs = {" Java ", " Scala ", " Jruyby ", " Kotlin ", " Groovy "};
        List<String> listWords = readFile(MY_PATH);
        System.out.println("------------- START -------------");
        getFiles(TASK02_PATH, 4, 1000, jvmLangs, 1, listWords);
        System.out.print("\n" + "------------- END -------------");

    }

    public static void getFiles(String path, int n, int size, String[] words, int probability, List<String> mainList) throws IOException {
        for (int i = 1; i < n + 1; i++) {
            writeToFileWhenSize(path + "/tmp" + i + ".txt", words, size, probability, mainList);
        }
    }


    static String sentenceGenerate(List<String> listWords, String probWord) {

        String words;
        String result = "";

        int wordsCount = makeRandomInt(WORDS);

        String[] signs = {"? ", "! ", ". "};
        String[] marks = {" ", " ", ", ", " "};

        for (int i = 0; i < wordsCount; i++) {
            int elements = makeRandomInt(listWords.size());

            words = listWords.get(elements);
            if (i == 0) {
                words = words.substring(0, 1).toUpperCase() + words.substring(1);
                result += words;
            }
            if (i > 0 && i < wordsCount - 1) {
                words = words + makeMarks(marks);
                result += words;
            }
            if (i == wordsCount - 1) {

                if (probWord == "#") {
                    words = words + makeMarks(signs);
                } else {
                    words = words + probWord + makeMarks(signs);
                }
                result += words;
            }
        }

        return result;
    }

    static String paragraphGen(List<String> listWords, String probWord) {
        String result = "";
        int sentenceCount = makeRandomInt(SENTENCE);
        // System.out.println("sentenceCount - " + sentenceCount);
        for (int i = 0; i < PARAGRAPH ; i++) {
            for (int j = 0; j < sentenceCount; j++) {
                result += sentenceGenerate(listWords, probWord);
            }
            result = result + " \n";
        }

        return result;
    }

    private static List<String> readFile(String path) throws IOException {

        List<String> result = new ArrayList<>();

        try {

            File f = new File(path);

            BufferedReader b = new BufferedReader(new FileReader(f));

            String readLine = "";

            System.out.println("Reading source file.. with words...");

            while ((readLine = b.readLine()) != null) {
                result.add(readLine);
                //    System.out.println(readLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
//
//    private static void writeFileResult(String path, List<String> stringList, int counter) throws IOException {
//        Files.write(Paths.get(path), stringList.toString().getBytes());
//    }

    private static int makeRandomInt(int range) {
        range -= 1;
        return (int) (Math.random() * ++range) + 1;
    }

    private static String makeMarks(String[] items) {
        Random rand = new Random();
        return items[rand.nextInt(items.length)];
    }

    private static void writeToFileWhenSize(String path, String[] words, int size, int prob, List<String> mainList) throws IOException {
        String temp = "";
        //  System.out.println("prob -" +val);
        if (probability(prob)) {
            temp = paragraphGen(mainList, makeMarks(words));
        } else {
            temp = paragraphGen(mainList, "#");
        }
        // System.out.println(temp);
        File file = new File(path);
        try (BufferedWriter writer = Files.newBufferedWriter(file.toPath())) {
            while (file.length() < size) {
                writer.write(temp);
                writer.flush();
            }
            System.out.println(size + " KB Data is written to the file.!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static boolean probability(int prob) {
        return new Random().nextInt(prob) == 0;
    }
}
