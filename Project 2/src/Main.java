import java.io.File;

public class Main {
    public static void main(String[] args) {
        File inputFile = new File("input.txt");
        ReadFile readFile = new ReadFile(inputFile);

        System.out.println("readFile.getFile() = " + readFile.getFile());
        System.out.println("readFile.getNumberOfInputAlphabets() = " + readFile.getNumberOfInputAlphabets());
        System.out.println("readFile.getNumberOfStackAlphabets() = " + readFile.getNumberOfStackAlphabets());
        System.out.println("readFile.getNumberOfGoalStates() = " + readFile.getNumberOfGoalStates());
        System.out.println("readFile.getNumberOfStates() = " + readFile.getNumberOfStates());
        System.out.println("readFile.getStates() = " + readFile.getStates());
        System.out.println("readFile.getStartState() = " + readFile.getStartState());
        System.out.println("readFile.getGoalStates() = " + readFile.getGoalStates());
        System.out.println("readFile.getStackAlphabet() = " + readFile.getStackAlphabet());
        System.out.println("readFile.getInitialStackSymbol() = " + readFile.getInitialStackSymbol());
        System.out.println("readFile.getInputAlphabets() = " + readFile.getInputAlphabets());
        System.out.println("readFile.getTransitions() = " + readFile.getTransitions());
        System.out.println("readFile.getStringsToDetect() = " + readFile.getStringsToDetect());


        MyStack myStack = new MyStack();

        PDA pda = new PDA(myStack, readFile);
        pda.pdaAlgorithm();
    }
}
