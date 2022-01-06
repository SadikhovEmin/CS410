import java.util.ArrayList;
import java.util.List;

public class TuringMachine {
    public List<String> tape;
    public ReadFile readFile;

    public TuringMachine(ReadFile readFile) {
        this.tape = new ArrayList<>();
        this.readFile = readFile;
    }

    public void simulate() {
        System.out.println(tape);
    }
}
