import java.util.LinkedList;
import java.util.Queue;
//git hub token - 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

public class Main {
   public static class Node{
       int data;
       Node left;
       Node right;
       Node(int data){
           this.data = data;
           this.left = null;
           this.right = null;
       }
   }

   public static class BinaryTree {
       static int index = -1;

       public static Node buildTree(int[] arrayInput) {
           index++;
           if (arrayInput[index] == -1) {
               return null;
           }
           Node newNode = new Node(arrayInput[index]);
           newNode.left = buildTree(arrayInput);
           newNode.right = buildTree(arrayInput);

           return newNode;
       }

       public static Node preOrder(Node root) {
           if (root == null) {
               return null;
           }
           System.out.print(root.data + ", ");
           preOrder(root.left);
           preOrder(root.right);
           return root;
       }

       public static Node NRL(Node root) {
           if (root == null) {
               return null;
           }
           System.out.print(root.data + ", ");
           NRL(root.right);
           NRL(root.left);
           return root;
       }

       public static Node InorderTravelsar(Node root) {
           if (root == null) {
               return null;
           }
           InorderTravelsar(root.left);
           System.out.print(root.data + ", ");
           InorderTravelsar(root.right);
           return root;
       }

       public static Node PostOrderTraversal(Node root) {
           if (root == null) {
               return null;
           }
           PostOrderTraversal(root.left);
           PostOrderTraversal(root.right);
           System.out.print(root.data + ", ");
           return root;
       }

       public static void levelOrderTraversal(Node root) {
           Queue<Node> queue = new LinkedList<>();
           queue.add(root);
           queue.add(null);
           System.out.println(" " + root.data);
           printLevel(queue);
       }

       public static void printLevel(Queue<Node> queue) {
           if (queue.element() == null) {
               return;
           }
           while (queue.peek() != null) {
               Node temp = queue.element();
               if (temp.left != null) {
                   queue.add((temp.left));
                   System.out.print(" " + temp.left.data);
               }
               if (temp.right != null) {
                   queue.add((temp.right));
                   System.out.print(" " + temp.right.data);
               }
               queue.poll();
           }
           queue.poll();
           queue.add(null);
           System.out.println();
           printLevel(queue);

       }

       public static int countNodes(Node node) {
           if (node == null) {
               return 0;
           }
           int x = countNodes(node.left);
           int y = countNodes(node.right);
           return x + y + 1;
       }

       public static int sumOfNodes(Node node) {
           if (node == null) {
               return 0;
           }
           int thisNodeData = node.data;
           int x = sumOfNodes(node.left);
           int y = sumOfNodes(node.right);
           return x + y + thisNodeData;
       }
       public static int heightOfTree(Node node){
           if(node == null){
               return 0;
           }
           int x = heightOfTree(node.left);
           int y = heightOfTree(node.right);
           if(x>y){
               return x+1;
           } else if (y>x) {
               return y+1;
           }
           else{
               return x+1;
           }
       }

       public static int diameter(Node node){
           if(node == null){
               return 0;
           }
           int leftDia = diameter(node.left);
           int rightDia = diameter(node.right);
           int currentDia = heightOfTree(node.left) + heightOfTree(node.right) + 1;
           int maxDia = Math.max(Math.max(leftDia, rightDia), currentDia);
           return maxDia;
       }

   }

   public static void main(String[] args){
       int[] input = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, 7, 8,-1,-1,-1,-1};
       BinaryTree binaryTree = new BinaryTree();
       Node rootNode = binaryTree.buildTree(input);
       System.out.println("preOrder (Node left right)");
       binaryTree.preOrder(rootNode);
       System.out.println();
       System.out.println("Node right left");
       binaryTree.NRL(rootNode);
       System.out.println();
       System.out.println("InorderTravelsar (left node right)");
       binaryTree.InorderTravelsar(rootNode);
       System.out.println();
       System.out.println("PostOrderTraversal (left right node)");
       binaryTree.PostOrderTraversal(rootNode);
       System.out.println();
       System.out.println("levelOrderTraversal (left right node)");
       binaryTree.levelOrderTraversal(rootNode);
       System.out.println("Count of total nodes in tree : " +binaryTree.countNodes(rootNode));
       System.out.println("Sum of total nodes in tree : " +binaryTree.sumOfNodes(rootNode));
       System.out.println("height of tree is : " +binaryTree.heightOfTree(rootNode));
       System.out.println("Diameter of tree " + binaryTree.diameter(rootNode));
   }
}