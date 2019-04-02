import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Huffman tree class
public class huffmanTree {
    static Map<Character, String> code_table = new HashMap<Character, String>();

    // Tree node variables.
    Character data;
    int count;
    huffmanTree left_child, right_child;

    // Constructor for node with no data, i.e non leaf nodes
    public huffmanTree(){
//        this.data = data;
    }

    // Constructor for node with data i.e Leaf nodes
    public huffmanTree(Character data, int count){
        this.data = data;
        this.count = count;
    }

    // To string constructor to allow printing of object easier
    @Override
    public String toString() {
        return data+":"+count;
    }

    // Function to traverse tree
    public void gen_codeTable(String code){
        if (left_child == null && right_child == null){
            code_table.put(data, code);
            System.out.println(data+": "+ code);
        }

        else {
            if (right_child != null){
                right_child.gen_codeTable(code+"1");
            }

            if (left_child != null){
                left_child.gen_codeTable(code+"0");
            }
        }

    }

    public static String  encode_message(String message , Map<Character, String>codetable) {
        StringBuilder new_string = new StringBuilder();
        for (char char_key: message.toCharArray()) {
            String code = codetable.get(char_key);
            new_string.append(code);
        }
        return new_string.toString();

    }

    public static String decode_message(String code, huffmanTree root_node){
        huffmanTree curr_node = root_node;
        StringBuilder decoded_msg = new StringBuilder();
        for (char char_code: code.toCharArray()) {
            if (char_code == '0'){
                if (curr_node.left_child == null && curr_node.right_child == null){
                    decoded_msg.append(curr_node.data);
                    curr_node = root_node;
                    curr_node = curr_node.left_child;

                }
                else {
                    curr_node = curr_node.left_child;
                }
            }
            else if (char_code == '1'){
                if (curr_node.left_child == null && curr_node.right_child == null){
                    decoded_msg.append(curr_node.data);
                    curr_node = root_node;
                    curr_node = curr_node.right_child;

                }
                else {
                    curr_node = curr_node.right_child;
                }
            }
        }

        return decoded_msg.append(curr_node.data).toString();
    }

    // Main function to test the tree created
    public static void main(String[] args) {
        // File path
        String file_name = "C:\\Users\\Desh\\IdeaProjects\\Introduction_to_Java\\Trees\\src\\test_input.txt";
        String file_name2 = "C:\\Users\\Desh\\IdeaProjects\\Introduction_to_Java\\Trees\\src\\me_output.txt";

        // New file reader object
        read_file new_reader = new read_file(file_name);
        read_file new_reader2 = new read_file(file_name2);

        // File opener to confirm that the document contains the file
        new_reader.openFile();
        new_reader2.openFile();

        // Get content from the file.
        String file_content = new_reader.readFile();
        String file_content2 = new_reader2.readFile();
        System.out.println(file_content);

        // Function to generate a frequency table from the file content
        ArrayList char_seq = new_reader.get_frequency(file_content);

        // Close file after reading
        new_reader.closeFile();

        // Print the frequency table.
        System.out.println(char_seq.toString());

        // Generate huffman tree
        ArrayList<huffmanTree> tree_node = new_reader.generate_tree(char_seq);
//        System.out.println(tree_node.size()+" "+ tree_node.toString());

        String decoded_msg = decode_message(file_content2, tree_node.get(0));
//        tree_node.get(0).gen_codeTable("");
        System.out.println(decoded_msg);

//        System.out.println(encode_message(file_content, code_table));
//        System.out.println(decode_message(encode_message(file_content, code_table), tree_node.get(0)));
    }
}
