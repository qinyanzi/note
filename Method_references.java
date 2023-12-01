package tjm.Kown;

import java.util.*;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//方法引用
/*引用条件
* 1.引用处必须是函数式接口
* 2，被引用方法存在（不存在这需要之间写出
* 3，被引用方法的形参和返回值与抽象方法保持一致
* 4.被引用方法的功能满足需求
*
* 符号：：
* 格式  类名：：引用方法
*
* 方法引用的分类
* 1.引用静态  类名：：静态方法
* 2.引用成员  对象：：成员方法
a，引用其他类的成员 其他类对象：：方法
b。引用本类成员this：：方法名(非静态的方法，如果是静态的要用对象名来引用
c。父类成员super::方法名
*
* * 3，引用构造 创立对象
* 类名：：new
*
*
*
* q。其他调用方式
*   1.使用类名引用成员 类名::成员方法 String::char
* 独特的规则:函数式接口
*          被引用方法存在
* 被引用方法的形参,需要更抽象方法的第二个形参到最后一个形参保持一致,返回值保持一致
* 满足需求
*   抽象方法的详解
* Stream()
*       第一个参数:表示被引用方法的调用者,决定了可以引用那些类的引用方法,
*   在Stream中第一个参数表示流中的数据,假设流中的数据是字符串,使用方法引用时,只能使用
* String的这个类中的方法
*
*       第二个参数到最后一个参数,跟被引用者的形参和返回值报纸一直
*
*   2.引用数组的构造  创建一个数组
* 格式  数据类型[]：new   int[]::new
*
*
 */
//个人认为是在lambda上进行的优化
public class Method_references {
    public static void main(String[] args) {

        //创建一个数组进行倒序排序
        Integer[] arr={2,4,5,6,7,1};
        //匿名内部类
       /* Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });*/

        //lambda
       /* Arrays.sort(arr,( o1,  o2)-> {
            return o2-o1;});
*/
        //方法引用
        Arrays.sort(arr,Method_references::subtraction);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }
        System.out.println("+++++++++++++++++++++");

//        1.引用静态  类名：：静态方法
        ArrayList<String> al=new ArrayList<>();
        al.add("1");
        al.add("2");
        al.add("3");
        al.add("4");
        //常规
        /*al.stream().map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        });*/
        al.stream().map(Integer::parseInt).forEach(s-> System.out.println(s));

        System.out.println("+++++++++++++++++++++++==");
//        3，引用构造 创立对象 类名：：new
//要求成Student 对象并收集到list集合中
        ArrayList<String > al2=new ArrayList<>();
        Collections.addAll(al2,"张无忌,13","周至柔,24","张强,92");
        /*List<Student> collectStudent = al2.stream().map(new Function<String, Student>() {
            @Override
            public Student apply(String s) {
                String name=s.split(",")[0];
                int age=Integer.parseInt(s.split(",")[1]);
                return new Student(name
                        , age);
            }
        }).collect(Collectors.toList());*/
        Set<Student> studentStream = al2.stream().map(Student::new).collect(Collectors.toSet());

        System.out.println(studentStream);

//1.使用类名引用成员 类名::成员方法
        //集合的字符串转化成大写输出
        ArrayList<String> al3=new ArrayList<>();
        al3.add("aaaa");
        al3.add("njdf");
        al3.add("a");
        al3.add("tjianmign");

//        al3.stream().map(new Function<String, String>() {
//            @Override
//            public String apply(String s) {
//                return s.toUpperCase();
//                //toUpperCase 装化成大写
//            }
//        }).forEach(s-> System.out.println(s));
        al3.stream().map(String::toUpperCase).forEach(s -> System.out.println(s));

//        2.引用数组的构造

        //集合中存在一些整数,收集到数组中
        ArrayList<Integer> ar=new ArrayList<>();
        Collections.addAll(ar,1,3,4,5,6,9);
       /* ar.stream().toArray(new IntFunction<Integer[]>() {
            @Override
            public Integer[] apply(int value) {

                return new Integer[value];
            }
        });*/
        Integer[] arNew = ar.stream().toArray(Integer[]::new);
        System.out.println(Arrays.toString(arNew));

    }

    public static int subtraction(int a,int b){
        return b-a;
    }
}
