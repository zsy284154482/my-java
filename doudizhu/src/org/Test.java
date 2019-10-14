package org;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        /**
         * 模拟斗地主
         * 功能：
         * 1.准备一副牌（54张）
         * 2.洗牌
         * 3.发牌（三个人）
         * 4.留三张底牌
         * 5.每个人拿到牌后进行排序
         */
        Map<Integer,String> puker=new HashMap<>();
        String[] colors={"黑桃","红心","梅花","方块"};
        String[] nums={"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        //遍历
        int index=0;
        for (String num:nums){
            for (String color:colors){
                puker.put(index,color+num);
                index++;
            }
        }
        puker.put(index,"小王");
        index++;
        puker.put(index,"大王");
        //将K提取出来，并存到List中
        Set<Integer> pukerKeys = puker.keySet();
        List<Integer> pukerIndex=new ArrayList<>();

        for (Integer i:pukerKeys){
            pukerIndex.add(i);
        }
        //洗牌
        Collections.shuffle(pukerIndex);
        //三名玩家
        Set<Integer> play1=new TreeSet<>();
        Set<Integer> play2=new TreeSet<>();
        Set<Integer> play3=new TreeSet<>();
        //留三张底牌
        Set<Integer> dipaiIndex=new TreeSet<>();
        dipaiIndex.add(pukerIndex.remove(0));
        dipaiIndex.add(pukerIndex.remove(0));
        dipaiIndex.add(pukerIndex.remove(0));
//        System.out.println("底牌"+dipaiIndex);
        //发牌
        for (int i = 0; i<pukerIndex.size(); i++){
            int mol=i%3;
            if(mol==0){
                play1.add(pukerIndex.get(i));
            }else if (mol==1){
                play2.add(pukerIndex.get(i));
            }else {
                play3.add(pukerIndex.get(i));
            }
        }
        look("底牌",puker,dipaiIndex);
        look("Play1",puker,play1);
        look("Play2",puker,play2);
        look("Play3",puker,play3);

    }
    //看牌的方法
    public static void look(String name,Map<Integer,String> puker,Set<Integer> PlayPukerIndex){
        List<String> pukerValues=new ArrayList<>();
        for (Integer key:PlayPukerIndex){
            pukerValues.add(puker.get(key));
        }
        System.out.println(name + "的牌" + pukerValues);

    }
}
