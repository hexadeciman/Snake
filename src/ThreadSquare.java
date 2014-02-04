public class ThreadSquare extends Thread {
    private final Object GUI_INITIALIZATION_MONITOR = new Object();
    private boolean pauseThreadFlag = false;

	DataOfSquare square ;
	ThreadSquare(DataOfSquare c) {
		this.square= c;
	}

	public void run() {
		while(true) {
		 	synchronized (GUI_INITIALIZATION_MONITOR) {
	            while (pauseThreadFlag) {
	                try {
	                    GUI_INITIALIZATION_MONITOR.wait();
	                } catch (Exception e) {}
	            }
	        }
		 	this.square.lightMeUp(0);
		 	pauseThread();	
		}
	}
	public void pauseThread() {
        pauseThreadFlag = true;
    }
	public void resumeThread() {
        synchronized(GUI_INITIALIZATION_MONITOR) {
            pauseThreadFlag = false;
            GUI_INITIALIZATION_MONITOR.notify();
        }
    }
	
} 
