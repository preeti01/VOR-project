
package vor;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class Radio {

	private ArrayList<RadioListener> listeners;

	protected int radial;
	protected boolean overStation;

	public Radio() {
			}

	public Radio(boolean timed) {
		listeners = new ArrayList<>();
		reset();
		if (timed) {
			new Timer().scheduleAtFixedRate(new TimerTask() {


				public void run() {
					if (Angle.randomInt(0, 3) == 0) {
						radial = Angle.normalizeAngle(radial + Angle.randomInt(-2, 2));
					}

					notifyListeners();
				}
			}, 0, 1000);
		}
	}

	public void addListener(RadioListener listener) {
        listeners.add(listener);
    }



	private void notifyListeners() {
		for (RadioListener listener : listeners) {
        	listener.incomingData();
        }
	}



	public int getRadial() {
		return radial;
	}



	public boolean isOverStation() {
		return overStation;
	}
}
