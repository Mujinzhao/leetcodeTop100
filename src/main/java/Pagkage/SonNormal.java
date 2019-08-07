package Pagkage;

/**
 * @ClassName SonNormal
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/7/8  3:57 PM
 * @Version 1.0
 */
public class SonNormal extends Normal {
    public String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void OnlySonMethod(){
        System.out.println("only son method");
    }

    public void SonMultiplyMethod(String... desc){
        for (int i=0;i<desc.length;i++){
            System.out.println(desc[i]);
        }
    }
}
