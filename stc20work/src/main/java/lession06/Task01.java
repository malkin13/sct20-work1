package lession06;

import org.omg.PortableInterceptor.InterceptorOperations;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Objects;


/**
 * Написать программу, читающую текстовый файл.
 * Программа должна составлять отсортированный по алфавиту список слов,
 * найденных в файле и сохранять его в файл-результат.
 * Найденные слова не должны повторяться, регистр не должен учитываться.
 * Одно слово в разных падежах – это разные слова.
 */
public class Task01 {

    public static void main(String[] args) throws IOException {
        fileWork();
    }

    /**
     * Work with files read and write
     * @throws IOException
     */
    static void fileWork() throws IOException {

        String filePathInput = "/Users/internet/IdeaProjects/STC-20/stc20work/src/main/resources/in_lession06.txt";
        String filePathResult = "/Users/internet/IdeaProjects/STC-20/stc20work/src/main/resources/out_lession06.txt";

        String contents = null;
        try {
            contents = new String(Files.readAllBytes(Paths.get(filePathInput)));
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        System.out.println("##### Before fix");
        System.out.println(contents);

        System.out.println("##### After Fix");
        assert contents != null;
        String contentsNew = contents.replaceAll("[^a-zA-Z0-9\\s]", "");
        String[] lines = contentsNew.split("\\s+");
        for (String line : lines) {
            System.out.println(line);
        }
        System.out.println("##### After Sort");
        Arrays.sort(lines);
        System.out.println(Arrays.toString(lines));
        System.out.println("##### After remove Duplicates");
        System.out.println(Arrays.toString(checkDuplicate(lines)));

        FileWriter fileWriter = new FileWriter(filePathResult);
        fileWriter.write(Arrays.toString(checkDuplicate(lines)));
        fileWriter.close();

    }
    private static String[] checkDuplicate(String[] array) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(Arrays.asList(array));
        return linkedHashSet.toArray(new String[]{});
    }
}
