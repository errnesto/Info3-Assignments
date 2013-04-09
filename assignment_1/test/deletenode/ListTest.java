package deletenode;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListTest {
	private List list;

	@Before
	public void setUp() throws Exception {
		list = new List();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void deleteFistItem() {
		list.delete("d");
		assertEquals("c,b,a",list.toString());
	}

	@Test
	public void deleteSomeItem() {
		list.delete("c");
		assertEquals("d,b,a",list.toString());
	}
	
	@Test
	public void deleteLastItem() {
		list.delete("a");
		assertEquals("d,c,b",list.toString());
	}
	
	@Test
	public void emptyList() {
		list.delete("a");
		list.delete("b");
		list.delete("c");
		list.delete("d");
		assertEquals("",list.toString());
	}
	
	@Test
	public void addItem() {
		list.add("last");
		assertEquals("last,d,c,b,a",list.toString());
	}
	
	@Test
	public void reverseList() {
		list.reverse();
		assertEquals("a,b,c,d",list.toString());
	}

}
