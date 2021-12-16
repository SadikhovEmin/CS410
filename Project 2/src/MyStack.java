import java.util.ArrayList;
import java.util.List;

public class MyStack {
    public List<String> variables = new ArrayList<>();
    public String initialStackSymbol = "";


    public MyStack() {

    }

    public MyStack(MyStack another) {
        this.variables = another.variables;
        this.initialStackSymbol = another.initialStackSymbol;
    }

    public void push(String s) {
        if (s.equals("ε"))
            return;
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

    public String head() {
        return variables.get(variables.size() - 1);
    }

    public List<String> getVariables() {
        return variables;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "variables=" + variables +
                '}';
    }
}
