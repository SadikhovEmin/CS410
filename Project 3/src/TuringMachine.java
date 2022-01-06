import java.io.FileWriter;
import java.io.IOException;
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
        try {
            FileWriter fileWriter = new FileWriter("output.txt");

            for (int i = 0; i < readFile.stringsToDetect.size(); i++) {     // Iterates over the input
                int tapePointer = 0;        // This keeps the track of the movements on the tape
                String currentState = readFile.startState;
                tape = new ArrayList<>();

                for (int j = 0; j < readFile.stringsToDetect.get(i).length(); j++)        // Adds whole input to tape
                    tape.add(readFile.stringsToDetect.get(i).charAt(j) + "");
                tape.add(readFile.blankSymbol);

//                System.out.println("tape inital " + tape);

                while (!(tapePointer > tape.size())) {
                    for (Transition t : readFile.transitions) {
                        if (currentState.equals(t.fromState) && tape.get(tapePointer).equals(t.variable)) {
                            System.out.print(currentState + " ");
                            fileWriter.write(currentState + " ");
                            currentState = t.toState;
                            tape.set(tapePointer, t.writeToTape);

                            if (t.move.equals("R"))
                                tapePointer++;
                            else if (t.move.equals("L") && tapePointer != 0)        // Check that leftmost is still 0
                                tapePointer--;
                        }
                    }

                    if (currentState.equals(readFile.acceptState)) {
                        System.out.print(currentState + "\n");
                        System.out.println("Accepted");
                        fileWriter.write(currentState + "\n");
                        fileWriter.write("Accepted\n");
                        break;
                    }
                    else if (currentState.equals(readFile.rejectState)) {
                        System.out.print(currentState + "\n");
                        System.out.println("Reject");

                        fileWriter.write(currentState + "\n");
                        fileWriter.write("Rejected\n");
                        break;
                    }
                }

//                System.out.println("tape final" + tape);
            }

            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
