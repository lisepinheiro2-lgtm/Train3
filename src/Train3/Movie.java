package Train3;

public class Movie {
	private String title;
	private int duration;
	private double rating;

	public Movie(String title, int duration, double rating) {
		this.title = title;
		this.duration = duration;
		this.rating = rating;
	}

	public boolean isLong(int limit) {
		boolean check = false;
		if (duration > limit) {
			return check = true;
		} else {
			return check;
		}
	}
	public void addRatingBonus(double bonus) {
		int limit = 10;
		if (rating + bonus <= 10) {
			rating += bonus;
		}else if ((rating + bonus) > 10) {
			rating = limit;
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

}
