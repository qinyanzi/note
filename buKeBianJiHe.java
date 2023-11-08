package tjm.Kown;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

//不可变集合
/*应用场景
0 如果某个数据不能被修改，把他防御性的拷贝到不可变集合中是一个很好的实践
1 或者当集合被不可信库调用时，不可变形式是安全的
{比如，牌盒中的牌，打牌的规则
*
*List Set  Map        来调用of
*
set 中不能重复元素
Map 中键不能重复,键值对不能超过10个(假如要超过，Map键值一一对应，建为可变的参数，值也就是可变参数
，跟可变参数的使用产生冲突，就要将键值对看成一个来同时传入）如果超过十个就要使用ofEntries()
* */
public class buKeBianJiHe {
    public static void main(String[] args) {
        //创建
        List<String> strings = List.of(" 不可变","创建完成","只能查询");
        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println("-------------------");
        for (int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(i));
        }

        System.out.println("-------------------");
//        strings.remove("不可变");

        HashMap<String,String> hm=new HashMap<>();
        hm.put("a","1");
        hm.put("b","1");
        hm.put("c","2");
        hm.put("d","3");
        hm.put("r","4");
        hm.put("e","5");
        hm.put("t","6");
        hm.put("h","7");
        hm.put("j","8");
        hm.put("m","9");
        hm.put("y","10");

        //获取一个entry对象
        Set<Map.Entry<String, String>> entries = hm.entrySet();
        Map.Entry[] entriesArray = entries.toArray(new Map.Entry[0]);
        //调用toArray();中的指定类型，将数据放进当中，new Map.Entry[0]返回的是一个Map.Entry的数组
        //在底层有添加一个比较，跟创建数组的长度进行(集合11长度大于0创建，若集合小着用数组，多余的0天空），创建的大用创建的，反之

        Map map = Map.ofEntries(entriesArray);
        //
        Map<Object, Object> objectObjectMap = Map.ofEntries(hm.entrySet().toArray(new Map.Entry[0]));
        /* 简化 jdk10 */
        Map<String, String> stringStringMap = Map.copyOf(hm);

        System.out.println("-------------------");





    }
}
