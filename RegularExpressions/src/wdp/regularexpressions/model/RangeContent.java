package wdp.regularexpressions.model;

/**
 * Created with IntelliJ IDEA.
 * Date: 10/08/13
 * Time: 23:54
 */
public class RangeContent extends CharacterSetContent {

    private String from,until;
    private boolean negation;

    public RangeContent(String from, String until, boolean negation) {
        this.from = from;
        this.until = until;
        this.negation = negation;
    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        if (negation){
            str.append("^");
        }
        str.append(from).append("-").append(until);
        return str.toString();
    }
}
