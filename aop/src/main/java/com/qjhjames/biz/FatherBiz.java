package com.qjhjames.biz;

/**
 * Created by qiujunhong on 2018/4/7.
 */
public abstract   class FatherBiz {

    public FatherBiz(){
        System.out.println("father biz");
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String father;
}
