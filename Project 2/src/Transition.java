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

    public boolean isEmptyRead() {
        return variable.equals("ε");
    }

    public boolean isNondeterministic() {
        return variable.equals("ε") && pop.equals("ε") && push.equals("ε");
    }

    public String getFromState() {
        return fromState;
    }

    public String getVariable() {
        return variable;
    }

    public String getPop() {
        return pop;
    }

    public String getPush() {
        return push;
    }

    public String getToState() {
        return toState;
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
