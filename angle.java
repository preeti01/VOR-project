
package vor;


public class Angle
{


	public static int normalizeAngle(int angle, int center) 
	{
		return angle - 360 * (int)Math.floor((angle + 180 - center) / 360.0);
	}


	public static int normalizeAngle(int angle)
	{
		return normalizeAngle(angle, 180);
	}


	public static int clamp(int val, int low, int high)
	{
		return Math.max(low, Math.min(high, val));
	}


	public static int curve(int x, int y) 
	{
		return normalizeAngle(y - x, 0);
	}


	public static int randomInt(int min, int max) 
	{
		return min + (int)(Math.random() * (max - min + 1));
	}
}
