package wdp.regularexpressions.examples;

import wdp.regularexpressions.model.CharacterSet;
import wdp.regularexpressions.model.CompositeCharacterSetContent;
import wdp.regularexpressions.model.PredefinedRE;
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

        String nadav = re.start().any_character_in("NADAV").then().a_character_described_as(PredefinedRE.SET.a_whitespace_character).then().the_end();
        System.out.println("nadav = " + nadav);

        String nadav_or_yosi = re.start().a_fixed_string("Nadav").or().a_fixed_string("Yosi").then().for_example("Nadav").the_end();
        System.out.println("nadav_or_yosi = " + nadav_or_yosi);
        //([01]?[0-9]|2[0-3]):[0-5][0-9]
        String timeRE = re.start().start_group().
                        any_character_in("01").no_more_then(1L).then().
                        any_character_in_the_range("0","9").
                      or().
                        a_fixed_string("2").then().
                        any_character_in_the_range("0","3").then().
                    close_group().
                    then().
                    a_fixed_string(":").then().
                    any_character_in_the_range("0","5").then().
                    any_character_in_the_range("0","9").then().
                for_example("06:58").
                for_example("6:45").
                for_example("23:12").
        the_end();
        System.out.println("timeRE = " + timeRE);


    }
}
