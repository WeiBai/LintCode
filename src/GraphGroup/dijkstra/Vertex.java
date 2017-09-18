package GraphGroup.dijkstra;

/**
 * Created by baiwe on 2017/7/28.
 */
public class Vertex {
    final private String id;
    final private String name;

    public Vertex(String id, String name){
        this.id = id;
        this.name = name;
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public String toString(){
        return name;
    }
}
