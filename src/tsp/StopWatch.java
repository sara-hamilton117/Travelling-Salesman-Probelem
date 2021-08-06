package tsp;

public class StopWatch {

	//Creating time variable
	long startTime;
	
	//Creating methods to be called in Main
	public void start() {
		startTime = System.nanoTime();
	}
	
	public double stop() {
		long endTime = System.nanoTime();
		
		//Calculating total duration
		long duration = endTime - startTime;
		return duration;
	}
}
