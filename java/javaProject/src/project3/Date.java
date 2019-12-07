package project3;

public class Date {

	int days;
	int months;
	int years;

	public void setDays(int days) {
		this.days = days;
	}

	public int getDays() {
		return days;
	}

	public void setMonths(int months) {
		this.months = months;
	}

	public int getMonths() {
		return months;
	}

	public void setYears(int years) {
		this.years = years;
	}

	public int getYears() {
		return years;
	}

	public static void main(String[] args) {
		Date d = new Date();
		d.setDays(01);
		d.setMonths(05);
		d.setYears(2000);
		int days = d.getDays();
		int months = d.getMonths();
		int years = d.getYears();
		System.out.print(days+"/");
		System.out.print(months+"/");
		System.out.print(years);

	}

}