package wdp.regularexpressions.model;

import java.util.LinkedList;
import java.util.List;

/**
 * User: nazaria
 * Date: 7/24/13
 * Time: 10:21 AM
 */
public class Group extends RE {
    private List<RE> res = new LinkedList<RE>();

    public void addRE(RE re){
        res.add(re);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
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
