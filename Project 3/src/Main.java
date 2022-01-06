import java.io.File;

public class Main {
    public static void main(String[] args) {
        File inputFile = new File("input.txt");
        ReadFile readFile = new ReadFile(inputFile);

        System.out.println("readFile.numberOfInputAlphabets = " + readFile.numberOfInputAlphabets);
        System.out.println("readFile.numberOfTapeAlphabets = " + readFile.numberOfTapeAlphabets);
        System.out.println("readFile.numberOfStates = " + readFile.numberOfStates);
    }
}
