package tjm.Kown;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

//文件的路径  存档
public class File_ {

    public static void main(String[] args) throws IOException {
        /*
        shift +f6 将同一个字符改变
        file表示路径 文件 文件夹路径
        可以存在也可以部存在


        方法
        * 构造方法
        *1. File（String pathname）根据文件路径创建文件对象
        * 2.····（String parent ，String child） 根据父路径名字符串和子···创建文件对象 拼接，根据所在的系统
        * 3.（File parent,String child)创建文件对象 同理

        成员方法
        1.判断
        Boolean isDirectory（）判断此路径File是否为文件夹
        boolean isFile()判断为···文件
        Boolean exists表示路径file是否存在

        2.获取
        public long length() 只能获取文件大小   无法获取文件夹大小
        String getAbsolutePath() 返回绝对路径 文件
        String getPath()返回文件使用的路径(写什么返回什么
        String getName() 返回文件名 包括后缀
        long lastModified() 返回文件最后修改时间(毫秒值

        3.创建和删除
        boolean createNewFile() 创建一个新的空的文件
        要将完整的路径加上创建的文件名加上调用方法
        如果父路径不存在 异常IOException
        创建一定为文件
            文件存在无法创建成功,参数添加一个要添加的文件名

        ``` mkdir 创建单级文件夹 一般使用下者
        ```mkdirs 创建多级文件夹 底层有mkdir 可以创建单机文件夹
        ``` delete 删除文件和空文件夹 直接删除

        4.获取并遍历
        File[] listFiles() 获取当前该路径的所有内容
        不存在时路径-返回null
        file表示路径时文件时，返回null
        路径是一个空文件夹时，返回长度为零的数组
        是一个有内容的文件夹时，将里面所有的文件和文件夹的路径放进File数组中方返回
        是一个隐藏文件夹时，返回所有，包括隐藏文件夹
        是一个前线时，返回null

        public static File[] listRoots 列出可用目录的系统根 C: D:
        public String []list() 获取该路径下的所有内容（只能获取名字） 返回是一个String数组
        public String []list(FilenameFilter file) 利用文件名过滤器获取当前路径下所有内容
        public File[] listFiles(FilenameFilter filter) 利用文件名过滤器获取当前路径下所有内容
        */


        File f1=new File("D:\\File");
        System.out.println(f1.isDirectory());
        System.out.println(f1.isFile());
        System.out.println(f1.exists());

        File f2=new File("D:\\File\\abc.txt");
        System.out.println(f2.length());
        System.out.println(f2.getAbsolutePath());
        System.out.println(f2.getPath());
        System.out.println(f2.getName());
        System.out.println(f2.lastModified());

        File f3=new File("D:\\File\\c.txt");
        boolean newFile = f3.createNewFile();
        System.out.println(newFile);
//        File f4=new File("D:\\File\\c.txt");
//        System.out.println(f4.delete());

        File f5=new File("D:\\File");
        File[] files=f5.listFiles();
        for (File file : files) {
            System.out.println(file);
        }
        File[] root=File.listRoots();
        System.out.println(Arrays.toString(root));
    }

}
