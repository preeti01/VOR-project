
package vor;


public class VOR {
	private Radio radio;

	private int required;

	public VOR() {
		this(new Radio(true));
	}

	public VOR(Radio radio) {
		this.radio = radio;
		required = 0;
	}

	public void registerRadioListener(RadioListener listener) {
		radio.addListener(listener);
	}

	public void rotateOBS(int delta) {
		required = Angle.normalizeAngle(required + delta);
	}


	public int getOBS() {
		return required;
	}


	public int getCDI() {
		int intercepted = radio.getRadial();
		int curve = Angle.curve(required, intercepted);
		if (curve > 90) {
			curve = 180 - curve;
		} else if (curve < -90) {
			curve = -180 - curve;
		}
		return Angle.clamp(curve, -10, 10);
	}


	public boolean isSignalGood() {
		int intercepted = radio.getRadial();
		int curve = Angle.curve(desired, intercepted);
		return (Math.abs(Math.abs(curve) - 90) > 1) && !radio.isOverStation();
	}


	public boolean isGoingTo() {
		int intercepted = radio.getRadial();
		return Math.abs(Angle.curve(desired, intercepted)) > 90;
	}


}
