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
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void addAndRemoveItem() {
		list.add("a");
		list.delete();
		assertEquals("",list.toString());
	}

}
