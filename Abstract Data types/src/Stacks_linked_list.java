import javax.xml.stream.FactoryConfigurationError;

public class Stacks_linked_list {

    public static class new_node{
        String  data;
        new_node next;

        public new_node(String  given_data){
            data = given_data;
            next = null;
        }

        public String get_data(new_node obj){
            return obj.data;
        }

        public new_node get_next(new_node obj){
            return obj.next;
        }
    }



    public static class new_stack {
        new_node top;
        int size;

        public new_stack(){
            top = null;
            size = 0;
        }

        public void push(String data){
            if (top == null){
               top = new new_node(data);
            }
            else{
                new_node obj = new new_node(data);
                obj.next = top;
                top = obj;
            }

            size++;
        }

        public String pop(){
            if (top == null){
                return "sdfdsfdsdsf";
            }
            else {
                new_node obj = top;
                top = obj.next;
                size --;
                obj.next = null;
                return obj.data;
            }
        }

        public String peek(){
            if (top == null){
                return "sdfdssfdsfds";
            }

            else {
                return top.data;
            }
        }

        public boolean is_empty(){
            return size == 0;
        }

        public void display(){
            new_node curr = top;
            if (curr == null){
                System.out.println("There is no item in the new_stack");
            }
            else {
                while (curr.next != null){
                    System.out.println(curr.data);
                    curr = curr.next;
                }
                System.out.println(curr.data);
            }
        }

        public String search(String data){
            new_node curr = top;
            String count = "Does not exist";
            if (curr == null){
                return "Does not exist";
            }
            else {
                while (curr.next != null){
                    if (curr.data.equals(data)){
                        return "Found";
                    }
                    curr = curr.next;
//                    count++;
                }
                if (curr.data.equals(data)){
                    return "Found";
                }
            }return count;
        }

        public boolean complete_parenthesis(String args, new_stack s){
            String [] str_list = args.split(" ");

            for (int i = 0; i < str_list.length; i++){
                if (str_list[i].equals("(")){
                    s.push(str_list[i]);
                }

                else if (str_list[i].equals(")")){
                    String top = s.pop();
                    if (!top.equals("(")){
                        return false;
                    }
                }
            }

            if (s.size != 0){
                return false;
            }

            return true;
        }
    }

    public static void main(String[] args) {
        new_stack s = new new_stack();

//        s.display();

        System.out.println(s.complete_parenthesis("( ( ) ( ( ( ) ) ( ) ) )", s));
    }
}