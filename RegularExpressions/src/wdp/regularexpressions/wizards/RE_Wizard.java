package wdp.regularexpressions.wizards;

import wdp.regularexpressions.model.*;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static wdp.regularexpressions.model.PredefinedRE.SET.a_word_character;

/**
 * User: nazaria
 * Date: 7/24/13
 * Time: 5:13 PM
 */
public class RE_Wizard {
    private Group result;
    private RE currentRE;
    private List<String> examples;



    public StartCreatingRegularExpression start(){
        result = new Group();
        currentRE = null;
        examples = new LinkedList<String>();
        return new StartCreatingRegularExpression();
    }

    public class StartCreatingRegularExpression {
        public SetQuantifier a_character_described_as(PredefinedRE.SET set ){
            currentRE = new PredefinedRE(set);
            return new SetQuantifier();

        }
        public SetQuantifier a_fixed_string(String str){
            currentRE = new Literal(str);
            return new SetQuantifier();
        }
        public SetQuantifier any_character_in(String characters){
            currentRE = new SimpleCharacterSet(characters);
            return new SetQuantifier();
        }
        public SetQuantifier any_character_except_in(String characters){
            currentRE = new SimpleCharacterSet(characters,true);
            return new SetQuantifier();
        }
        public SetQuantifier any_character_in_the_range(String fromCharacter, String untilCharacter){
            currentRE = new RangeCharacterSet(fromCharacter,untilCharacter,false);
            return new SetQuantifier();
        }
        public SetQuantifier any_character_except_in_the_range(String fromCharacter, String untilCharacter){
            currentRE = new RangeCharacterSet(fromCharacter,untilCharacter,true);
            return new SetQuantifier();
        }

    }
    public class ContinueYourRegularExpression {
        public SetQuantifier a_character_described_as(PredefinedRE.SET set ){
            currentRE = new PredefinedRE(set);
            return new SetQuantifier();

        }
        public SetQuantifier a_fixed_string(String str){
            currentRE = new Literal(str);
            return new SetQuantifier();
        }
        public SetQuantifier any_character_in_the_range(String fromCharacter, String untilCharacter){
            currentRE = new RangeCharacterSet(fromCharacter,untilCharacter,false);
            return new SetQuantifier();
        }
        public SetQuantifier any_character_except_in_the_range(String fromCharacter, String untilCharacter){
            currentRE = new RangeCharacterSet(fromCharacter,untilCharacter,true);
            return new SetQuantifier();
        }
        public ContinueYourRegularExpression then(){
            return this;
        }
        public ContinueYourRegularExpression for_example(String example){
            examples.add(example);
            return this;
        }

        public String the_end(){
            validateExamples();
            return result.toString();
        }
    }
    public class SetQuantifier {
        public ContinueYourRegularExpression zero_or_more(){
            return createQuantifier(0L,Long.MAX_VALUE);
        }

        public ContinueYourRegularExpression once_or_more(){
            return createQuantifier(0L,Long.MAX_VALUE);
        }
        public ContinueYourRegularExpression exactly_once(){
            return createQuantifier(1L,1L);
        }
        public ContinueYourRegularExpression at_least(long n){
            return createQuantifier(n,Long.MAX_VALUE);
        }
        public ContinueYourRegularExpression exactly(long n){
            return createQuantifier(n,n);
        }
        public ContinueYourRegularExpression from_until(long from , long until){
            return createQuantifier(from, until);
        }
        public ContinueYourRegularExpression then(){
            result.addRE(currentRE);
            currentRE = null;
            return new ContinueYourRegularExpression();
        }
        private ContinueYourRegularExpression createQuantifier(long min_value, long maxValue) {
            currentRE.setQuantifier(new Quantifier(min_value,maxValue));
            result.addRE(currentRE);
            currentRE = null;
            return new ContinueYourRegularExpression();
        }

    }
    private void validateExamples() {
        String re = result.toString();
        Pattern compiledRe = Pattern.compile(re);
        for (String example : examples) {
            Matcher matcher = compiledRe.matcher(example);
            if (!matcher.find()){
                throw new ExampleDoesNotMatchRegularExpression("The example " + example + " does not match the regular expression " + re);
            }
        }

    }

    private class ExampleDoesNotMatchRegularExpression extends RuntimeException {
        public ExampleDoesNotMatchRegularExpression(String s) {
            super(s);
        }
    }


}
