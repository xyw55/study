package chapter1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Predicate;

public class Chapter1 {
    public static void main(String[] args) {
        ThreadLocal<SimpleDateFormat> simpleDateformat = ThreadLocal.withInitial(() -> new SimpleDateFormat("YYYY-MM-dd HH:mm:ss"));
        System.out.println(simpleDateformat.get().format(new Date()));

        Runnable helloLambda = () -> System.out.println("hello lambda");
        Thread thread = new Thread(helloLambda);
        thread.run();


        /**Error:(16, 19) java: 对check的引用不明确
        chapter1.CheckClass 中的方法 check(java.util.function.Predicate<java.lang.Integer>) 和 chapter1.CheckClass 中的方法 check(chapter1.IntPred) 都匹配
        */
        // CheckClass checkClass = new CheckClass();
        // checkClass.check(x -> x > 5);



    }
}

class CheckClass implements CheckInterface {

    @Override
    public boolean check(Predicate<Integer> predicate) {
        return false;
    }

    @Override
    public boolean check(IntPred predicate) {
        return false;
    }
}
