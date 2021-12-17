import java.util.PriorityQueue;
import java.util.Queue;

public class CarQueue {

	Queue<Integer> q = new PriorityQueue();
	int i;
	
	public CarQueue() {
		q.add(1);
		q.add(3);
		q.add(2);
		q.add(0);
		q.add(1);
		q.add(2);
		q.add(0);
	}

	public int deleteQueue() {
		// TODO Auto-generated method stub
		class AniRun implements Runnable {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				if (q.isEmpty() == false)
					i = q.remove();
			}
		}
		Runnable rn = new AniRun();
		Thread t = new Thread(rn);
		t.start();
		return i;
	}
	
	

	public void addToQueue() {
		// TODO Auto-generated method stub
		class AniRun implements Runnable {

			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				q.add(3);
				q.add(2);
				q.add(0);
				q.add(1);
			}
		}
		Runnable rn = new AniRun();
		Thread t = new Thread(rn);
		t.start();
	}
}