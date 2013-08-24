package wdp.regularexpressions.examples;

import wdp.regularexpressions.wizards.RE_Wizard;
import static wdp.regularexpressions.model.PredefinedRE.SET.a_digit;
import static wdp.regularexpressions.model.PredefinedRE.SET.a_whitespace_character;


public class BlogPostExample {
    public static void main(String[] args) {

        RE_Wizard re = new RE_Wizard();
        String dur = re.start().
                a_character_described_as(a_digit).exactly(4L).then().
                a_character_described_as(a_whitespace_character).once_or_more().then().
                a_fixed_string("DUR").then().
                a_character_described_as(a_whitespace_character).then().
                a_character_described_as(a_digit).
                for_example("1234 DUR 9").for_example("4423   DUR 1").the_end();
        System.out.println("dur = " + dur);
    }
}
