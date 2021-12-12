public class Transition {
    private String fromState;
    private String variable;
    private String pop;
    private String push;
    private String toState;

    public Transition(String fromState, String variable, String pop, String push, String toState) {
        this.fromState = fromState;
        this.variable = variable;
        this.pop = pop;
        this.push = push;
        this.toState = toState;
    }

    @Override
    public String toString() {
        return "Transition{" +
                "fromState='" + fromState + '\'' +
                ", variable='" + variable + '\'' +
                ", pop='" + pop + '\'' +
                ", push='" + push + '\'' +
                ", toState='" + toState + '\'' +
                '}';
    }
}
