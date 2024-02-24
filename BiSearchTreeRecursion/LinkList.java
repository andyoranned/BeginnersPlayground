/*
 * Name:	Anne Davis
 * Notes:	Code adapted from Robert Lafore's taken from 
 * 			Data Structures and Algorithms in Java. 
 * 			Added code designated with a '~' bar 
 */

class Link
   {	
	public char cData;             // character data item 
	public Node dData;             // Node data item
    public Link next;              // next link in list
// -------------------------------------------------------------
   public Link(Node dd)           // constructor for Node link
      { dData = dd; }

// -------------------------------------------------------------
   public void displayLink()      // display ourself
      { System.out.print(cData + " "); }							
   
   }  // end class Link
////////////////////////////////////////////////////////////////
class LinkList
   {
   private Link first;            // ref to first item on list
// -------------------------------------------------------------
   public LinkList()              // constructor
      { first = null; }           // no items on list yet
// -------------------------------------------------------------
   public boolean isEmpty()       // true if list is empty
      { return (first==null); }
// -------------------------------------------------------------
   public void insertFirst(Node dd) // insert at start of list
   {                           // make new link
	Link newLink = new Link(dd);
	newLink.next = first;       // newLink --> old first
	first = newLink;            // first --> newLink
   }
// -------------------------------------------------------------
   public Node deleteFirst()      // delete first item
   {                           // (assumes list not empty)
	  Link temp = first;          // save reference to link
      first = first.next;         // delete it: first-->old next
      return temp.dData;          // return deleted link
    }
//-------------------------------------------------------------
   }  // end class LinkList
