package day3.Sorting.SelectionSort;
import java.util.Arrays;

public class SelectionSortExamScore {

    public static void selctionSortScore(double[] score) {
        for (int i = 0; i < score.length - 1; i++) {
            int smallest = i;
            for (int j = i + 1; j < score.length; j++) {
                if (score[j] < score[smallest]) {
                    smallest = j;
                }
            }
            //swap
            double temp = score[smallest];
            score[smallest] = score[i];
            score[i] = temp;
        }
    }
    public static void main(String args[]) {
        double score[] = {70.5, 80, 10, 35.5, 20};
        System.out.println("Before exam marks: "+Arrays.toString(score));
        selctionSortScore(score);
        System.out.println("Exam Marks After Selection Sort: "+Arrays.toString(score));
    }
}

