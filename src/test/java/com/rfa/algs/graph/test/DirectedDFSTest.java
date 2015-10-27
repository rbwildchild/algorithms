package com.rfa.algs.graph.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.rfa.algs.graph.Graph;
import com.rfa.algs.graph.directed.SimpleDigraph;
import com.rfa.algs.graph.path.BreadthFirstPaths;
import com.rfa.algs.graph.path.Paths;
import com.rfa.algs.graph.search.DepthFirstSearch;
import com.rfa.algs.graph.search.Search;

public class DirectedDFSTest {
	Graph graph = new SimpleDigraph(5);
	
	@Before
	public void setup(){
		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.addEdge(4, 0);
	}
	
	@Test
	public void markedDFSTest(){
		Search search = new DepthFirstSearch(graph, 1);
		assertTrue(search.marked(2));
		assertFalse(search.marked(4));
	}
	
	@Test
	public void path2ThreeTest(){
		Paths paths = new BreadthFirstPaths(graph, 0);
		assertTrue(paths.hasPathTo(3));
		Integer[] path = Lists.newArrayList(paths.pathTo(3)).toArray(new Integer[1]);
		assertEquals(new Integer(0), new Integer(path[0]));
		assertEquals(new Integer(3), new Integer(path[1]));
	}
	
	@Test
	public void path2TwoTest(){
		Paths paths = new BreadthFirstPaths(graph, 0);
		assertTrue(paths.hasPathTo(2));
		Integer[] path = Lists.newArrayList(paths.pathTo(2)).toArray(new Integer[1]);
		assertEquals(new Integer(0), new Integer(path[0]));
		assertEquals(new Integer(1), new Integer(path[1]));
		assertEquals(new Integer(2), new Integer(path[2]));
	}
	
	@Test
	public void path2FourTest(){
		Paths paths = new BreadthFirstPaths(graph, 0);
		assertFalse(paths.hasPathTo(4));
	}
}
