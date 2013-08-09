package wdp.regularexpressions.examples;

import wdp.regularexpressions.wizards.RE_Wizard;

import static wdp.regularexpressions.model.PredefinedRE.SET.a_whitespace_character;
import static wdp.regularexpressions.model.PredefinedRE.SET.a_word_character;

/**
 * Created with IntelliJ IDEA.
 * User: azaria
 * Date: 09/08/13
 * Time: 07:26
 * To change this template use File | Settings | File Templates.
 */
public class LiteralsExamples {
    public static void main(String[] args) {
        RE_Wizard re = new RE_Wizard();
        String myFirstRE = re.start().a_fixed_string("My").then().
                a_character_described_as(a_whitespace_character).then().
                a_fixed_string("Expression").then().
                a_fixed_string("!").exactly(3).
                for_example("My Expression!!!").the_end();
        System.out.println("I just built my first regular expression using RE_Wizard and it is  " + myFirstRE);



       /* String reStr = re.start().a_fixed_string("My").exactly_once().then().a_fixed_string("First").at_least(3L).for_example("nadavazariaazariaazaria").the_end();
        System.out.println("reStr = " + reStr);
        String s = re.start().any_character_in_the_range("A","Z").then().any_character_except_in_the_range("a","z").at_least(3).for_example("A333").the_end();
        System.out.println("s = " + s);
        String s1 = re.start().a_character_described_as(a_word_character).exactly_once().then().any_character_in_the_range("A", "Z").then().for_example("AA").the_end();
        System.out.println("s1 = " + s1);*/
    }
}
