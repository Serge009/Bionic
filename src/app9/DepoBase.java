package app9;

import java.time.LocalDate;
import java.util.Comparator;

public abstract class DepoBase implements Comparable<DepoBase> {
	
	protected double interest;
	
	protected double sum;
	
	protected int days;
	
	protected double interestRate;
	
	protected LocalDate startDate;
	
	protected LocalDate maturityDate;
	
	static class SortBySum implements Comparator<DepoBase>{

		@Override
		public int compare(DepoBase o1, DepoBase o2) {
			double int1 = o1.getSum();
			double int2 = o2.getSum();
			if(int1 == int2) return 0;
			if(int1 > int2) return 1;
			return -1;
		}
		
	}

	public DepoBase(double sum, int days, double interestRate, LocalDate startDate) {
		this.sum = sum;
		this.days = days;
		this.interestRate = interestRate;
		this.startDate = startDate;
	}
	
	@Override
	public int compareTo(DepoBase d){
		double int1 = this.calculateInterest();
		double int2 = d.calculateInterest();
		if(int1 == int2) return 0;
		if(int1 > int2) return 1;
		return -1;
	}
	
	public abstract double calculateInterest();
	
	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
}
