package time;

public class TimeOfDay {
	private int hours;
	private int minutes;
	private int seconds;
	
	TimeOfDay(int hours, int minutes, int seconds){
			this.hours = hours;
			this.minutes = minutes;
			this.seconds = seconds;
	}

	TimeOfDay addSeconds(int seconds) {
		int newSeconds = this.seconds + seconds;
		int newMinutes = this.minutes;
		int newHours = this.hours;
		
		if (newSeconds >= 60) {
			int minutesToAdd = newSeconds / 60;
			newSeconds = newSeconds % 60;
			newMinutes += minutesToAdd;
			
			if (newMinutes >= 60) {
				int hoursToAdd = newMinutes / 60;
				newMinutes = newMinutes % 60;
				newHours += hoursToAdd;
				
				if (newHours >= 24) {
					//a new day starts
					newSeconds = 0;
					newMinutes = 0;
					newHours = 0;
				}
			}
		}
		
		return new TimeOfDay(newHours, newMinutes, newSeconds);
	}
	
	int secondsFrom(TimeOfDay other) {
		int hourDiff = Math.abs(this.hours - other.getHours());
		int minDiff = Math.abs(this.minutes - other.getMinutes());
		int secDiff = Math.abs(this.seconds - other.getSeconds());
		
		return hourDiff * 60 * 60 + minDiff * 60 + secDiff;
	}
	
	public int getHours() {
		return hours;
	}
	public int getMinutes() {
		return minutes;
	}
	public int getSeconds() {
		return seconds;
	}
}
