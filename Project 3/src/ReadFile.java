import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
    public File file;
    public int numberOfInputAlphabets;
    public int numberOfTapeAlphabets;
    public int numberOfStates;
    public List<String> states;
    public String startState;
    public String acceptState;
    public String rejectState;
    public String blankSymbol;
    public List<String> tapeAlphabets;
    public String inputAlphabet;
    public List<Transition> transitions;
    public List<String> stringsToDetect;

    public ReadFile(File file) {
        this.file = file;
        states = new ArrayList<>();
        tapeAlphabets = new ArrayList<>();
        transitions = new ArrayList<>();
        stringsToDetect = new ArrayList<>();
        initializeVariables();
    }

    public void initializeVariables() {
        try {
            Scanner scanner = new Scanner(this.file);
            int count = 0;

            while (scanner.hasNext()) {
                String s = scanner.next();

                if (count == 0) {
                    this.numberOfInputAlphabets = Integer.parseInt(s);
                    count++;
                }
                else if (count == 1) {
                    this.numberOfTapeAlphabets = Integer.parseInt(s);
                    count++;
                }
                else if (count == 2) {
                    this.numberOfStates = Integer.parseInt(s);
                    count++;
                }
                else if (count == 3) {
                    for (int i = 0; i < numberOfStates; i++) {
                        this.states.add(s);
                        if (i != this.numberOfStates - 1)
                            s = scanner.next();
                    }
                    count++;
                }
                else if (count == 4) {
                    this.startState = s;
                    count++;
                }
                else if (count == 5) {
                    this.acceptState = s;
                    count++;
                }
                else if (count == 6) {
                    this.rejectState = s;
                    count++;
                }
                else if (count == 7) {
                    this.blankSymbol = s;
                    count++;
                }
                else if (count == 8) {
                    for (int i = 0; i < numberOfTapeAlphabets + 1; i++) {
                        this.tapeAlphabets.add(s);
                        if (i != this.numberOfTapeAlphabets)
                            s = scanner.next();
                    }
                    count++;
                }
                else if (count == 9) {
                    this.inputAlphabet = s;
                    count++;
                }
                else if (count == 10) {
                    String[] line = scanner.nextLine().split(" ");
                    boolean temp = true;       // to assign previously taken scanner.next() correctly

                    while (scanner.hasNextLine() && line.length > 4) {
                        Transition e;

                        if (temp) {
                            e = new Transition(s, line[1], line[2], line[3], line[4]);
                            temp = false;
                        }
                        else
                            e = new Transition(line[0], line[1], line[2], line[3], line[4]);

                        transitions.add(e);
                        line = scanner.nextLine().split(" ");
                        s = line[0];
                    }
                    stringsToDetect.add(s);
                    count++;
                }
                else if (count == 11) {
                    this.stringsToDetect.add(s);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
