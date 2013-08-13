package wdp.regularexpressions.examples;

import wdp.regularexpressions.wizards.RE_Wizard;

import static wdp.regularexpressions.wizards.RE_Wizard.*;

/**
 * Created with IntelliJ IDEA.
 * User: azaria
 * Date: 13/08/13
 * Time: 22:28
 * To change this template use File | Settings | File Templates.
 */
public class CompositeGroupExample {
    public static void main(String[] args) {
        RE_Wizard re = new RE_Wizard();
        String s = re.start().any_character_in_group_defined_as(in_both(characters("Abc"), range("A", "Z"))).exactly_once().for_example("A").the_end();
        System.out.println("s = " + s);
    }
}
