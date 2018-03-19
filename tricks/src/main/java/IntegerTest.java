import java.lang.reflect.Field;

/**
 * java传值传引用和Integer内部在-128~127存数组的trick
 * @author xyw55
 * @date 2018/3/19
 */
public class IntegerTest {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        IntegerTest integerTest = new IntegerTest();
        System.out.println(a + "," + b);

        integerTest.swap(a, b);
        System.out.println(a + "," + b);

    }

    public void swap(Integer num1, Integer num2) {
        /**
         * 传值就是你改变这个值，不会改变原值;
         * 传引用就是你改变这个值，不会改变原值;
         * java方法基本数据类型是传值，对象类型传引用，
         * 当参数是对象时，无论方法体内进行了何种操作，都不会改变实参对象的引用。
         * 当参数是对象时，只有在方法内部改变了对象的内容时，才会改变实参对象内容。
         */
//        int tmp = num1;
//        num1 = num2;
//        num2 = tmp;

        try {
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);

            // tmp=1， 拆箱，取IntegerCache的129位置的值
            int tmp = num1;
            //赋值，将IntegerCache的129位置赋值为2
            field.set(num1, num2);
            //装箱， tmp=1，但是将IntegerCache的129位置的值为2，所以num2为2，因为存在这种情况，所以Integer中value是final字段
            field.set(num2, tmp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
