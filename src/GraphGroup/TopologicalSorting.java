package GraphGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Wei on 2017/5/1.
 */
public class TopologicalSorting {

    public ArrayList<DirectedGraphNode> sort(ArrayList<DirectedGraphNode> graph){
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();

        HashMap<DirectedGraphNode, Integer> map = new HashMap<>();

        for (DirectedGraphNode node : graph){
            for (DirectedGraphNode neighbor : node.neighbors){
                     if (map.containsKey(neighbor)){
                         map.put(neighbor, map.get(neighbor) + 1);
                     } else {
                         map.put(neighbor, 1);
                     }
            }
        }

        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
        for (DirectedGraphNode node: graph){
            if (!map.containsKey(node)){
                queue.offer(node);
                result.add(node);
            }
        }

        while (!queue.isEmpty()){
            DirectedGraphNode node = queue.poll();
            for (DirectedGraphNode neighbor : node.neighbors){
                map.put(neighbor, map.get(neighbor) - 1);
                if (map.get(neighbor) == 0){
                    queue.add(neighbor);
                    result.add(neighbor);
                }
            }
        }

        return result;
    }
}

class DirectedGraphNode{
    int label;
    ArrayList<DirectedGraphNode> neighbors;

    public DirectedGraphNode(int label){
        this.label = label;
        neighbors = new ArrayList<DirectedGraphNode>();
    }
}
