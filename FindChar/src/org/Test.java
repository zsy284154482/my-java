package org;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args) throws IOException {
        //练习:获取文本上字符出现的次数,把数据写入文件
	/*思路：
		1.遍历文本每一个字符
		2.字符出现的次数存在Map中*/
        Map<Character,Integer> map=new HashMap<>();
        FileReader fr=new FileReader("a.txt");
        BufferedWriter bw=new BufferedWriter(new FileWriter("b.txt"));
        int b;
        while ((b=fr.read())!=-1){
            char c=(char)b;
            if (map.get(c)==null){
                map.put(c,1);
            }else{
                map.put(c,map.get(c)+1);
            }
        }

        for (Map.Entry<Character,Integer> entrys : map.entrySet()){
            switch (entrys.getKey()){
                case ' ':
                    bw.write("空格="+entrys.getValue());
                    break;
                case '\t':
                    bw.write("tab键="+entrys.getValue());
                    break;
                case '\r':
                    bw.write("回车=" + entrys.getValue());
                    break;
                case '\n':
                    bw.write("换行=" + entrys.getValue());
                    break;
                default:
                    bw.write(entrys.getKey() + "="+ entrys.getValue());
            }
            bw.newLine();
        }
        fr.close();
        bw.close();
    }
}
