package chapter2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class Chapter2 {
    public static void main(String[] args) {
        Chapter2 chapter2 = new Chapter2();
        ArrayList<Integer> arr = new ArrayList<Integer>(){
            {add(1);
            add(2);}
        };
        Integer res = chapter2.addUp(arr.stream());
        System.out.println(res);

        System.out.println(chapter2.findLowwerCharNUmber("dehsifhEHUEU"));

        ArrayList<String> strs = new ArrayList<String>() {
            {
                add("abs");
                add("abs");
                add("abs");
                add("");
            }
        };
        System.out.println(chapter2.findLowwerCharNUmber(strs));

    }


    /**
     * 数值相加
     * @param numbers
     * @return
     */
    private int addUp(Stream<Integer> numbers) {
        return numbers.reduce(0, (acc, number) -> acc + number);
    }

    /**
     * 查找字符串中小写字符的数量
     * @param str
     * @return
     */
    private long findLowwerCharNUmber(String str) {
        return str.chars().filter(x -> x > 97).count();
    }

    /**
     * 查找小写字符最多的字符串
     * @param strs
     * @return
     */
    private Optional<String> findLowwerCharNUmber(ArrayList<String> strs) {

        String minLowwerStr = strs.stream().min(Comparator.comparing(x -> x.chars().filter(i -> i > 97).count())).orElse("");
        return Optional.ofNullable(minLowwerStr);
    }
}
