import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Recursion {
    //    public Recursion recursion;
    public MyStack stack = new MyStack();
    public ReadFile file;
    public List<String> path = new ArrayList<>();

    public Recursion(ReadFile file) throws IOException {
        this.file = file;
    }

    public Recursion(ReadFile file, MyStack stack) throws IOException {
        this.stack = stack;
        this.file = file;
    }


    public List<String> iterate(ReadFile file, String input) throws IOException {
        if (input.length() == 0 && stack.variables.size() == 0)
            return this.path;


        for (Transition t : file.getTransitions()) {
            if (t.getFromState().equals(path.get(path.size() - 1))) {
                if (t.isNondeterministic()) {
                    MyStack recursiveStack = new MyStack(stack);
                    Recursion parallel = new Recursion(file, recursiveStack);
                    parallel.path.add(t.getToState());
                    path.addAll(parallel.iterate(file, input));
                    return path;
                }
                else if (t.isEmptyRead()) {     // Empty read
                    MyStack recursiveStack = new MyStack(stack);
                    Recursion parallel = new Recursion(file, recursiveStack);
                    if (!t.getPop().equals("ε")) {
                        if (recursiveStack.head().equals(t.getPop())) {
                            recursiveStack.pop();
                            recursiveStack.push(t.getPush());
                            parallel.path.add(t.getToState());
                            path.addAll(parallel.iterate(file, input));
                        }
                    } else {
                        recursiveStack.push(t.getPush());
                        parallel.path.add(t.getToState());
                        path.addAll(parallel.iterate(file, input));
                    }

                    return path;

                } else {
                    if (path.get(path.size() - 1).equals(t.getFromState()) && input.length() != 0) {
                        if (t.getVariable().equals(input.charAt(0) + "")) {
                            if (!t.getPop().equals("ε")) {
                                if (stack.head().equals(t.getPop())) {
                                    stack.pop();
                                    stack.push(t.getPush());
                                    path.add(t.getToState());
                                    return this.iterate(file, input.substring(1));
                                }
                            } else {
                                stack.push(t.getPush());
                                path.add(t.getToState());
                                return this.iterate(file, input.substring(1));
                            }
                            return path;
                        }
                    }
                }
            }
        }
        return new ArrayList<>();
    }

}

