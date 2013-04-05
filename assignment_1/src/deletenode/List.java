package deletenode;

public class List {
	Node first;
	
	List(){
		
	}
	
	public void add(String item){
		Node newNode = new Node(item);
		if(first == null){
			first = newNode;
		}
		else{
			Node tempNode = first.next;
			newNode.next = tempNode;
			first = newNode;
		}
	}
	
	public void delete(){
		if(first != null){
			first = first.next;
		}
	}
	
	public String toString(){
		if(first != null){
			return first.toString();
		}else{
			return "";
		}
	}

}
