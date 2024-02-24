/*
 * Name:	Anne Davis
 * Notes:	Code adapted from Robert Lafore's taken from 
 * 			Data Structures and Algorithms in Java. 
 * 			Anne's code designated with a '~' bar 
 */

class Node
   {
   public char letter;              // data item (key) LETTER **Fields came public from book
   public int intData;         		// data item
   
   
   public Node leftChild;         // this node's left child
   public Node rightChild;        // this node's right child

   public void displayNode()      // display ourself
      {
      System.out.print('{');
      System.out.print(letter);
      System.out.print(", ");
      System.out.print(intData);
      System.out.print("} ");
      }
   }  // end class Node
/////////////////////////////////////////////////////////////////////////////
class Tree
   {
   private Node root;             // first node of tree

// -------------------------------------------------------------
   public Tree()                  // constructor
      { root = null; }            // no nodes in tree yet
   
   
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Anne's Methods   
   
   public void displayLeaves(Node localRoot)
   {
	   if (localRoot==null)								//base case 
		   return;
	   
	   displayLeaves(localRoot.rightChild);				//go to the right leaf first
	   displayLeaves(localRoot.leftChild);				//travel to the left
	   							
	   if (localRoot.leftChild==null&&localRoot.rightChild==null) //at leaf??
		   System.out.print(localRoot.letter);			//print leaf's character
   }//end displayLeaves()
   
   //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   
   public Node getRoot()
   {
	   return root;
   }//end getRoot()
   
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   
   public void pathWords(Node localRoot, Stack pathStack)
   {
	   if (localRoot==null)								//base case
		   return;
	   
	   pathStack.push(localRoot); 						//store Nodes from the path
	   
	   pathWords(localRoot.leftChild, pathStack); 		//recursively go to the left
	   pathWords(localRoot.rightChild, pathStack);		//to the right
	   
	   if (localRoot.leftChild==null&&localRoot.rightChild==null) //at leaf??
	   {
		   pathStack.recursiveStackPrint();  			//Print the path
		   System.out.print(" ");						//space after each "word"
	   }
	   
	   pathStack.pop();									//get rid of letters/nodes as we backtrack
   }//end pathWords()
   
   //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  
   
   public void findFarthestNode(Node localRoot, int edges, Stack staxOfFarthest)
   {
	   if (localRoot==null)								//Base Case
		   return;
	   
	   localRoot.intData= ++edges;						//increment then save in node's data slot the # of edges+1 to root
	   
	   findFarthestNode(localRoot.leftChild, edges, staxOfFarthest);//go down to the left
	   findFarthestNode(localRoot.rightChild, edges, staxOfFarthest);//go down to the right
	   
	   if (localRoot.leftChild==null&&localRoot.rightChild==null)  //at leaf?
	   {
		   if (staxOfFarthest.isEmpty())				//the first leaf?
			   staxOfFarthest.push(localRoot);			//remember it
		   else 										//at another leaf?
		   {
			   Node temp=staxOfFarthest.pop();			//pop the last saved leaf to compare
			   
			   if (temp.intData>localRoot.intData)		//previous leaf further?
				   staxOfFarthest.push(temp);			//save previous
			   else if (temp.intData<localRoot.intData)	//current leaf further?
				   staxOfFarthest.push(localRoot);		//save current
			   if (temp.intData==localRoot.intData)		//Same distance?
			   {
				   staxOfFarthest.push(temp);			//save both
				   staxOfFarthest.push(localRoot);
			   }//end inner if
		   }//end else
	   }//end outer if
   }//end findFarthestNode()
   
 //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   
   public void printFurthestNode()
   {
	   Stack temp=new Stack();							//holds the node(s) farthest from root
	   
	   findFarthestNode(root, -1, temp);				//-1 could never be any other number so that's why it's hardcoded. It felt blasphemous to type. 
	   
	   while (!temp.isEmpty())							//go until stack is exhausted
	   {
		   char tempChar=temp.pop().letter;
		   if (!temp.isEmpty())							//another letter coming after this one?
			   System.out.print(tempChar + ", ");		//yes, print letter with comma
		   else
			   System.out.print(tempChar);				//no, printing w/out comma
	   }//end while loop
   }//end printFurthestNode()
   
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   
   public void printLevels()
   {
	   double n=0;										//how many on each level
	   int level=0;										//which level/exponent value
	   LinkQueue tempQ=new LinkQueue();					//Queue of the tree
	   boolean exit= false;								//while loop control
	   int nullCount=0;									//count nulls on level
	   
	   tempQ.insert(root); 								//store the root
	   
	   while (!exit)									//process whole tree until no more leaves
	   {
		   n=Math.pow(2, level);						//Total possible nodes on each level = 2^(level)
		   
		   for(int i=0; i<n; i++)						//cycle through all nodes on level
		   {
			   Node tempNode=tempQ.remove();			//dequeue next node in line to process
			   
			   if (tempNode==null)						//this subtree empty?
			   {
				   nullCount++;							//keep track of # of nulls
				   tempQ.insert(null);					//placeholder for children
				   tempQ.insert(null);					//necessary to avoid null pointer exception
			   }
			   else										//subtree not empty?
			   {
				   System.out.print(tempNode.letter);	//print node's letter
				   tempQ.insert(tempNode.leftChild);	//enqueue children
				   tempQ.insert(tempNode.rightChild);
			   }
		   }//end for loop
				   
		   if (nullCount==(n))							//all nulls? End of data structure
			   exit=true;								//ends while loop before next iteration
		   
		   level++;										//advance to next level
		   System.out.println();						//And next line
	   }//end outer while loop 
   }//end printLevels()
   //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~End of Anne's methods for Tree class
// -------------------------------------------------------------
   public Node find(char key)      // find node with given key
      {                           // (assumes non-empty tree)
      Node current = root;               // start at root
      while(current.letter != key)        // while no match,
         {
         if(key < current.letter)         // go left?
            current = current.leftChild;
         else                            // or go right?
            current = current.rightChild;
         if(current == null)             // if no child,
            return null;                 // didn't find it
         }
      return current;                    // found it
      }  // end find()
// -------------------------------------------------------------
   public void insert(char id)
      {
      Node newNode = new Node();    // make new node
      newNode.letter = id;           // insert data
     
      if(root==null)                // no node in root
         root = newNode;
      else                          // root occupied
         {
         Node current = root;       // start at root
         Node parent;
         while(true)                // (exits internally)
            {
            parent = current;
            if(id < current.letter)  // go left?
               {
               current = current.leftChild;
               if(current == null)  // if end of the line,
                  {                 // insert on left
                  parent.leftChild = newNode;
                  return;
                  }
               }  // end if go left
            else                    // or go right?
               {
               current = current.rightChild;
               if(current == null)  // if end of the line
                  {                 // insert on right
                  parent.rightChild = newNode;
                  return;
                  }
               }  // end else go right
            }  // end while
         }  // end else not root
      }  // end insert()
// -------------------------------------------------------------
   public boolean delete(char key) // delete node with given key
      {                           // (assumes non-empty list)
      Node current = root;
      Node parent = root;
      boolean isLeftChild = true;

      while(current.letter != key)        // search for node
         {
         parent = current;
         if(key < current.letter)         // go left?
            {
            isLeftChild = true;
            current = current.leftChild;
            }
         else                            // or go right?
            {
            isLeftChild = false;
            current = current.rightChild;
            }
         if(current == null)             // end of the line,
            return false;                // didn't find it
         }  // end while
      // found node to delete

      // if no children, simply delete it
      if(current.leftChild==null &&
                                   current.rightChild==null)
         {
         if(current == root)             // if root,
            root = null;                 // tree is empty
         else if(isLeftChild)
            parent.leftChild = null;     // disconnect
         else                            // from parent
            parent.rightChild = null;
         }

      // if no right child, replace with left subtree
      else if(current.rightChild==null)
         if(current == root)
            root = current.leftChild;
         else if(isLeftChild)
            parent.leftChild = current.leftChild;
         else
            parent.rightChild = current.leftChild;

      // if no left child, replace with right subtree
      else if(current.leftChild==null)
         if(current == root)
            root = current.rightChild;
         else if(isLeftChild)
            parent.leftChild = current.rightChild;
         else
            parent.rightChild = current.rightChild;

      else  // two children, so replace with inorder successor
         {
         // get successor of node to delete (current)
         Node successor = getSuccessor(current);

         // connect parent of current to successor instead
         if(current == root)
            root = successor;
         else if(isLeftChild)
            parent.leftChild = successor;
         else
            parent.rightChild = successor;

         // connect successor to current's left child
         successor.leftChild = current.leftChild;
         }  // end else two children
      // (successor cannot have a left child)
      return true;                                // success
      }  // end delete()
// -------------------------------------------------------------
   // returns node with next-highest value after delNode
   // goes to right child, then right child's left descendents
   private Node getSuccessor(Node delNode)
      {
      Node successorParent = delNode;
      Node successor = delNode;
      Node current = delNode.rightChild;   // go to right child
      while(current != null)               // until no more
         {                                 // left children,
         successorParent = successor;
         successor = current;
         current = current.leftChild;      // go to left child
         }
                                           // if successor not
      if(successor != delNode.rightChild)  // right child,
         {                                 // make connections
         successorParent.leftChild = successor.rightChild;
         successor.rightChild = delNode.rightChild;
         }
      return successor;
      }
// -------------------------------------------------------------
   public void traverse(int traverseType)
      {
      switch(traverseType)
         {
         case 1: System.out.print("\nPreorder traversal: ");
                 preOrder(root);
                 break;
         case 2: System.out.print("\nInorder traversal:  ");
                 inOrder(root);
                 break;
         case 3: System.out.print("\nPostorder traversal: ");
                 postOrder(root);
                 break;
         }
      System.out.println();
      }
// -------------------------------------------------------------
   private void preOrder(Node localRoot)
      {
      if(localRoot != null)
         {
         System.out.print(localRoot.letter + " ");
         preOrder(localRoot.leftChild);
         preOrder(localRoot.rightChild);
         }
      }
// -------------------------------------------------------------
   private void inOrder(Node localRoot)
      {
      if(localRoot != null)
         {
         inOrder(localRoot.leftChild);
         System.out.print(localRoot.letter + " ");
         inOrder(localRoot.rightChild);
         }
      }
// -------------------------------------------------------------
   private void postOrder(Node localRoot)
      {
      if(localRoot != null)
         {
         postOrder(localRoot.leftChild);
         postOrder(localRoot.rightChild);
         System.out.print(localRoot.letter + " ");
         }
      }
// -------------------------------------------------------------
   public void displayTree()
      {
      Stack globalStack = new Stack();
      globalStack.push(root);
      int nBlanks = 32;
      boolean isRowEmpty = false;
      System.out.println(
      "......................................................");
      while(isRowEmpty==false)
         {
         Stack localStack = new Stack();
         isRowEmpty = true;

         for(int j=0; j<nBlanks; j++)
            System.out.print(' ');

         while(globalStack.isEmpty()==false)
            {
            Node temp = (Node)globalStack.pop();
            if(temp != null)
               {
               System.out.print(temp.letter);
               localStack.push(temp.leftChild);
               localStack.push(temp.rightChild);

               if(temp.leftChild != null ||
                                   temp.rightChild != null)
                  isRowEmpty = false;
               }
            else
               {
               System.out.print("--");
               localStack.push(null);
               localStack.push(null);
               }
            for(int j=0; j<nBlanks*2-2; j++)
               System.out.print(' ');
            }  // end while globalStack not empty
         System.out.println();
         nBlanks /= 2;
         while(localStack.isEmpty()==false)
            globalStack.push( localStack.pop() );
         }  // end while isRowEmpty is false
      System.out.println(
      "......................................................");
      }  // end displayTree()
// -------------------------------------------------------------
   }  // end class Tree
////////////////////////////////////////////////////////////////
