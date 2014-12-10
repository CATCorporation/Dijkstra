/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dijkstra_router.model.ComparatorDistance;
import dijkstra_router.model.Distance;
import dijkstra_router.model.Element;
import dijkstra_router.model.GenericEdge;
import dijkstra_router.model.GenericNode;
import dijkstra_router.model.PriorityQueue;

/**
 *
 * @author Suiken
 */
public class PriorityQueueTest {
    
    private static PriorityQueue queue;
    
    public PriorityQueueTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
	
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
	
	queue = new PriorityQueue(new ComparatorDistance());
	queue.push(new Element(new GenericEdge(new GenericNode("0:0"), new GenericNode("1:1"), new Distance(5))));
	queue.push(new Element(new GenericEdge(new GenericNode("1:1"), new GenericNode("2:2"), new Distance(3))));
	queue.push(new Element(new GenericEdge(new GenericNode("2:2"), new GenericNode("3:3"), new Distance(1))));
	queue.push(new Element(new GenericEdge(new GenericNode("3:3"), new GenericNode("4:4"), new Distance(4))));
	queue.push(new Element(new GenericEdge(new GenericNode("4:4"), new GenericNode("5:5"), new Distance(2))));
        //queue.push(new Element(new GenericEdge(new GenericNode("11:11"), new GenericNode("11:11"), new Distance(1))));
	
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of push method, of class PriorityQueue.
     */
    @Test
    public void testPush() {
	
	queue.push(new Element(new GenericEdge(new GenericNode("5:5"), new GenericNode("6:6"), new Distance(0))));
	assertTrue(queue.pop().getValue().toString().equals("5:5 - 6:6"));
	queue.push(new Element(new GenericEdge(new GenericNode("6:6"), new GenericNode("7:7"), new Distance(6))));
	assertTrue(queue.pop().getValue().toString().equals("2:2 - 3:3"));
	queue.push(new Element(new GenericEdge(new GenericNode("5:5"), new GenericNode("6:6"), new Distance(2))));
	assertTrue(queue.pop().getValue().toString().equals("4:4 - 5:5"));
	
	setUp();
	
	queue.push(new Element(new GenericEdge(new GenericNode("6:6"), new GenericNode("7:7"), new Distance(5))));
	queue.pop();
	queue.pop();
	queue.pop();
	queue.pop();
	assertTrue(queue.pop().getValue().toString().equals("0:0 - 1:1"));
	assertTrue(queue.pop().getValue().toString().equals("6:6 - 7:7"));
    }

    /**
     * Test of pop method, of class PriorityQueue.
     */
    @Test
    public void testPop() {
	
    System.out.println(queue.toString());
	assertTrue(queue.pop().getValue().toString().equals("2:2 - 3:3"));
	assertTrue(queue.pop().getValue().toString().equals("4:4 - 5:5"));
	assertTrue(queue.pop().getValue().toString().equals("1:1 - 2:2"));
	assertTrue(queue.pop().getValue().toString().equals("3:3 - 4:4"));
	assertTrue(queue.pop().getValue().toString().equals("0:0 - 1:1"));
	
    }

    /**
     * Test of toString method, of class PriorityQueue.
     */
    @Test
    public void testToString() {
	
	assertTrue(queue.toString().equals("2:2 - 3:3 4:4 - 5:5 1:1 - 2:2 3:3 - 4:4 0:0 - 1:1 "));
	
    }

    /**
     * Test of empty method, of class PriorityQueue.
     */
    @Test
    public void testEmpty() {
	
	assertTrue(!queue.empty());
	
	queue = new PriorityQueue(new ComparatorDistance());
	assertTrue(queue.empty());
	
    }

    /**
     * Test of peek method, of class PriorityQueue.
     */
    @Test
    public void testPeek() {
	
	assertTrue(queue.peek().getValue().toString().equals("2:2 - 3:3"));
	assertTrue(queue.peek().getValue().toString().equals("2:2 - 3:3"));
	assertTrue(queue.peek().getValue().toString().equals("2:2 - 3:3"));
	assertTrue(queue.peek().getValue().toString().equals("2:2 - 3:3"));
	assertTrue(queue.peek().getValue().toString().equals("2:2 - 3:3"));
    }

    /**
     * Test of search method, of class PriorityQueue.
     */
    @Test
    public void testSearch() {
	
	assert(queue.search("0:0 - 1:1") == 5);
	assert(queue.search("1:1 - 2:2") == 3);
	assert(queue.search("2:2 - 3:3") == 1);
	assert(queue.search("3:3 - 4:4") == 4);
	assert(queue.search("4:4 - 5:5") == 2);
	
    }
    
    @Test
    public void testSize(){
	
	assert(queue.size() == 5);
	queue.pop();
	assert(queue.size() == 4);
	queue.push(new Element(new GenericEdge(new GenericNode("0:0"), new GenericNode("1:1"), new Distance(5))));	
	assert(queue.size() == 5);
	
    }
    
}
