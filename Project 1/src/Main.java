import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int numberOfStates;
        int numberOfVariables;
        int numberOfGoalStates;
        String[] states = {"q1", "q2"};
        String[] goalStates = {"q2"};
        char[] variables = {'a', 'b'};


        List<Transition> transitions = Arrays.asList(
                new Transition("q1", 'a', "q1"),
                new Transition("q1", 'b', "q2"),
                new Transition("q2", 'a', "q2"),
                new Transition("q2", 'b', "q1")
        );

        for (Transition i : transitions)
            System.out.println(i.fromState + ' '  + i.variable + ' ' +  i.toState);

        String detect = "aba";
        String currentState = "q1";

        for (char i : detect.toCharArray())
            System.out.println(i);

        for (char i : detect.toCharArray()) {
            for (Transition t : transitions) {
                if (currentState.equals(t.fromState) && i == t.variable) {
                    currentState = t.toState;
                    System.out.print(currentState + " ");
                    break;
                }
            }
        }

        if (Arrays.asList(goalStates).contains(currentState))
            System.out.println("Accepted");
        else
            System.out.println("Rejected");
    }
}
