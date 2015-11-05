
package Arboles;


public class B_Node {
    static int t;  //variable to determine order of tree

	int count; // number of keys in node

	int key[];  // array of key values

	B_Node child[]; //array of references

	boolean leaf; //is node a leaf or not

	B_Node parent;  //parent of current node.
	
	Object val;

// ----------------------------------------------------
// this will be default constructor for new node      |
// ----------------------------------------------------

	public B_Node()
	{}
// ----------------------------------------------------
// initial value constructor for new node             |
// will be called from BTree.java                     |
// ----------------------------------------------------

	public B_Node(int t, B_Node parent)
	{
		this.t = t;  //assign size

		this.parent = parent; //assign parent

		key = new int[2*t - 1];  // array of proper size

		child = new B_Node[2*t]; // array of refs proper size

		leaf = true; // everynode is leaf at first;

		count = 0; //until we add keys later.
		
		this.val = val;
	}

// -----------------------------------------------------
// this is method to return key value at index position|
// -----------------------------------------------------

	public int getValue(int index)
	{
		return key[index];
	}

// ----------------------------------------------------
// this is method to get ith child of node            |
// ----------------------------------------------------

	public B_Node getChild(int index)
	{
		return child[index];
	}
}
