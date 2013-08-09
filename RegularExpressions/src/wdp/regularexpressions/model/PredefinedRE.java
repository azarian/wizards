 package wdp.regularexpressions.model;

/**
 * Created with IntelliJ IDEA.
 * User: nazaria
 * Date: 7/30/13
 * Time: 1:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class PredefinedRE extends RE {

    public enum SET{
        any_character("."),
        a_digit("\\d"),
        a_non_digit("\\D"),
        a_whitespace_character("\\s"),
        a_non_whitespace_character("\\S"),
        a_word_character("\\w"),
        a_non_word_character("\\W");

        private String re;
        private SET(String re) {
            this.re = re;
        }
    }

    private SET set;

    public PredefinedRE(SET set) {
        this.set = set;
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append(set.re);
        if (quantifier != null){
            str.append(quantifier.toString());
        }
        return str.toString();
    }
}
