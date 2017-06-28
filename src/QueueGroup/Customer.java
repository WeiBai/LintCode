package QueueGroup;

/**
 * Created by baiwe on 2017/6/27.
 */
public class Customer {
    public int id;
    public String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
