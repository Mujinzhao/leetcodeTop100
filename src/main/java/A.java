/**
 * @ClassName A
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/7/1  10:23 AM
 * @Version 1.0
 */
public class A {
    int age;
    String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public class B extends A{
        @Override
        public void setName(String name) {
            super.name = name + " B";
        }

        @Override
        public String toString() {
            return "B{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public class C extends A{
        @Override
        public void setName(String name) {
            super.name = name + " C";
        }

        @Override
        public String toString() {
            return "B{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
