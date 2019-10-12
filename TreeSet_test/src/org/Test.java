package org;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        Set<Students> set=new TreeSet<Students>();
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入学生信息  格式为：“xxx/xx/xx/xx”，当录入完成后请出入“quit”退出");

        while (true){
            String str=scanner.nextLine();

            if (str.equals("quit")){
                break;
            }
            String[] strs=str.split("/");
            String name=strs[0];
            int chinses=Integer.parseInt(strs[1]);
            int math=Integer.parseInt(strs[2]);
            int english=Integer.parseInt(strs[3]);
            Students students=new Students(name,chinses,math,english);
            set.add(students);
        }

        for (Students student:set){
            System.out.println(student);
        }


    }
}
