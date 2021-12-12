import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;

public class PDA {
    private MyStack stack;
    private ReadFile file;

    public PDA(MyStack stack, ReadFile file) {
        this.stack = stack;
        this.file = file;
    }

    public void pdaAlgorithm() {
        try {
            FileWriter fileWriter = new FileWriter("output.txt");

            String currentState = file.getStartState();

            for (String s : file.getStringsToDetect()) {
                for (char j : s.toCharArray())
                    System.out.println(j + " ");
                System.out.println();
            }

            for (String i : file.getStringsToDetect()) {
                for (char j : i.toCharArray()) {
                    for (Transition t : file.getTransitions()) {
//                        System.out.println("1 : "  + currentState.equals(t.getFromState()));
//                        System.out.println("2 : " + (j == t.getVariable().charAt(0)));
//                        System.out.println(j + " " + t.getVariable().charAt(0));
                        System.out.println(currentState.equals(t.getFromState()) + " " + (j == t.getVariable().charAt(0) || j == 'ε'));

                        if (currentState.equals(t.getFromState()) && (j == t.getVariable().charAt(0) || j == 'ε')) {
                            System.out.println("Girdi");
                            currentState = t.getToState();
                            System.out.println(currentState + " ");
                            fileWriter.write(currentState + "  ");
                            break;
                        }
                    }
                }

                fileWriter.write("\n");

                if (file.getGoalStates().contains(currentState)) {
                    System.out.println("Accepted");
                    fileWriter.write("Accepted\n");
                }
                else {
                    System.out.println("Rejected");
                    fileWriter.write("Rejected\n");
                }

                currentState = file.getStartState();
                fileWriter.write("\n");
            }

            fileWriter.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
