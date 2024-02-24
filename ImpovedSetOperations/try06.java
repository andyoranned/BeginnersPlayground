package try06;
import java.util.*;
import java.util.ArrayList;
public class try06{
	private static void intersection(set A,set B,String a,String b) {
		ArrayList<String> fin = new ArrayList<String>();
		System.out.print("{");
		for(int i=0;i<A.toArray(a).length;i++) {
			for(int j=0;j<B.toArray(b).length;j++) {
				if(A.toArray(a)[i]==null||B.toArray(b)==null) {
				}else if(A.toArray(a)[i].equals(B.toArray(b)[j])) {
					fin.add(A.toArray(a)[i]);
				}
			}
		}
		
	    LinkedHashSet<String> set = new LinkedHashSet<String>(fin.size());
	    set.addAll(fin);
	    fin.clear();
	    fin.addAll(set);
	    Collections.sort(fin);
	    
	    System.out.print(fin);
		System.out.print("}"+"\n");
		System.out.println("intersection calculation finished,system close");
	}
	private static void union(set A,set B,String a,String b) {
		ArrayList<String> fin = new ArrayList<String>();
		System.out.print("{");
		
		for(int i=0;i<A.toArray(a).length;i++) {
			if(A.toArray(a)[i]!=null&&A.toArray(a)[i].length()>0) {
				fin.add(A.toArray(a)[i]);
			}
		}
		
		for(int i=0;i<B.toArray(b).length;i++) {
			if(B.toArray(b)[i]!=null&&B.toArray(b)[i].length()>0) {
				fin.add(B.toArray(b)[i]);
			}
		}
		
	    LinkedHashSet<String> set = new LinkedHashSet<String>(fin.size());
	    set.addAll(fin);
	    fin.clear();
	    fin.addAll(set);
	    Collections.sort(fin);
	    
	    System.out.print(fin);
		System.out.print("}"+"\n");
		System.out.println("union calculation finished,system close");
	}
	private static void complement(set A,set B,String a,String b) {
		ArrayList<String> Conp = new ArrayList<String>();
		for(int k=0;k<A.toArray(a).length;k++) {
			for(int i=0;i<A.toArray(a).length;i++) {
				Conp.add(A.toArray(a)[i]);
			}
			for(int i=0;i<A.toArray(a).length;i++) {
				for(int j=0;j<B.toArray(b).length;j++) {
					if(Conp.contains(B.toArray(b)[j])) {
						Conp.remove(B.toArray(b)[j]);
					}
				}
			}
		}
	    LinkedHashSet<String> set = new LinkedHashSet<String>(Conp.size());
	    set.addAll(Conp);
	    Conp.clear();
	    Conp.addAll(set);
	    Collections.sort(Conp);
		System.out.println("{"+Conp+"}");
		System.out.println("complement calculation finished,system close");
	}
	private static void subset(set A,set B,String a,String b) {
		int counter=0;
		for(int i=0;i<A.toArray(a).length;i++) {
			for(int j=0;j<B.toArray(b).length;j++) {
				if(A.toArray(a)[i]==null) {}
				else if(B.toArray(b)[j]==null) {}
				else if(A.toArray(a)[i].equals(B.toArray(b)[j])) {
					counter++;
				}
			}
		}
		if(counter>=A.toArray(a).length-1) {
			System.out.println("A is a subset of B");
			System.out.println("subset calculation finished,system close");
		}else {
			System.out.println("A is not a subset of B");
			System.out.println("subset calculation finished,system close");
		}
	}
	private static void print(String[] a) {
		System.out.print("{");
		for(int i=1;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		System.out.print("}");
		System.out.println("Length of the array is "+(a.length-1));
	}
	public static void main(String[]args) {
		Scanner kb=new Scanner(System.in);
		System.out.println("Please enter an array, Starting with 'A' such as 'A123345567'(case not sensative)");
		String a = kb.next();
		set A = new set(a);
		print(A.toArray(a));
		System.out.println("Please enter an array, Starting with 'B' such as 'B281238913'(case not sensative)");
		String b = kb.next();
		set B = new set(b);
		print(B.toArray(b));
		System.out.println("please enter the process you want");
		System.out.println("union or +,intersection or ^,complement or -"+", or subset");
		String choice=kb.next();
		switch(choice.toLowerCase()) {
		case "union":
			union(A,B,a,b);
			break;
		case "+":
			union(A,B,a,b);
			break;
		case "intersection":
			intersection(A,B,a,b);
			break;
		case "^":
			intersection(A,B,a,b);
			break;
		case "complement":
			complement(A,B,a,b);
			break;
		case "-":
			complement(A,B,a,b);
			break;
		//ADD subset method
		case "subset":
			subset(A,B,a,b);
			break;
		default :
			System.out.println("This is not an opinion,system close");
			kb.close();
		}
		kb.close();
	}
}	
class set{
	String a;
	public set(String a){
		this.a=a;
	}
	private String[] Array (String a) {
		String [] Array= new String[a.length()];
		for(int i=1;i<a.length();i++) {
			Array[i]=Character.toString(a.charAt(i));
		}
		return Array;
	}
	public String[] toArray(String a) {
		return Array(a);
	}
}