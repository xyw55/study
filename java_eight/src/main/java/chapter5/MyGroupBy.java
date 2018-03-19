package chapter5;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * 简单实现了collectors中的groupingby操作
 * @param <T>
 * @param <K>
 */
public class MyGroupBy<T,K> implements Collector<T, Map<K, List<T>>, Map<K, List<T>>>{

    Function<? super T, ? extends K> classifier;

    public MyGroupBy(Function<? super T, ? extends K> classifier) {
        this.classifier = classifier;
    }

    @Override
    public Supplier<Map<K, List<T>>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<K, List<T>>, T> accumulator() {
        return (m ,t) -> {
            m.putIfAbsent(classifier.apply(t), new ArrayList<T>(){{
                add(t);}});
        };
    }

    @Override
    public BinaryOperator<Map<K, List<T>>> combiner() {
        return (m1, m2) -> {
            m1.putAll(m2);
            return m1;
        };
    }

    @Override
    public Function<Map<K, List<T>>, Map<K, List<T>>> finisher() {
        return (m1) -> m1;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }



}
