public class Latihan_Linked_List {
    //No. 1
    public static class Node{
        Object data;
        Node pointer;
        Node(){}
        Node(Object data) {
            this.data = data;
        }
        Node(Object data, Node pointer){
            this.data= data;
            this.pointer= pointer;
        }
    }

    public static void addfirst(Node input){
        if(head==null){
            head=tail=input;
            return;
        }
        input.pointer=head;
        head=input;
    }

    public static void addlast(Node input){
        if(head==null){
            head=tail=input;
            return;
        }
        tail.pointer=input;
        tail=input;
    }

    public static void insertafter(Object key, Node input){
        Node temp=head;
        while(temp!=null && !(temp.data.equals(key))) temp=temp.pointer;
        if(temp==null){
            System.out.println("Key '"+key+"' not found!");
            return;
        }
        input.pointer= temp.pointer;
        temp.pointer= input;
    }

    public static void removefirst(){
        Node temp=head;
        head=head.pointer;
        temp.pointer=null;
    }

    public static void removelast() {
        Node temp=head;
        while(temp!=null && !temp.pointer.equals(tail)) temp=temp.pointer;
        tail=temp;
        tail.pointer=null;
    }

    public static void remove(Object key){
        Node tempA=head;
        Node tempB=null;
        while(tempA!= null && !tempA.data.equals(key)) {
            tempB=tempA;
            tempA=tempA.pointer;
        }
        tempB.pointer=tempA.pointer;
        tempA.pointer=null;
    }
    // No. 2
    public static void printlist(){
        Node temp=head;
        while(temp!=null) {
            System.out.print(temp.data+" ");
            temp=temp.pointer;
        }
        System.out.println();
    }
    
    //No.3
    public static void replace(Object key, int idx){
        Node temp=head;
        for(int i=0; temp!=null; ++i ){
            if(i==idx) {
                temp.data=key;
                return;
            }
            temp=temp.pointer;
        }
    }
    static Node head=null;
    static Node tail=null;
    public static void main(String[] args) {
        Node node400= new Node(400);
        Node node300= new Node(300, node400);
        Node node200= new Node(200, node300);
        Node node100= new Node(100, node200);
        head = node100;
        tail = node400;

        // ===================================
        // No. 1
        Node node500= new Node(500);
        addlast(node500);
        Node node50= new Node(50);
        addfirst(node50);
        Node node250= new Node(250);
        insertafter(200, node250);
        removefirst();
        removelast();
        remove(300);
        // ====================================
        //No. 2
        printlist();
        // ====================================
        //No. 3
        replace(150, 1);
        printlist();
    }
}