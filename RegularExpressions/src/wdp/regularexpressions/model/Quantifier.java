package wdp.regularexpressions.model;

/**
 * Created with IntelliJ IDEA.
 * User: nazaria
 * Date: 7/24/13
 * Time: 4:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class Quantifier {

    private long min;
    private long max;

    public Quantifier(long min, long max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public String toString() {
        if (min == max){
            return "{" + min + "}";
        }
        if (max == Long.MAX_VALUE){
            return "{" + min + ",}";
        }
        return "{" + min + "," + max + "}";

    }
}
