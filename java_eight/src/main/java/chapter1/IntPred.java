package chapter1;

import java.util.function.Predicate;

public interface IntPred extends  Predicate{
    boolean test(Integer value);
}
