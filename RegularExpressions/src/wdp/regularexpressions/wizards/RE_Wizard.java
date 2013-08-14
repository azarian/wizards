package wdp.regularexpressions.wizards;

import wdp.regularexpressions.model.*;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Date: 7/24/13
 * Time: 5:13 PM
 */
public class RE_Wizard {
    private StringBuilder result;
    private RE currentRE;
    private List<String> examples;



    public StartCreatingRegularExpression start(){
        result = new StringBuilder();
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
            currentRE = new CharacterSet(new SimpleContent(characters,false));
            return new SetQuantifier();
        }

        public SetQuantifier any_character_in_group_defined_as(CharacterSetContent content){
            currentRE = new CharacterSet(content);
            return new SetQuantifier();
        }
        public SetQuantifier any_character_except_in(String characters){
            currentRE = new CharacterSet(new SimpleContent(characters,true));
            return new SetQuantifier();
        }
        public SetQuantifier any_character_in_the_range(String fromCharacter, String untilCharacter){
            currentRE = new CharacterSet(new RangeContent(fromCharacter,untilCharacter,false));
            return new SetQuantifier();
        }
        public SetQuantifier any_character_except_in_the_range(String fromCharacter, String untilCharacter){
            currentRE = new CharacterSet(new RangeContent(fromCharacter,untilCharacter,true));
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
            currentRE = new CharacterSet(new RangeContent(fromCharacter,untilCharacter,false));
            return new SetQuantifier();
        }
        public SetQuantifier any_character_except_in_the_range(String fromCharacter, String untilCharacter){
            currentRE = new CharacterSet(new RangeContent(fromCharacter,untilCharacter,true));
            return new SetQuantifier();
        }
        public ContinueYourRegularExpression then(){
            return this;
        }
        public ContinueYourRegularExpression or(){
            result.append("|");
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
            result.append(currentRE);
            currentRE = null;
            return new ContinueYourRegularExpression();
        }
        public ContinueYourRegularExpression or(){
            result.append(currentRE);
            result.append("|");
            currentRE = null;
            return new ContinueYourRegularExpression();
        }
        private ContinueYourRegularExpression createQuantifier(long min_value, long maxValue) {
            currentRE.setQuantifier(new Quantifier(min_value,maxValue));
            result.append(currentRE);
            currentRE = null;
            return new ContinueYourRegularExpression();
        }

    }
    public static RangeContent range(String from, String until){
        return new RangeContent(from,until,false);
    }
    public static RangeContent not_in_range(String from, String until){
        return new RangeContent(from,until,true);
    }
    public static SimpleContent characters(String str){
        return new SimpleContent(str,false);
    }
    public static SimpleContent not_in_characters(String str){
        return new SimpleContent(str,true);
    }
    public static CompositeCharacterSetContent in_both(CharacterSetContent content1,CharacterSetContent content2){
        return new CompositeCharacterSetContent(CompositeCharacterSetContent.OPERATOR.AND, content1, content2);
    }
    public static CompositeCharacterSetContent in_one_of(CharacterSetContent content1,CharacterSetContent content2){
        return new CompositeCharacterSetContent(CompositeCharacterSetContent.OPERATOR.OR, content1, content2);

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
