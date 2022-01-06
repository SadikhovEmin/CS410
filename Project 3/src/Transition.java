public class Transition {
    public String fromState;
    public String variable;
    public String writeToTape;
    public String move;
    public String toState;

    public Transition(String fromState, String variable, String writeToTape, String move, String toState) {
        this.fromState = fromState;
        this.variable = variable;
        this.writeToTape = writeToTape;
        this.move = move;
        this.toState = toState;
    }

    @Override
    public String toString() {
        return "Transition{" +
                "fromState='" + fromState + '\'' +
                ", variable='" + variable + '\'' +
                ", writeToTape='" + writeToTape + '\'' +
                ", move='" + move + '\'' +
                ", toState='" + toState + '\'' +
                '}';
    }
}
