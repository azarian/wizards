package wdp.regularexpressions.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nazaria
 * Date: 7/24/13
 * Time: 10:21 AM
 * To change this template use File | Settings | File Templates.
 */
public class Group extends RE {
    private List<RE> res = new LinkedList<RE>();

    public void addRE(RE re){
        res.add(re);
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        if (res.size() > 1) str.append("(");
        for (RE re : res) {
            str.append(re.toString());
        }
        if (res.size() > 1) str.append(")");
        if (quantifier != null){
            str.append(quantifier.toString());
        }
        return str.toString();
    }
}
