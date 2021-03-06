	/* Class node is defined as :
    class Node 
    	int val;	//Value
    	int ht;		//Height
    	Node left;	//Left child
    	Node right;	//Right child

	*/
    public static int size(Node x) {
        if (x == null) {
            return -1;
        }
        
        return x.ht;
    }

    private static int setHeight(Node root) {
        if(root == null) {
            return -1;
        } else {
            return Math.max(size(root.left), size(root.right)) + 1;
        }
    }

    public static Node rightRotation(Node root) {
        Node newRoot = root.left;
        
        root.left = newRoot.right;
        newRoot.right = root;
        root.ht = setHeight(root);
        newRoot.ht = setHeight(newRoot);
        
        return newRoot;
   }

   private static Node leftRotation(Node root) {
       Node newRoot = root.right;
       
       root.right = newRoot.left;
       newRoot.left = root;
       root.ht = setHeight(root);
       newRoot.ht = setHeight(newRoot);
       
       return newRoot;
   }

    static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node();
            root.val = val;
            root.ht = setHeight(root);
            
            return root;
        }
        if (val <= root.val) {
            root.left = insert(root.left, val);
        }
        else if (val > root.val) {
            root.right = insert(root.right, val);
        }
        int balance = size(root.left) - size(root.right);
       
        if (balance > 1) {
            if (size(root.left.left) >= size(root.left.right)) {
                root = rightRotation(root);
            }
            else {
                root.left = leftRotation(root.left);
                root = rightRotation(root);
            }
        }
        else if (balance < -1) {
            if (size(root.right.right) >= size(root.right.left)) {
                root = leftRotation(root);
            }
            else {
                root.right = rightRotation(root.right);
                root = leftRotation(root);
            }
        } else {
            root.ht = setHeight(root);
        }
        
        return root;
    }
