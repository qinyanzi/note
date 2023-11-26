package tjm.Kown;
//Stream的中间方法 filter limit skip,distinct,concat,map
//Stream的终结方法forEach count collect
//Stream的收集方法
import java.util.*;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Stream_2 {
    public static void main(String[] args) {
        /*
        filter--过滤
        limit---获取前几个元素
        skip----跳过前几个元素
       distinct-元素去重（hashCode and equal方法
       concat---合并a和b两个流
        map-----转化流的数据类型

       注意：中间方法，返回新的Stream流，原来的流只能使用一次（建议使用链式编程
        修改Stream的数据不会影响原来的集合或数据

        * */

       /*void forEach(Consumer action) 遍历

       list.stream.forEach(new Consumer<String>){
       public accept(String){sout.}
       }
       *count()统计

       toArray()收集数据放入数组中
       */

        /*
        * */


        ArrayList<String> list=new ArrayList<>();
        ArrayList<String> list2=new ArrayList<>();
        Collections.addAll(list,"张订单","张订单","张订单","超发","张发","张三族","预测是");
        Collections.addAll(list2,"第二个");

        System.out.println(list);
//filter
        //匿名
        /*list.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                //s表示每个数据
                //true 当前数据保留

                return s.startsWith("张");
            }
        }).forEach(s -> System.out.println(s));*/
        list.stream().filter(s->s.startsWith("张"))
                .filter(s -> s.length()==3)
                .forEach(s-> System.out.println(s));

//limit

        System.out.println("============================");
list.stream().limit(3).forEach(s -> System.out.println(s));
        System.out.println("============================");
//skip
        list.stream().skip(3).forEach(s -> System.out.println(s));

        System.out.println("============================");
//distinct
        list.stream().distinct().forEach(s -> System.out.println(s));
//concat
        System.out.println("===============concat=============");
        Stream.concat(list.stream(),list2.stream()).forEach(s -> System.out.println(s));

//map
        ArrayList<String> list3=new ArrayList<>();
        Collections.addAll(list3,"张订单-1","张订单-23","张订单-09","超发-49","张发-23","张三族-34","预测是-9");
    //获取里面的数据
        System.out.println("============================");
      /*  list3.stream().map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                String[] arr=s.split("-");
                String num=arr[1];
                int age=Integer.parseInt(num);
                return age;


            }
            //第一个原本数据类型
            //要转化的数据类型

//            返回--转化的值
        }).forEach(s-> System.out.println(s));*/
list3.stream().map(s->Integer.parseInt(s.split("-")[1])).forEach(s-> System.out.println(s));
//count
        long count = list3.stream().count();        System.out.println("============================");

        System.out.println(count);

//toArray
        Object[] objects = list3.stream().toArray();
        System.out.println("============================");
        System.out.println(Arrays.toString(objects));
//toArray的指定类型
        /*String[] strings = list3.stream().toArray(new IntFunction<String[]>() {
            //IntFunction的泛型，具体类形的数组
            @Override
            public String[] apply(int value) {
                //apply，参数，流中数据个数，跟数组的长度保持一致
                //apply，返回值，juti leix d shuzu
                return new String[value];
            }
        });*/
        String[] strings = list3.stream().toArray(value -> new String[value]);
        System.out.println(Arrays.toString(strings));
        System.out.println("============================");

        ArrayList<String> collectF=new ArrayList<>();

//        tolist
        Collections.addAll(collectF,"张就-男","张就-男","倪浩-男","王景玉-女","照明-女","张小应-女");
        List<String> collectF1 = collectF.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return "男".equals(s.split("-")[1]);
            }
        }).collect(Collectors.toList());
        System.out.println(collectF1);

//        toset
        Set<String> collectF2 = collectF.stream().filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toSet());
        System.out.println(collectF2);
//#toset和同tolist的区别是list,与set的分别

//        tomap 键不能重复

        Map<String, Integer> collectMap = collectF.stream().filter(s -> "男".equals(s.split("-")[1])).collect(Collectors.toMap(
               /* tomap
                 * 参数一:表示键的规则
                 * 参数二:表示值的规则
                 *
                 * Function泛型一:表示流的每一个数值的类形
                 * 泛型二:表示map的中键的类形
                 *
                 * 方法apple 的形参依次表示流里的每一个数据
                 *   方法体:成生键的代码
                 *
                 * 同理
                 *
                 * */
                new Function<String, String>() {
                    @Override
                    public String apply(String s) {

                        return s.split("-")[0];
                    }
                }, new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return Integer.parseInt(s.split("-")[1]);
                    }
                }));
            //L
     /*collectF.stream().
             filter(s -> "男".equals(s.split("-")[1])
             .collect(Collectors.toMap(s -> s.split("-")[0]),
             s->Integer.parseInt(s.split("-")[2])));*/
    }
}
