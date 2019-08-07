package Pagkage;

/**
 * @ClassName Normal
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/7/8  3:55 PM
 * @Version 1.0
 */
public class Normal {
    public String name;
    public String age;
    public static String staticName;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getStaticName() {
        return staticName;
    }

    public static void setStaticName(String staticName) {
        Normal.staticName = staticName;
    }

    public void OnlyFatherMethod(){
        System.out.println("only father method");
    }
}
