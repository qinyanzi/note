package tjm.Kown;
//异常处理
//异常作用      1，查询bug 2，作为特殊的放回值
/*java.lang.Throwable
1,Error 代表系统级别的错误
2,Exception（父类） 代表程序可能出现的问题
1)RuntimeException
2)其他异常
* 2，
编译时异常，运行时异常
编译···：没有继承RuntimeException的异常，直接继承Exception
运行时异常：编译阶段不会出现异常提醒，运行时出现异常
编译时异常：编译时会出现提醒
*方法
e.getMessage 返回throwable的详细消息字符串
e.toString() 返回可抛出的描述
e.printStackTrace 将错误信息打印在控制台 包含最多信息
*/
public class try_catch {
    public static void main(String[] args) {
        //捕获异常，让代码继续执行
        int[] arr={1,2,3,4,5};
        try {
            //可能执行出现的异常
            System.out.println(arr[10]);
            //出现异常对象去对比Catch内的对象，一致捕获
        }
        catch(ArrayIndexOutOfBoundsException e){
            //出现处理
            System.out.println("索引越界");
           /* String message = e.getMessage();
            String s = e.toString();
            e.printStackTrace();*/
        }
        System.out.println("执行");


/*1.try没有出现异常
将try内的代码执行完毕，不执行catch

2.try遇到多个异常
try遇到异常停止，转到catch
多个异常，多个catch 从上到下匹配， 可以使用|符号  父类异常写下最下
3.try遇到的问题未被捕获
等同于未捕获，交于jvm执行
4.try遇到问题，下面问题不执行
* */
        /*抛出异常
        * throws
        * 写在方法定义处，表示一个异常
        * public void 方法（）throws 异常类名1.异常类名2...{}
        * 编译时异常：必须写
        * 运行时：可以部
        * throw
        * 写在方法内
        *
        * */

    }
}
