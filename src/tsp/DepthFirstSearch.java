package tsp;

import java.util.ArrayList;
import java.util.Stack;

public class DepthFirstSearch {

	//Initializing arraylist of cities and a path of cities
	ArrayList<City> city;
	ArrayList<Stack<Integer>> alOfPaths = new ArrayList<Stack<Integer>>();
	
	//Creating stack to push cities number into
	Stack<Integer> cityStk = new Stack<Integer>();
	
	//Creating variables
	Double shortestDistance = Double.MAX_VALUE;
	int shortestIndex = -1;
	
	//Constructor
	public DepthFirstSearch(ArrayList<City> city) {
		this.city = city;
	}
	
	//Function to add all cities to stack
	public void depthFS() {
				
		//Pushing first city from list
		cityStk.push(city.get(0).getCityNumber());
		
		//Calling recursion and distance function
		depthRecursion();
		distance();
	}
	
	//Recursion function to add city to path
	public void depthRecursion() {
		
		//Variable to check if path is complete
		boolean isPathComplete = true;
		
		//Loop each city
		for (int i=0; i<city.size() ;i++) {
			
			//Checks if city is not in stack
			if(!cityStk.contains(city.get(i).getCityNumber())) {
				isPathComplete = false;
				
				//Push city
				cityStk.push(city.get(i).getCityNumber());
				
				//Calling recursive function on itself
				depthRecursion();
				
				//When recursion ends, pop top of path
				cityStk.pop();
			}
		}
		
		//If path is complete push it to arraylist of paths
		if (isPathComplete) {
			
			//Cloning path of cities, Casting may not be the best solution however
			Stack<Integer> copyPathStk = (Stack<Integer>) cityStk.clone();
			
			//Pushing cities into clone of path stack
			copyPathStk.push(city.get(0).getCityNumber());
			alOfPaths.add(copyPathStk);
		}
	}
	
	//Function to calculate distance between each 2 cities
	public void distance() {
		
		//Creating variables
		Double distance;
		
		//Loop through each path in arraylist
		for (int i=0; i<alOfPaths.size(); i++) {
			//Loop through each city and next city in path
			distance = 0.0;
			for (int j=0; j<alOfPaths.get(i).size() - 1; j++) {
				//Calculate distance
				distance += Math.sqrt(Math.pow((city.get(alOfPaths.get(i).get(j) - 1).getxPos() - city.get(alOfPaths.get(i).get(j + 1) - 1).getxPos()), 2)
						+ Math.pow((city.get(alOfPaths.get(i).get(j) - 1).getyPos() - city.get(alOfPaths.get(i).get(j + 1) - 1).getyPos()), 2));
			}
			
			//Loop to find the shortest distance
			if(distance < shortestDistance) {
				shortestDistance = distance;
				shortestIndex = i;
			}
		}
		
		//Calling function
		printDFSPath();
	}
	
	public void printDFSPath() {
		//Printing the full path on the shortest path index
		System.out.print("The shortest path for DFS is: ");
		for(int i=0; i < alOfPaths.get(shortestIndex).size() - 1; i++) {
			System.out.print(alOfPaths.get(shortestIndex).get(i) + " > ");
		}
		
		//Printing first city at the end of path and distance of path
		System.out.println("1.");
		System.out.println("The distance is: " + shortestDistance);
	}
}
