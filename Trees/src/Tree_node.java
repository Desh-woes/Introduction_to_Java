import java.lang.reflect.Array;
import java.util.ArrayList;

public class Tree_node {
    Integer data;
    ArrayList<Tree_node> child_node = new ArrayList<>();

    // Node constructor
    public Tree_node(int data){
        this.data = data;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }

    public void insert(int key, int value){
        if (this.data == null){
            new Tree_node(value);
        }
        else if (this.data == key){
            this.child_node.add(new Tree_node(value));
        }
        else {
            this.child_node.get(this.child_node.size()-1).insert(key, value);
        }
    }

    public void printToScreen(){
        if (this.child_node.size() != 0){
            for (int i = 0; i < this.child_node.size(); i++){
//                System.out.println(child_node.get(i).data);
                child_node.get(i).printToScreen();
            }
            System.out.println(this.data);
        }
        else {
            System.out.println(this.data);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] roads = new int[][] {{1, 2}, {1, 3}, {3, 4}, {3, 5}};

        Tree_node new_tree = new Tree_node(roads[0][0]);

        for (int i=0; i < roads.length; i++){
            new_tree.insert(roads[i][0], roads[i][1]);
        }

        new_tree.printToScreen();

    }

}
