import java.util.Stack;
public class BiTreeS {
    private Node root;
    public BiTreeS(){
        root = null;
    }
    public String search(int key){
        Node p = root;
        while(true){
            if(p == null){
                return null;
            }else{
                if(key == p.getKey()){
                    return p.getData();
                }else if(key < p.getKey()){
                    p = p.getLeft();
                }else if(key > p.getKey()){
                    p = p.getRight();
                }
            }
        }
    }
    public boolean add(int key, String data){
        Node newNode = new Node(key, data);
        if(root == null){
            root = newNode;
            return true;
        }else{
            Node p = root;
            while(true){
                if(key == p.getKey()){
                    return false;
                }else if(key < p.getKey()){
                    if(p.getLeft() == null){
                        p.addLeft(newNode);
                        return true;
                    }else{
                        p = p.getLeft();
                    }
                }else if(key > p.getKey()){
                    if(p.getRight() == null){
                        p.addRight(newNode);
                        return true;
                    }else{
                        p = p.getRight();
                    }
                }
            }
        }
    }
    public boolean delete(int key){
        Node p = root;
        Node parent = null;
        while(true){
            if(p == null){
                return false;
            }else{
                if(key == p.getKey()){
                    break;
                }else if(key < p.getKey()){
                    parent = p;
                    p = p.getLeft();
                }else if(key > p.getKey()){
                    parent = p;
                    p = p.getRight();
                }
            }
        }
        if(p.getLeft() == null && p.getRight() == null){
            if(p.getKey() < parent.getKey()){
                parent.deleteLeft();
            }else if(p.getKey() > parent.getKey()){
                parent.deleteRight();
            }
        }else if(p.getLeft() == null){
            if(p.getKey() < parent.getKey()){
                parent.addLeft(p.getRight());
            }else if(p.getKey() > parent.getKey()){
                parent.addRight(p.getRight());
            }
        }else if(p.getRight() == null){
            if(p.getKey() < parent.getKey()){
                parent.addLeft(p.getLeft());
            }else if(p.getKey() > parent.getKey()){
                parent.addRight(p.getLeft());
            }
        }else{
            Node tempParent = p;
            Node largestN = p.getLeft();
            while(largestN.getRight() != null){
                tempParent = largestN;
                largestN = largestN.getRight();
            }
            p.update(largestN.getKey(), largestN.getData());
            if(tempParent != p){
                tempParent.addRight(largestN.getLeft());
            }else{
                tempParent.addLeft(largestN.getLeft());
            }
        }
        return true;
    }
    public void printTree() {
		if (root == null) {
			System.out.println("No nodes in this tree");
		} else {
			Stack<Node> stack = new Stack<Node>();
			stack.push(root);
			while (!stack.empty()) {
				Node p = stack.pop();
				System.out.print(p);
				if (p.getLeft() != null || p.getRight() != null)
					System.out.print(" has");
				if (p.getLeft() != null) {
					System.out.print(" " + p.getLeft() + " on left");
					stack.push(p.getLeft());
				}
				if (p.getRight() != null) {
					System.out.print(" " + p.getRight() + " on right");
					stack.push(p.getRight());
				}
				System.out.println("");
			}
		}
	}
    
    public static void main(String[] args) {
		 //Test case 1
		BiTreeS tree = new BiTreeS();
		tree.add(9, "n1");
		tree.add(5, "n2");
		tree.add(10, "n3");
		tree.add(2, "n4");
		tree.add(7, "n5");
		tree.add(11, "n6");
		tree.add(1, "n7");
		tree.add(4, "n8");
		tree.add(3, "n9");
		tree.add(6, "n10");
		tree.add(8, "n11");
		tree.add(12, "n12");
		tree.printTree();

		 //Test case 2
		System.out.println("Search " + 1);
		System.out.println("Result " + tree.search(1));

		System.out.println("Search " + 11);
		System.out.println("Result " + tree.search(11));

		System.out.println("Search " + 20);
		System.out.println("Result " + tree.search(20));


		 //Test case 3
		System.out.println("Delete " + 6);
		tree.delete(6);
		tree.printTree();

		System.out.println("Delete " + 10);
		tree.delete(10);
		tree.printTree();

		System.out.println("Delete " + 5);
		tree.delete(5);
		tree.printTree();
	}

    private class Node {
		private int key;
		private String data;
		private Node right;
		private Node left;

		public Node(int key, String data) {
			this.key = key;
			this.data = data;
			this.right = null;
			this.left = null;
		}

		public int getKey() {
			return key;
		}

		public String getData() {
			return data;
		}

		public void addLeft(Node n) {
			left = n;
		}

		public void addRight(Node n) {
			right = n;
		}

		public void deleteRight() {
			right = null;
		}

		public void deleteLeft() {
			left = null;
		}

		public Node getLeft() {
			return left;
		}

		public Node getRight() {
			return right;
		}

		public void update(int key, String data) {
			this.key = key;
			this.data = data;
		}

		public String toString() {
			return "<" + key + ", " + data.toString() + ">";
		}
	}

}
