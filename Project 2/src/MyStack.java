import java.util.ArrayList;
import java.util.List;

public class MyStack {
    private List<String> variables;

    public MyStack() {
        variables = new ArrayList<>();
    }

    public void push(String s) {
        variables.add(s);
    }

    public String pop() {
        if (variables.isEmpty()) {
            System.out.println("STACK EMPTY");
            return "";
        }
        else {
            String last = variables.get(variables.size() - 1);
            variables.remove(variables.size() - 1);
            return last;
        }
    }

    @Override
    public String toString() {
        return "Stack{" +
                "variables=" + variables +
                '}';
    }
}
