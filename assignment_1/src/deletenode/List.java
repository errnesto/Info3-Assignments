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
			newNode.next = first;
			first = newNode;
		}
	}
	/**
	 * delets a given Item from the list
	 * @param item the item to delete
	 * @return weather the item was deletet or not
	 */
	public boolean delete(String item){
		if(first != null){
			//to delete the first item
			if(first.data == item){
				first = first.next;
				return true;
			}
			Node temp = first;
			//loop trough the list
			while (temp.next != null){
				//look if the next element is the item to delete
				if(temp.next.data == item){
					//change the pointer to the item after the next one should be null if trying to delete the last one
					temp.next = temp.next.next;
					//return will stop the function
					return true;
				}
				//look at the next element
				temp = temp.next;
			}
		}
		//the list was empty or nothing found
		return false;
	}
	
	public void reverse(){
		//set up linkers
		Node prev = first;
		Node temp = first.next;
		Node next = temp.next;
		//first node is going to be the last one so next has to be null
		first.next = null;
		//go trough the list
		while(temp != null){
			//set next to the previous node
			temp.next = prev;
			//set up linkers again for the next node
			prev = temp;
			temp = next;
			if(next != null){
				next = next.next;
			}
		}
		//reset anchor to first node
		first = prev;
	}
	
	public String toString(){
		if(first != null){
			return first.toString();
		}else{
			return "";
		}
	}

}
