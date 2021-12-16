import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

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


            for (String i : file.getStringsToDetect()) {            // Iterates over the inputs
//                fileWriter.write(currentState + "  ");


                Recursion recursion = new Recursion(file);
                recursion.path.add(currentState);
                List<String> result = recursion.iterate(file, i);
                fileWriter.write(result + "");

//                System.out.println("result = " + result);


                if (file.getGoalStates().contains(result.get(result.size() - 1))) {
                    System.out.println("Accepted");
                    fileWriter.write("\nAccepted\n");
                } else {
                    System.out.println("Rejected");
                    fileWriter.write("\nRejected\n");
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
