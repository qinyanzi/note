package tjm.Kown;

import java.util.*;

import java.util.stream.Stream;


//Stream 流（工厂流水线）
public class Stream_1 {
    public static void main(String[] args) {
        /*Strea流的作用
        结合Lambda表达式，简化集合，数组的操作

        *使用步骤
        0，先得到一条Stream流，将数据放上去
        1，利用Stream中的API进行操作
         *1
            中间方法
            终结方法（最后一步
        * 使用
        单列集合--Collection的默认方法
        双列集合--无法直接使用（转化成单列集合
        数组---Arrays的静态方法

        零散的数据--Stream的静态方法
        */

        //单列集合
        ArrayList<String> list=new ArrayList<>();
        Collections.addAll(list,"a","b","v");
//       Stream<String> stream = list.stream();
//       //遍历
//        stream.forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        });
        //简化
        list.stream().forEach(s -> System.out.println(s));
        System.out.println("================+");
//        双列集合
        HashMap<String,String> hm=new HashMap<>();
        hm.put("互互","科柯璐");
        hm.put("乱路al","huhu");
        hm.put("灰灰","拉乌");
        hm.put("奥莱塔下","玛丽萨他想");

        hm.keySet().stream().forEach(s -> System.out.println(s));
        System.out.println("================+");
        hm.entrySet().stream().forEach(stringStringEntry -> System.out.println(stringStringEntry));
        System.out.println("================+");
    //数组
        int[]array={1,2,3,4,5,8};
        Arrays.stream(array).forEach(x-> System.out.println(x));
        System.out.println("================+");
    //零散数据 Stream的静态方法
        /*of方法的细节
        方法的形参是一个可变参数(可变参数底层是数组)
        可以传递一个数组(数组必须是引用数据类型的)
        * */
    Stream.of("e",1,"nb").forEach(l-> System.out.println(l));
    }
}
