package LeadOffer;

import LeetCodeBaseDate.TreeNode;

import java.util.*;

/**
 * @ClassName Test
 * @Author zhangxinkun
 * @Date 2020/4/1  7:30 PM
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args){
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run(){
                System.out.println("jvm 退出");
            }
        });

        while(true){
            System.out.println("nihao");
        }
    }
}
