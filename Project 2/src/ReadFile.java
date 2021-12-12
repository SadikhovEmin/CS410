import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
    private File file;
    private int numberOfInputAlphabets;
    private int numberOfStackAlphabets;
    private int numberOfGoalStates;
    private int numberOfStates;
    private List<String> states;
    private String initialStackSymbol;
    private List<String> inputAlphabets;
    private String startState;
    private List<String> goalStates;
    private List<String> stackAlphabet;
    private List<Transition> transitions;
    private List<String> stringsToDetect;

    public ReadFile(File file) {
        this.file = file;
        states = new ArrayList<>();
        inputAlphabets = new ArrayList<>();
        goalStates = new ArrayList<>();
        stackAlphabet = new ArrayList<>();
        transitions = new ArrayList<>();
        stringsToDetect = new ArrayList<>();
        initializeVariables();
    }

    private void initializeVariables() {
        try {
            Scanner scanner = new Scanner(this.file);
            int count = 0;      // To correctly assign values from file to variables

            while (scanner.hasNext()) {
                String s = scanner.next();

                if (count == 0) {
                    this.numberOfInputAlphabets = Integer.parseInt(s);
                    count++;
                }
                else if (count == 1) {
                    this.numberOfStackAlphabets = Integer.parseInt(s);
                    count++;
                }
                else if (count == 2) {
                    this.numberOfGoalStates = Integer.parseInt(s);
                    count++;
                }
                else if (count == 3) {
                    this.numberOfStates = Integer.parseInt(s);
                    count++;
                }
                else if (count == 4) {          // Assigning states
                    for (int i = 0; i < this.numberOfStates; i++) {
                        states.add(s);
                        if (i != this.numberOfStates - 1)
                            s = scanner.next();
                    }
                    count++;
                }
                else if (count == 5) {
                    this.startState = s;
                    count++;
                }
                else if (count == 6) {          // Assigning goalStates
                    for (int i = 0; i < this.numberOfGoalStates; i++) {
                        this.goalStates.add(s);
                        if (i != this.numberOfGoalStates - 1)
                            s = scanner.next();
                    }
                    count++;
                }
                else if (count == 7) {
                    for (int i = 0; i < this.numberOfStackAlphabets; i++) {
                        this.stackAlphabet.add(s);
                        if (i != this.numberOfStackAlphabets - 1)
                            s = scanner.next();
                    }
                    count++;
                }
                else if (count == 8) {
                    this.initialStackSymbol = s;
                    count++;
                }
                else if (count == 9) {
                    for (int i = 0; i < this.numberOfInputAlphabets; i++) {
                        this.inputAlphabets.add(s);
                        if (i != this.numberOfInputAlphabets - 1)
                            s = scanner.next();
                    }
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

                        System.out.println("e = " + e);
                        transitions.add(e);
                        line = scanner.nextLine().split(" ");
                        s = line[0];
                    }
                    stringsToDetect.add(s);
                    count++;
                }
                else if (count == 11) {
                    stringsToDetect.add(s);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public File getFile() {
        return file;
    }

    public int getNumberOfInputAlphabets() {
        return numberOfInputAlphabets;
    }

    public int getNumberOfStackAlphabets() {
        return numberOfStackAlphabets;
    }

    public int getNumberOfGoalStates() {
        return numberOfGoalStates;
    }

    public int getNumberOfStates() {
        return numberOfStates;
    }

    public List<String> getStates() {
        return states;
    }

    public String getInitialStackSymbol() {
        return initialStackSymbol;
    }

    public List<String> getInputAlphabets() {
        return inputAlphabets;
    }

    public String getStartState() {
        return startState;
    }

    public List<String> getGoalStates() {
        return goalStates;
    }

    public List<Transition> getTransitions() {
        return transitions;
    }

    public List<String> getStackAlphabet() {
        return stackAlphabet;
    }

    public List<String> getStringsToDetect() {
        return stringsToDetect;
    }
}
