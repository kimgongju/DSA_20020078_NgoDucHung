

	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static void levelOrder(Node root) {
        LinkedList<Node> nodes = new LinkedList<>();
        
        nodes.add(root);
        while (!nodes.isEmpty()) {
            if (nodes.peek().left != null) {
                nodes.add(nodes.peek().left);
            }
            if (nodes.peek().right != null) {
                nodes.add(nodes.peek().right);
            }
            System.out.print(nodes.poll().data + " ");
        }
    }

