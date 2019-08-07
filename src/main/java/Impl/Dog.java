package Impl;

import Interface.Anlimail;

/**
 * @ClassName Dog
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/7/2  2:10 PM
 * @Version 1.0
 */
public class Dog {
    public String name;

    public Dog(){
        this("dog");
    }

    public Dog(String name) {
        this.name = name;
    }

    public Integer test(String dogName){
        System.out.println(dogName);
        return 1;
    }

}
