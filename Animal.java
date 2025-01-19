import java.util.ArrayList;
import java.util.List;

abstract class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract String getInfo();

    public void customizeInfo(String customInfo) {

    }
}