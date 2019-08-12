package Iitetor;

import java.util.*;

/**
 * @ClassName TestIterator
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/8/9  2:58 PM
 * @Version 1.0
 */
public class TestIterator {

    public static void main(String[] args){

        Map<Integer,String> map = new HashMap<>();
        map.put(1,"zhang");
        map.put(2,"xin");
        map.put(3,"kun");
        map.put(4,"zhangxinkun");

        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

        for (Map.Entry<Integer,String> entry : map.entrySet()){
            if(entry.getValue().equals("kun")){
                map.remove(entry.getKey());
            }
        }

        Iterator<Map.Entry<Integer,String>> iterable = map.entrySet().iterator();

        while(iterable.hasNext()){
            Map.Entry<Integer,String> entry = iterable.next();
            System.out.println(entry.toString());
        }

        iterable = map.entrySet().iterator();

        while(iterable.hasNext()){
            Map.Entry<Integer,String> entry = iterable.next();
            if(entry.getValue().equals("kun")){
                iterable.remove();
            }
        }

        iterable = map.entrySet().iterator();
        while(iterable.hasNext()){
            Map.Entry<Integer,String> entry = iterable.next();
            System.out.println(entry.toString());
        }
    }
}