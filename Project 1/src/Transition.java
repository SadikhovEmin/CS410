public class Transition {
    public String fromState;
    public char variable;
    public String toState;


    public Transition(String fromState, char variable, String toState) {
        this.fromState = fromState;
        this.variable = variable;
        this.toState = toState;
    }

    @Override
    public String toString() {
        return "Transition{" +
                "fromState='" + fromState + '\'' +
                ", variable=" + variable +
                ", toState='" + toState + '\'' +
                '}';
    }
}
