import java.util.Objects;

public class LinkListOperations {
    node head=null;
    node hare = head;
    node turtle = head;
    public void printLL(){
        node temp = head;
        System.out.println();
        while(temp.next!=null){
            System.out.print(temp.data+ " ==> ");
            temp=temp.next;
        }
        System.out.print(temp.data);
        System.out.println();
    }
    public void createNode(int data){
        if(head == null ){
            head= new node(data);
        }
        else{
            node temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = new node(data);
        }
        printLL();
    }

    public void deleteNode(int data){
        if(head == null){
            System.out.println("\n Please enter the node 1st");
        }
        else{
            if(head.data == data){
                node temp1 = head;
                head = head.next;
                temp1 = null;
            }
            else{
                node temp2 = head;
                node temp3;
                int flag = 0;
                while(temp2.next!=null){
                    if(temp2.next.data == data){
                        temp3 = temp2.next;
                        temp2.next = temp2.next.next;
                        flag = 1;
                        printLL();
                        break;
                    }
                    temp2 = temp2.next;
                }
                if(flag == 0){
                    System.out.println(data + " not found");
                }
            }
            printLL();
        }

    }

    public void insertNode(int dataFirst, int data){
       if(head.data == dataFirst){
           node newHead = new node(data);
           newHead.next = head;
           head = newHead;
       }
       else{
           node temp = head;
           while(temp.next!= null){
               if(temp.data == dataFirst){
                   node temp2 = temp.next;
                   temp.next = new node(data);
                   temp.next.next = temp2;
               }
               temp = temp.next;
           }
           if(temp.data == dataFirst){
               temp.next = new node(data);
           }
       }
        printLL();
    }

    public node getMiddle(){
        node turtle=head, hare=head;
        while( hare.next!=null && hare.next.next!=null ){
            hare = hare.next.next;
            turtle= turtle.next;
        }
        return turtle;
    }

    public node reverseFromMiddle(){
        node middle = getMiddle();
        node temp = middle.next.next;
        node current = middle.next;
        while(temp.next != null){
            node temp2 = temp.next;
            temp.next = current;
            current = temp;
            temp = temp2;
        }
        temp.next = current;
        middle.next.next = null;
        return temp;
    }

    public boolean isPalindrom(){
        node secondHead  = reverseFromMiddle();
        node firstHead = head;
        boolean result = true;
        while(secondHead!=null){
            if(secondHead.data != firstHead.data){
                result = false;
            }
            secondHead = secondHead.next;
            firstHead = firstHead.next;
        }
        return result;
    }
    public node findNode(int data){
        node n1 = null;
        n1 = head;
        while(n1.data != data && n1!=null){
            n1 = n1.next;
        }
        if(n1 != null){
            return n1;
        }
        return null;
    }

    public String createCycle(int from, int to){
        node n1 = findNode(from);
        node n2 = findNode(to);
        String result;
        if(n1!=null && n2!=null){
            n1.next = n2;
            result = "cycle created";
        }
        else{
            result = "cycle not created";
        }
        return result;
    }

    public String detectCycle(){
        node head=this.head;
        hare = head;
        turtle = head;
        hare = hare.next.next;
        turtle = turtle.next;
        while(hare!=null &&  hare.next!=null){
            if(hare==turtle ){
                return "Cycle present";
            }
            hare = hare.next.next;
            turtle = turtle.next;
        }
        return "Cycle not present";
    }

    public String removeCycle(){
        if(Objects.equals(detectCycle(), "Cycle present")){
            node head = this.head;
            node preTurtle = null;
            while(head != turtle){
                head = head.next;
                preTurtle = turtle;
                turtle = turtle.next;
            }
            if(preTurtle!=null){
                preTurtle.next = null;
                return "Cycle was present at " + preTurtle.data + " removed now";
            }
            return "Cycle was present but not able to remove";
        }
        else{
            return "Cycle not present";
        }
    }
    public void reverseList() {
        node mainHead = head;
        node n1 = mainHead.next;
        node n2 = mainHead.next.next;
        mainHead.next = null;
        while(n2 != null ){
            n1.next = mainHead;
            mainHead = n1;
            n1 = n2;
            n2 = n2.next;
        }
        n1.next = mainHead;
        head = n1;
    }
}