package HJ66;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
public class Main{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Map<String,String> command=new HashMap<String,String>();//建立命令哈希表
        //向哈希表里添加命令键值对
        command.put("reset","reset what");
        command.put("reset board","board fault");
        command.put("board add","where to add");
        command.put("reboot backplane","impossible");
        command.put("backplane abort","install first");
        command.put("board delete","no board at all");
        Set<String[]> order=new HashSet<String[]>();//建立哈希命令视图
        //遍历哈希表的set视图,向哈希命令表里添加命令
        for(String s:command.keySet())
        {
            order.add(s.split(" "));
        }
        while(sc.hasNextLine())
        {
            String input=sc.nextLine();
            String[] inputChange=input.split(" ");//将输入字符串用空格分隔，以便比较
            String[] compitable=null;//匹配的命令字符串
            //开始遍历命令视图
            for(String[] cmpOrder:order)
            {
                //输入字符串数组长度为一
                if(inputChange.length==1)
                {
                    //命令字符串数组长度为二，不匹配
                    if(cmpOrder.length==2)
                        continue;
                    else
                    {
                        //匹配成功
                        if(cmpOrder[0].startsWith(inputChange[0]))
                        {
                            compitable=cmpOrder;
                            break;
                        }
                    }
                }
                //输入字符串数组长度为二的情况
                if(inputChange.length==2)
                {
                    //如果待比较命令字符串长度为1，不匹配
                    if(cmpOrder.length==1)
                        continue;
                    else
                        //如果输入命令字符串与待比较命令字符串一一匹配，匹配成功
                        if(cmpOrder[0].startsWith(inputChange[0]))
                            if(cmpOrder[1].startsWith(inputChange[1]))
                            {
                                compitable=cmpOrder;
                                break;
                            }
                }
            }
            //从哈希表中找出命令的执行结果并输出
            if(compitable==null)
                System.out.println("unknown command");
            else if(compitable.length==1)
                System.out.println(command.get(compitable[0]));
            else
                System.out.println(command.get(compitable[0]+" "+compitable[1]));
        }
        sc.close();
    }
}