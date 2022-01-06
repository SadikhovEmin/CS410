import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TuringMachine {
    public List<String> tape;
    public ReadFile readFile;

    public TuringMachine(ReadFile readFile) {
        this.tape = new ArrayList<>();
        this.readFile = readFile;
    }

    public void simulate() {
        String currentState = readFile.startState;
        int tapePointer = 0;        // This keeps the track of the movements on the tape

        for (int i = 0; i < readFile.stringsToDetect.size(); i++) {     // Iterates over the input
            tape = new ArrayList<>();
            for (int j = 0; j < readFile.stringsToDetect.get(i).length(); j++)        // Adds whole input to tape
                tape.add(readFile.stringsToDetect.get(i).charAt(j) + "");

            tape.add(readFile.blankSymbol);
            System.out.println("Tape " + tape);

            for (Transition t : readFile.transitions) {
                if (currentState.equals(t.fromState) && tape.get(tapePointer).equals(t.variable)) {
                    currentState = t.toState;
                    tape.set(tapePointer, t.writeToTape);

                    if (t.move.equals("R"))
                        tapePointer++;
                    else if (t.move.equals("L") && tapePointer != 0)        // Check that leftmost is still 0
                        tapePointer--;

                    System.out.println("Current " + currentState);
                    break;
                }
            }

            if (currentState.equals(readFile.acceptState))
                System.out.println("Accepted");
            else if (currentState.equals(readFile.rejectState))
                System.out.println("Reject");

//            System.out.println("tape = " + tape);
        }
    }
}
