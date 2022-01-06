import java.io.File;

public class Main {
    public static void main(String[] args) {
        File inputFile = new File("input.txt");
        ReadFile readFile = new ReadFile(inputFile);
        TuringMachine turingMachine = new TuringMachine(readFile);
        turingMachine.simulate();

        System.out.println("readFile.numberOfInputAlphabets = " + readFile.numberOfInputAlphabets);
        System.out.println("readFile.numberOfTapeAlphabets = " + readFile.numberOfTapeAlphabets);
        System.out.println("readFile.numberOfStates = " + readFile.numberOfStates);
        System.out.println("readFile.states = " + readFile.states);
        System.out.println("readFile.startState = " + readFile.startState);
        System.out.println("readFile.acceptState = " + readFile.acceptState);
        System.out.println("readFile.rejectState = " + readFile.rejectState);
        System.out.println("readFile.blankSymbol = " + readFile.blankSymbol);
        System.out.println("readFile.tapeAlphabets = " + readFile.tapeAlphabets);
        System.out.println("readFile.inputAlphabet = " + readFile.inputAlphabet);
        System.out.println("readFile.transitions = " + readFile.transitions);
        System.out.println("readFile.stringsToDetect = " + readFile.stringsToDetect);


    }
}
