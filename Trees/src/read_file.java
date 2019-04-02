import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class read_file {
    String filename;
    Scanner reader;

    // Constructor to set file name
    public read_file(String filename){
        this.filename = filename;
    }

    // Method to open the file
    public void openFile(){
        try {
            reader = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.out.println(filename);
            e.printStackTrace();
        }
    }

    // Method return a String with the file contents
    public String readFile(){
        StringBuilder accumulator = new StringBuilder();

        while (reader.hasNext()){
            if (accumulator.toString().equals("")){
                accumulator.append(reader.nextLine());
            }
            else{
                accumulator.append("\n").append(reader.nextLine());
            }
        }

        return accumulator.toString();
    }

    // Method generates a frequency table when given a file content
    public ArrayList<huffmanTree> get_frequency(String file_content){
        Map<Character, Integer> frequency_table = new HashMap<Character, Integer>();
        ArrayList<huffmanTree> char_sequence = new ArrayList<huffmanTree>();
        int counter = 0;

        for (char ch: file_content.toCharArray()){
            if (frequency_table.containsKey(ch)){
//                frequency_table.put(ch, frequency_table.get(ch)+1);
                int index = frequency_table.get(ch);
                char_sequence.get(index).count++;

            }
            else {
                frequency_table.put(ch, counter);
                counter++;
                char_sequence.add(new huffmanTree(ch, 1));
//                char_sequence.add(ch);
            }
        }

        return mergeSort(char_sequence,char_sequence.size());
    }

    // Method to sort the frequency table in the order in which it was seen and order of frequency
    public static ArrayList<huffmanTree> mergeSort(ArrayList<huffmanTree> a, int n) {
        if (n < 2) {
            return null;
        }
        int mid = n / 2;
        ArrayList<huffmanTree> l = new ArrayList<>();
        ArrayList<huffmanTree> r = new ArrayList<>();

        for (int i = 0; i < mid; i++) {
            l.add(a.get(i));
        }
        for (int i = mid; i < n; i++) {
            r.add(a.get(i));
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);

        return a;
    }

    public static void merge(ArrayList<huffmanTree> a, ArrayList<huffmanTree> l, ArrayList<huffmanTree> r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l.get(i).count <= r.get(j).count) {
                a.set(k++, l.get(i++));
            }
            else {
                a.set(k++, r.get(j++));
            }
        }
        while (i < left) {
            a.set(k++, l.get(i++));
        }
        while (j < right) {
            a.set(k++, r.get(j++));
        }
    }

    // Function to generate a tree when given the frequency table.
    public ArrayList<huffmanTree> generate_tree(ArrayList<huffmanTree> tree_leaves){
        while (tree_leaves.size() != 1){
            huffmanTree parent_node = new huffmanTree();
            huffmanTree left_node = tree_leaves.remove(0);
            huffmanTree right_node = tree_leaves.remove(0);

            parent_node.left_child = left_node;
            parent_node.right_child = right_node;
            parent_node.count = left_node.count + right_node.count;

            insert_parent(parent_node, tree_leaves);
            System.out.println(tree_leaves.toString());
        }

        return tree_leaves;
    }

    // Function to insert a new parent node back into the array.
    public void insert_parent(huffmanTree parent_node, ArrayList<huffmanTree> tree_leaves){
        for (int i = 0; i < tree_leaves.size(); i++) {
            if(tree_leaves.get(i).count > parent_node.count){
                tree_leaves.add(i, parent_node);
                return;
            }
        }
        tree_leaves.add(parent_node);
    }


    // Method to close the file
    public void closeFile(){
        reader.close();
    }
}
