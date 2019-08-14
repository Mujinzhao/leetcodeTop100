package Interface;

/**
 * @InterfaceName Anlimail
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/7/2  2:03 PM
 * @Version 1.0
 */
public interface Anlimail {
    public static final String name = "Anlimail";

    public abstract String getName();

    public abstract void setName(String name);

    default String testDefaultInterface(){
        return "default test";
    }
}
