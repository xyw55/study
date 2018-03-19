package chapter5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class chapter5 {
    public static void main(String[] args) {
        System.out.println(Stream.of("a","b","c")
                .map(String::toUpperCase)
                .collect(new StringCollector(", ", "[", "]")));

        System.out.println(Stream.of("a","b","a").collect(new MyGroupBy<String, List<String>>((x)-> new ArrayList<String>(){{
            add(x);}})));
    }
}
