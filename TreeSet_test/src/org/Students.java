package org;


public class Students implements Comparable<Students>{
    private String name;
    private int chinese;
    private int math;
    private int english;
    private int tatalsorce;

    public Students(String name, int chinese, int math, int english) {
        this.name = name;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
        this.tatalsorce=chinese+math+english;
    }
    public Students(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChinese() {
        return chinese;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", chinese=" + chinese +
                ", math=" + math +
                ", english=" + english +
                ", tatalsorce=" + tatalsorce +
                '}';
    }

    @Override
    public int compareTo(Students o) {

        int num=o.tatalsorce-this.tatalsorce;
        //如果总分一样，根据名字来排序
        if (num==0){
            num=this.name.compareTo(o.name);
        }
        //如果名字也一样，为了避免同名没有录进去
        if (num==0){
            num=1;
        }
        return num;
    }
}
