package lession03.task01;

import java.util.Arrays;
import java.util.List;

public class MathBox {

    public static List ArrMathBox(Number[] arrayNumbers) {
        for (int i = 0; i < arrayNumbers.length; i++) {
            for (int j = i + 1 ; j < arrayNumbers.length; j++) {
                if (arrayNumbers[i].equals(arrayNumbers[j])) {
                    //todo remove same elements
                }
            }
        }

    return Arrays.asList(arrayNumbers);
    }

    public static void main(String[] args) {


        ArrMathBox(null);
    }

    private void summator(List mathList){

       // mathList.forEach();

    }

    private void splitter(){

    }

    private void remover(Integer element){

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
