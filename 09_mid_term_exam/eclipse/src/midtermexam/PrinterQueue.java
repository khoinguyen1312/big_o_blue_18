package midtermexam;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class PrinterQueue {
	public static void main(String[] args) {
    	Scanner argumentScanner = new Scanner(System.in);

    	int numberOfProblem = argumentScanner.nextInt(); 
    	
    	for (int i = 0; i < numberOfProblem; i++) {
    		int numberOfJobs = argumentScanner.nextInt();
    		int yourNumberPosition = argumentScanner.nextInt();
    		
    		List<Integer> jobPriorities = new ArrayList<>();
    		
    		for (int j = 0; j < numberOfJobs; j++) {
    			jobPriorities.add(argumentScanner.nextInt());
    		}
    		
    		System.out.println(findYourPosition(jobPriorities, yourNumberPosition));
    	}
    	
    	argumentScanner.close();
		
	}


	public static int findYourPosition(List<Integer> job, Integer positionOfYourJob) {
		Queue<Num> jobQueue = new LinkedList<>();
		
		for (int i = 0; i < job.size(); i++) {
			jobQueue.add(new Num(job.get(i), i));
		}
		
		Num myNumber = new Num(job.get(positionOfYourJob), positionOfYourJob);
		
		int counter = 0;
		Num max = max(jobQueue);
		
		Num nextNum = jobQueue.poll();
		
		while (!jobQueue.isEmpty()) {
			
			if (nextNum.getPosition() == myNumber.getPosition() && max.getPriority() == myNumber.getPriority()) {
				break;
			}
			
			if (nextNum.getPriority() < max.getPriority()) {
				jobQueue.add(nextNum);
			} else {
				counter++;
			}

			max = max(jobQueue);
			nextNum = jobQueue.poll();
		}
		
		return counter + 1;
	}
	
	public static Num max(Queue<Num> jobQueue) {
		Object[] array = jobQueue.toArray();
		
		Object max = array[0];
		
		for (int i = 1; i < array.length; i++) {
			if (((Num) array[i]).getPriority() > ((Num) max).getPriority()) {
				max = array[i];
			}
		}
		
		return (Num) max;
	}
}


//public static int findYourPosition(List<Integer> jobs, Integer positionOfYourJob) {
//	Num myNumber = new Num(jobs.get(positionOfYourJob), positionOfYourJob);
//	
//	List<Num> jobQueue = new ArrayList<>();
//
//	for (int i = 0; i < jobs.size(); i++) {
//		jobQueue.add(new Num(jobs.get(i), i));
//	}
//
//	int counter = 0;
//	
//	List<Num> myNumberArray = new ArrayList<>();
//	
//	for (Num job : jobQueue) {
//		if (job.getPriority() > myNumber.getPriority()) {
//			counter++;
//		} else if (job.getPriority() == myNumber.getPriority()) {
//			myNumberArray.add(job);
//		}
//	}
//	
//	for (int i = 0; i < myNumberArray.size(); i++) {
//		if (myNumberArray.get(i).getPosition() == myNumber.getPosition()) {
//			counter = counter + i + 1;
//		}
//	}
//	
//	return counter;
//}

class Num {
	int priority;
	int position;
	
	Num(int priority, int position) {
		this.priority = priority;
		this.position = position;
	}
	
	public int getPosition() {
		return position;
	}
	
	public int getPriority() {
		return priority;
	}
}
