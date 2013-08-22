package wdp.regularexpressions.examples;

import wdp.regularexpressions.wizards.RE_Wizard;

/**
 * Created with IntelliJ IDEA.
 * User: azaria
 * Date: 22/08/13
 * Time: 07:18
 */
public class TimeExample {
    public static void main(String[] args) {
        //([01]?[0-9]|2[0-3]):[0-5][0-9]
        RE_Wizard re = new RE_Wizard();
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
