import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dijkstra_router.model.ComparatorDistance;
import dijkstra_router.model.Distance;
import dijkstra_router.model.GenericEdge;
import dijkstra_router.model.GenericNode;
import dijkstra_router.model.LinkedPriorityQueue;


public class LinkedPriorityQueueTest{

private static LinkedPriorityQueue queue;
    
    public LinkedPriorityQueueTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
	
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
	
	queue = new LinkedPriorityQueue(new ComparatorDistance());
	queue.add(new GenericEdge(new GenericNode("0:0"), new GenericNode("1:1"), new Distance(5)));
	queue.add(new GenericEdge(new GenericNode("1:1"), new GenericNode("2:2"), new Distance(3)));
	queue.add(new GenericEdge(new GenericNode("2:2"), new GenericNode("3:3"), new Distance(1)));
	queue.add(new GenericEdge(new GenericNode("3:3"), new GenericNode("4:4"), new Distance(4)));
	queue.add(new GenericEdge(new GenericNode("4:4"), new GenericNode("5:5"), new Distance(2)));
        queue.add(new GenericEdge(new GenericNode("11:11"), new GenericNode("11:11"), new Distance(1)));
	
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of push method, of class PriorityQueue.
     */
    @Test
    public void testPush() {
	
	queue.add(new GenericEdge(new GenericNode("5:5"), new GenericNode("6:6"), new Distance(0)));
	assertTrue(queue.remove().toString().equals("5:5 - 6:6"));
	queue.add(new GenericEdge(new GenericNode("6:6"), new GenericNode("7:7"), new Distance(6)));
	assertTrue(queue.remove().toString().equals("2:2 - 3:3"));
	queue.add(new GenericEdge(new GenericNode("5:5"), new GenericNode("6:6"), new Distance(2)));
	assertTrue(queue.remove().toString().equals("4:4 - 5:5"));
	
	setUp();
	
	queue.add(new GenericEdge(new GenericNode("6:6"), new GenericNode("7:7"), new Distance(5)));
	queue.remove();
	queue.remove();
	queue.remove();
	queue.remove();
	assertTrue(queue.remove().toString().equals("0:0 - 1:1"));
	assertTrue(queue.remove().toString().equals("6:6 - 7:7"));
    }

    /**
     * Test of pop method, of class PriorityQueue.
     */
    @Test
    public void testPop() {
	
    System.out.println(queue.toString());
	assertTrue(queue.remove().toString().equals("2:2 - 3:3"));
	assertTrue(queue.remove().toString().equals("4:4 - 5:5"));
	assertTrue(queue.remove().toString().equals("1:1 - 2:2"));
	assertTrue(queue.remove().toString().equals("3:3 - 4:4"));
	assertTrue(queue.remove().toString().equals("0:0 - 1:1"));
	
    }

    /**
     * Test of peek method, of class PriorityQueue.
     */
    @Test
    public void testPeek() {
	
	assertTrue(queue.peek().toString().equals("2:2 - 3:3"));
	assertTrue(queue.peek().toString().equals("2:2 - 3:3"));
	assertTrue(queue.peek().toString().equals("2:2 - 3:3"));
	assertTrue(queue.peek().toString().equals("2:2 - 3:3"));
	assertTrue(queue.peek().toString().equals("2:2 - 3:3"));
    }

    
    @Test
    public void testSize(){
	
	assert(queue.size() == 5);
	queue.remove();
	assert(queue.size() == 4);
	queue.add(new GenericEdge(new GenericNode("0:0"), new GenericNode("1:1"), new Distance(5)));	
	assert(queue.size() == 5);
	
    }

}
