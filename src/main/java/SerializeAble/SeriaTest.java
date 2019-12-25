package SerializeAble;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName SeriaTest
 * @Author zhangxinkun
 * @Date 2019/12/3  9:01 AM
 * @Version 1.0
 */
@Data
public class SeriaTest implements Serializable {
    private String name;

    private Integer age;

    public static String isable;

    transient private Integer No;

}
