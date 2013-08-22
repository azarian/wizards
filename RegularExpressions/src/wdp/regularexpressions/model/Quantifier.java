package wdp.regularexpressions.model;

/**
 * User: nazaria
 * Date: 7/24/13
 * Time: 4:31 PM
 */
public class Quantifier {

    private long min;
    private long max;

    public Quantifier(long min, long max) {
        this.min = min;
        this.max = max;
    }

    public Quantifier(long min) {
        this.min = min;
        this.max = Long.MAX_VALUE;
    }


    @Override
    public String toString() {
        if (min == 0 && max == 1){
            return "?";
        }
        if (min == max){
            return "{" + min + "}";
        }
        if (max == Long.MAX_VALUE){
            return "{" + min + ",}";
        }
        return "{" + min + "," + max + "}";

    }
}
