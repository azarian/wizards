package wdp.regularexpressions.examples;

import wdp.regularexpressions.wizards.RE_Wizard;

/**
 * User: azaria
 * Date: 10/08/13
 * Time: 07:18
 */
public class RangeExamples {
    public static void main(String[] args) {
        RE_Wizard re = new RE_Wizard();
        String rangeRE = re.start().any_character_in_the_range("1", "9").at_least(2).then().any_character_except_in_the_range("A", "D").exactly_once().for_example("99V").the_end();
        System.out.println("rangeRE = " + rangeRE);
    }
}
