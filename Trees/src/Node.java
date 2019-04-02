public class Node {
    int data;
    Node left_child, right_child;

    // Node constructor
    public Node(int data){
        this.data = data;
    }

    public void insert(int value){
        if (value <= this.data){
            if (this.left_child == null){
                this.left_child = new Node(value);
            }else {
                this.left_child.insert(value);
            }
        }else {
            if (this.right_child == null){
                this.right_child = new Node(value);
            }else {
                this.right_child.insert(value);
            }
        }
    }

    public boolean contains(int value){
        if (this.data == value){
            return true;
        }

        else {
            if (value < this.data){
                if (this.left_child != null){
                    return (this.left_child.contains(value));
                } else return false;
            }

            else {
                if (this.right_child != null){
                    return (this.right_child.contains(value));
                }
                else return false;
            }
        }
    }

    public void printInOrder(){
        if (right_child != null){
            right_child.printInOrder();
        }
//        System.out.println(data);
        if (left_child != null){
            left_child.printInOrder();
        }
        System.out.println(data);


    }

    public static void main(String[] args) {
        Node new_tree = new Node(1);
        new_tree.insert(10);
//        System.out.println(new_tree.left_child.data);
        new_tree.insert(2);
        new_tree.insert(9);
        new_tree.insert(3);
        new_tree.insert(8);
        new_tree.insert(4);
        new_tree.insert(7);
        new_tree.insert(5);
        new_tree.insert(6);

        if (new_tree.contains(10)){
            new_tree.printInOrder();
        }
//        new_tree.printInOrder();

    }
}
