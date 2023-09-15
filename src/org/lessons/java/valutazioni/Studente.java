package org.lessons.java.valutazioni;

public class Studente {
	public int id;
	public int absencePercentage;
	public float avg;
	
	boolean success() {
		if (this.absencePercentage > 50) return false;
		if (this.absencePercentage >= 25 && this.avg > 2) return true;
		if (this.absencePercentage < 25 && this.avg >= 2) return true;
		return false;
	}
}
