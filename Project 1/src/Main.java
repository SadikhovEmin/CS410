import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        File file = new File("input.txt");

        try {
            Scanner scanner = new Scanner(file);
            FileWriter fileWriter = new FileWriter("output.txt");

            int count = 0;      // To correctly assign values from file to variables
            int numberOfStates = 1;
            int numberOfVariables = 0;
            int numberOfGoalStates = 0;
            String[] states = new String[0];
            String[] goalStates = new String[0];
            char[] variables = new char[0];
            List<Transition> transitions = new ArrayList<>();
            List<String> stringsToDetect = new ArrayList<>();


            while (scanner.hasNext()) {
                String s = scanner.next();

                if (count == 0) {
                    numberOfStates = Integer.parseInt(s);
                    count++;
                }
                else if (count == 1) {
                    numberOfVariables = Integer.parseInt(s);
                    count++;
                }
                else if (count == 2) {
                    numberOfGoalStates = Integer.parseInt(s);
                    count++;
                }
                else if (count == 3) {
                    states = new String[numberOfStates];

                    for (int i = 0; i < numberOfStates; i++) {
                        states[i] = s;
                        if (i != numberOfStates - 1)
                            s = scanner.next();
                    }
                    count++;
                }
                else if (count == 4) {
                    goalStates = new String[numberOfGoalStates];

                    for (int i = 0; i < numberOfGoalStates; i++)  {
                        goalStates[i] = s;
                        if (i != numberOfGoalStates - 1)
                            s = scanner.next();
                    }
                    count++;
                }
                else if (count == 5) {
                    variables = new char[numberOfVariables];

                    for (int i = 0; i < numberOfVariables; i++) {
                        variables[i] = s.charAt(0);
                        if (i != numberOfVariables - 1)
                            s = scanner.next();
                    }
                    count++;
                }
                else if (count == 6) {
                    for (int i = 0; i < numberOfStates * numberOfVariables; i++) {
                        String fromState = s;
                        s = scanner.next();
                        char variable = s.charAt(0);
                        s = scanner.next();
                        String toState = s;

                        transitions.add(new Transition(fromState, variable, toState));
                        s = scanner.next();

                    }
                    count++;
                }

                if (count == 7)
                    stringsToDetect.add(s);
            }

            /**
             * Print all variables to check correctness with file
             */
            System.out.println("number of states "  + numberOfStates);
            System.out.println("number of variables " + numberOfVariables);
            System.out.println("number of goal states" + numberOfGoalStates);
            System.out.println("states " + Arrays.toString(states));
            System.out.println("goal states " + Arrays.toString(goalStates));
            System.out.println("variables " + Arrays.toString(variables));

            for (Transition i : transitions)
                System.out.println(i);
            for (String s : stringsToDetect)
                System.out.println(s);

            /**
             * Computation
             */
            System.out.println("------------------ Computation ------------------");

            String currentState = "q1";

            for (String i : stringsToDetect) {
                for (char j : i.toCharArray())
                    System.out.print(j + " ");
                System.out.println();
            }

            for (String i : stringsToDetect) {
                for (char j : i.toCharArray()) {
                    for (Transition t : transitions) {
                        if (currentState.equals(t.fromState) && j == t.variable) {
                            currentState = t.toState;
                            System.out.println(currentState + " ");
                            fileWriter.write(currentState + "  ");
                            break;
                        }
                    }
                }

                fileWriter.write("\n");

                if (Arrays.asList(goalStates).contains(currentState)) {
                    System.out.println("Accepted");
                    fileWriter.write("Accepted\n");
                }
                else {
                    System.out.println("Rejected");
                    fileWriter.write("Rejected\n");
                }

                currentState = "q1";
                fileWriter.write("\n");
            }

            fileWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Not valid file");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }
}
