package javafx.application;

import javafx.scene.control.TextField;

public class Timers extends Thread{
	TextField tf;
	public Timers(TextField textField) {
		 tf = textField;
	}
	private boolean isCounting = true;
	public void stopCounting() {
		isCounting = false;
	}
	int count = 0;
	@Override
	public void run() {
		try {
			stopWatchUpdate(tf);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void stopWatchUpdate(TextField textField) throws InterruptedException {
		long startTime = System.currentTimeMillis();
		while(isCounting) {
			Thread.sleep(1000-(System.currentTimeMillis()-startTime));
			startTime = System.currentTimeMillis();
			count++;
			textField.setText((count/60) + ":" + (count%60));
		}
	}

}
