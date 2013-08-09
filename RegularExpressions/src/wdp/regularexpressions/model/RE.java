package wdp.regularexpressions.model;

/**
 * User: nazaria
 * Date: 7/24/13
 * Time: 10:19 AM
 */
public abstract class RE {
    Quantifier quantifier;

    public Quantifier getQuantifier() {
        return quantifier;
    }

    public void setQuantifier(Quantifier quantifier) {
        this.quantifier = quantifier;
    }
}
