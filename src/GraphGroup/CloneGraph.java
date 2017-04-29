package GraphGroup;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Wei on 2017/4/29.
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
        if (node == null){
            return null;
        }

        HashMap<UndirectedGraphNode, UndirectedGraphNode> map =
                new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

        ArrayList<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();

        // clone node
        nodes.add(node);
        map.put(node, new UndirectedGraphNode(node.label));

        int start = 0;
        while (start < nodes.size()){
            UndirectedGraphNode head = nodes.get(start++);

            for (int i = 0; i < head.neighbors.size(); i++){
                UndirectedGraphNode neighbor = head.neighbors.get(i);
                if (!map.containsKey(neighbor)){
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    nodes.add(neighbor);
                }
            }
        }

        // clone edge
        for (int i = 0; i < nodes.size(); i++){
            UndirectedGraphNode newNode = map.get(nodes.get(i));
            for (int j = 0; j < nodes.get(i).neighbors.size(); j++){
                newNode.neighbors.add(map.get(nodes.get(i).neighbors.get(j)));
            }
        }

        return map.get(node);
    }


}

class UndirectedGraphNode {
    int label;
    ArrayList<UndirectedGraphNode> neighbors;

    UndirectedGraphNode (int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}