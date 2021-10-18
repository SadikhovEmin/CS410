import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("input.txt");

        try {
            Scanner scanner = new Scanner(file);


            int count = 0;      // To correctly assign values from file to variables
            int numberOfStates = 1;
            int numberOfVariables = 0;
            int numberOfGoalStates = 0;
            String[] states = new String[0];
            String[] goalStates = new String[0];
            char[] variables = new char[0];


//            states = new String[numberOfStates];
//            states[0] = "q1";

            while (scanner.hasNext()) {
                String s = scanner.next();

                if (count == 0)
                    numberOfStates = Integer.parseInt(s);
                else if (count == 1)
                    numberOfVariables = Integer.parseInt(s);
                else if (count == 2)
                    numberOfGoalStates = Integer.parseInt(s);
                else if (count == 3) {
                    states = new String[numberOfStates];

                    for (int i = 0; i < numberOfStates; i++) {
                        states[i] = s;
                        if (i != numberOfStates - 1)
                            s = scanner.next();
                    }
                }
                else if (count == 4) {
                    goalStates = new String[numberOfGoalStates];

                    for (int i = 0; i < numberOfGoalStates; i++)  {
                        goalStates[i] = s;
                        if (i != numberOfGoalStates - 1)
                            s = scanner.next();
                    }
                }
                else if (count == 5) {
                    variables = new char[numberOfVariables];

                    for (int i = 0; i < numberOfVariables; i++) {
                        variables[i] = s.charAt(0);
                        if (i != numberOfVariables - 1)
                            s = scanner.next();
                    }
                }

                count++;
//                System.out.println(s);


            }

            System.out.println("number of states "  + numberOfStates);
            System.out.println("number of variables " + numberOfVariables);
            System.out.println("number of goal states" + numberOfGoalStates);
            System.out.println("states " + Arrays.toString(states));
            System.out.println("goal states " + Arrays.toString(goalStates));
            System.out.println("variables " + Arrays.toString(variables));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



//
//
//        System.out.println("------------------------------------------------");
//
//        char[] variables = {'a', 'b'};
//
//
//        List<Transition> transitions = Arrays.asList(
//                new Transition("q1", 'a', "q1"),
//                new Transition("q1", 'b', "q2"),
//                new Transition("q2", 'a', "q2"),
//                new Transition("q2", 'b', "q1")
//        );
//
//        for (Transition i : transitions)
//            System.out.println(i.fromState + ' '  + i.variable + ' ' +  i.toState);
//
//        String detect = "abaa";
//        String currentState = "q1";
//
//        for (char i : detect.toCharArray())
//            System.out.println(i);
//
//        for (char i : detect.toCharArray()) {
//            for (Transition t : transitions) {
//                if (currentState.equals(t.fromState) && i == t.variable) {
//                    currentState = t.toState;
//                    System.out.print(currentState + " ");
//                    break;
//                }
//            }
//        }
//
//        if (Arrays.asList(goalStates).contains(currentState))
//            System.out.println("Accepted");
//        else
//            System.out.println("Rejected");
    }
}
