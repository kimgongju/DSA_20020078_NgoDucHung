/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/
    static boolean isBST(Node x, Integer min, Integer max) {
        if (x == null) {
            return true;
        }
        if ((min != null && x.data <= min) || (max != null && x.data >= max)) {
            return false;
        }
        
        return isBST(x.left, min, x.data) && isBST(x.right, x.data, max);
    }

    boolean checkBST(Node root) {
        return isBST(root, null, null);   
    }