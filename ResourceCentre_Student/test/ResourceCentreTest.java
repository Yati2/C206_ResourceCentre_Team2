import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//djksajdlsajdsladjaks

public class ResourceCentreTest {
	private Camcorder cc1;
	private Camcorder cc2;
	private Chromebook cb1;
	private Chromebook cb2;

	private ArrayList<Camcorder> camcorderList;
	private ArrayList<Chromebook> chromebookList;

	public ResourceCentreTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		// prepare test data
		cc1 = new Camcorder("CC0011", "Nikon HDSLR", 40);
		cc2 = new Camcorder("CC0012", "Sony DSC-RX100M7", 20);
		cb1 = new Chromebook("CB0011", "My Google Chromebook 1st", "Mac OS");
		cb2 = new Chromebook("CB0012", "SAMSUNG Chromebook 4+", "Win 10");

		camcorderList = new ArrayList<Camcorder>();
		chromebookList = new ArrayList<Chromebook>();
	}

	@Test
	public void testAddCamcorder() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);

		// Given an empty list, after adding 1 item, the size of the list is 1
		ResourceCentre.addCamcorder(camcorderList, cc1);
		assertEquals("Test if that Camcorder arraylist size is 1?", 1, camcorderList.size());

		// The item just added is as same as the first item of the list
		assertSame("Test that Camcorder is added same as 1st item of the list?", cc1, camcorderList.get(0));

		// Add another item. test The size of the list is 2?
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test that Camcorder arraylist size is 2?", 2, camcorderList.size());
	}

	@Test
	public void testAddChromebook() {
		// fail("Not yet implemented");
		// write your code here
		// Aw jie did this
		assertNotNull("Test if there is valid Chromebook arraylist to add to", chromebookList);

		ResourceCentre.addChromebook(chromebookList, cb1);
		assertEquals("Test if that Chromebook arraylist size is 1?", 1, chromebookList.size());

		assertSame("Test that Chromebook is added same as 1st item of the list?", cb1, chromebookList.get(0));

		ResourceCentre.addChromebook(chromebookList, cb2);

		assertEquals("Test that Chromebook arraylist size is 2?", 2, chromebookList.size());
	}

	@Test
	public void testRetrieveAllCamcorder() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);

		// test if the list of camcorders retrieved from the SourceCentre is empty
		String allCamcorder = ResourceCentre.retrieveAllCamcorder(camcorderList);
		String testOutput = "";
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		ResourceCentre.addCamcorder(camcorderList, cc1);
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, camcorderList.size());

		// test if the expected output string same as the list of camcorders retrieved
		// from the SourceCentre
		allCamcorder = ResourceCentre.retrieveAllCamcorder(camcorderList);

		testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n", "CC0011", "Nikon HDSLR", "Yes", "", 40);
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n", "CC0012", "Sony DSC-RX100M7", "Yes", "", 20);

		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);

	}

	@Test
	public void testRetrieveAllChromebook() {
		// fail("Not yet implemented");
		// write your code here
		// by Xiaoyu
		
		// Test if Item list is not null but empty, so that can add a new item
				assertNotNull("Test if there is valid Chromebook arraylist to add to", chromebookList);
				
				//Test Case 1
				//Test if the list of chromebook retrieved from the SourceCentre is empty
						String allChromebook= ResourceCentre.retrieveAllChromebook(chromebookList);
						String testOutput = "";
						assertEquals("Check that ViewAllCamcorderlist", testOutput, allChromebook);
						
				//Test Case 2
				//Test if after adding 1 item,  the size of the list will become 1
						ResourceCentre.addChromebook(chromebookList, cb1);
						assertEquals("Test if that Chromebook arraylist size is 1?", 1, chromebookList.size());
						
				//Test Case 3
				//Test if after adding 2 item,  the size of the list will become 2
						ResourceCentre.addChromebook(chromebookList, cb1);
						ResourceCentre.addChromebook(chromebookList, cb2);
						assertEquals("Test if that Chromebook arraylist size is 2?", 2, chromebookList.size());
				
				//test if the expected output string same as the list of chromebook retrieved from the SourceCentre
				allChromebook = ResourceCentre.retrieveAllChromebook(chromebookList);

				testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n", "CB0011", "My Google Chromebook 1st", "Mac OS",
						"", 40);
				testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n", "CB0012", "SAMSUNG Chromebook 4+", "Win 10", "",
						20);
		
				assertEquals("Check that ViewAllChromebooklist", testOutput, allChromebook);

	}

	@Test
	public void testDoLoanCamcorder() {
		// yati
		
		String tag1="CC0011";
		String date="29-9-2021";

		camcorderList.clear();

		//Test Case 1: tag is not inside the list -error
		boolean result1= ResourceCentre.doLoanCamcorder(camcorderList,tag1 , date);
		assertFalse("There is no item to loan",result1);
		
		//Test case 2: normal 
		ResourceCentre.addCamcorder(camcorderList, cc1);

		boolean result2= ResourceCentre.doLoanCamcorder(camcorderList,tag1 , date);
		assertEquals("Test if cc1 is loaned", result2,true);
		
		//Test case 3: double loan
		boolean result3= ResourceCentre.doLoanCamcorder(camcorderList,tag1 , date);
		assertEquals("Test if cc1 is already loaned", result3,false);
		
		//Test case 4: check due date and availability
		assertEquals("Due Date checked",cc1.getDueDate(),date);
		assertFalse("Availability checked",cc1.getIsAvailable());

		// Test case 4: check due date and availability
		assertEquals("Due Date checked", cc1.getDueDate(), date);
		assertFalse("Availability checked", cc1.getIsAvailable());

	}

	@Test
	public void testDoLoanChromebook() {
		// fail("Not yet implemented");
		// write your code here
		// TEST THAT ITEM IS AVAILABLE?

		boolean resultcb = ResourceCentre.doLoanChromebook(chromebookList, cb1.getAssetTag(), cb1.getDueDate());
		assertEquals("Test if method for first cb result is false", resultcb, true);

		boolean resultcb2 = ResourceCentre.doLoanChromebook(chromebookList, cb2.getAssetTag(), cb2.getDueDate());
		assertEquals("Test if method for second cb result is true", resultcb2, true);

	}

	@Test
	public void testDoReturnCamcorder() {
		// fail("Not yet implemented");
		// write your code here
		// WeiZhe
		
		String tag1="CC0011";
<<<<<<< HEAD

=======
		
>>>>>>> branch 'master' of https://github.com/Yati2/C206_ResourceCentre_Team2.git
		//Test case 1: if the asset tag is not in the arrayList -error
		camcorderList.clear();
		boolean result1= ResourceCentre.doReturnCamcorder(camcorderList,tag1);
		assertFalse("There is no matched tag inside the arrayList",result1);
		
		//Test case 2: normal condition
		ResourceCentre.addCamcorder(camcorderList, cc1);
		cc1.setIsAvailable(false);
		boolean result2= ResourceCentre.doReturnCamcorder(camcorderList,tag1);
		assertTrue("The item has returned",result2);
		
		//Test case 3: return the available item - error
		boolean result3= ResourceCentre.doReturnCamcorder(camcorderList,tag1);
		assertFalse("U cannot return unloaned item",result3);
		
		//Test case 4: check the status of the item after return
		assertEquals("The status is updated",true, cc1.getIsAvailable());

	}

	@Test
	public void testDoReturnChromebook() {
		// fail("Not yet implemented");
		// write your code here
		String tag1 = "CB0011";
		
		//Test case 1: if the asset tag is not in the arrayList -error
		chromebookList.clear();
		boolean result1= ResourceCentre.doReturnChromebook(chromebookList,tag1);
		assertFalse("There is no matched tag inside the arrayList",result1);
		
		//Test case 2: normal condition
		ResourceCentre.addChromebook(chromebookList, cb1);
		cb1.setIsAvailable(false);
		boolean result2= ResourceCentre.doReturnChromebook(chromebookList,tag1);
		assertTrue("The item has returned",result2);
		
		//Test case 3: return the available item - error
		boolean result3= ResourceCentre.doReturnChromebook(chromebookList,tag1);
		assertFalse("U cannot return unloaned item",result3);
		
		//Test case 4: check the status of the item after return
		
		assertEquals("The status is updated",true, cb1.getIsAvailable());
	}

	@After
	public void tearDown() throws Exception {
		cc1 = null;
		cc2 = null;
		cb1 = null;
		cb2 = null;
		camcorderList = null;
		chromebookList = null;

	}

}
