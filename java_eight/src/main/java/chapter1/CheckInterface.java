package chapter1;

import java.util.function.Predicate;

public interface CheckInterface {
    /**
     * public interface IntPred{
     * Error:(16, 19) java: 对check的引用不明确
     * chapter1.CheckClass 中的方法 check(java.util.function.Predicate<java.lang.Integer>) 和 chapter1.CheckClass 中的方法 check(chapter1.IntPred) 都匹配
     * 修复：public interface IntPred extends  Predicate{
     * 此时有明确的类型，可以根据最具体的类型推到
     * check(x -> x > 5);对应是boolean check(IntPred predicate);
     */
    boolean check(Predicate<Integer> predicate);

    boolean check(IntPred predicate);
}
