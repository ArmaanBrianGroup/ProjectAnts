package GUI;

public class Animator {

	public void start(Window w, double delay) {
		double last = 0;
		while (true) {
			double time = System.currentTimeMillis();
			if (last + delay <= time) {
				last = time;
				w.repaint();
			}
		}
	}
	
}
