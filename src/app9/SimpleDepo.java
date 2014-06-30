package app9;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
//import java.time.temporal.ChronoUnit;

public class SimpleDepo extends DepoBase implements InterestSum  {

	public SimpleDepo(double sum, int days, double interestRate,
			LocalDate startDate) {
		super(sum, days, interestRate, startDate);
	}

	@Override
	public double calculateInterest() {
		this.maturityDate = startDate.plusDays(days); 
		this.getFullMonths();
		return this.getInterest();
				
	}
	
	private void getFullMonths(){
		if(startDate.getMonth() == maturityDate.getMonth()){
			this.simpleCalculation();
		} else {
			//taking first date of next month after start date
			LocalDate tmp1 = startDate.plusMonths(1);
			LocalDate date1 = LocalDate.of(tmp1.getYear(), tmp1.getMonth(), 1);
			
			//taking startDate month length 
			int daysInStartPeriod = startDate.getMonth().length(startDate.isLeapYear());
			
			//taking first date of maturityDate month
			LocalDate date2 = maturityDate.minusDays(maturityDate.getDayOfMonth());
			
			//taking maturityDate month length 
			long daysInEndPeriod = maturityDate.getMonth().length(maturityDate.isLeapYear());
			
			//count of full months between startDate and maturityDate
			long monthsBetween = ChronoUnit.MONTHS.between(date1, date2);
			//need correction if difference is more than 0
			monthsBetween = (monthsBetween == 0) ? 0 : monthsBetween+1;
			
			//days count in start month
			long days1 = daysInStartPeriod - startDate.getDayOfMonth();
			
			//days count in maturity month
			long days2 = maturityDate.getDayOfMonth();
			
			
			this.monthsCalculation(days1, days2, monthsBetween, daysInStartPeriod, daysInEndPeriod);
			
		}
		
	}
	
	private void monthsCalculation(long startDays, long endDays, long monthsBetween, double daysInStartPeriod, double daysInEndPeriod){
		LocalDate tmp = this.startDate;
		
		double startSum = this.sum;
		double daysInYear1 = this.startDate.isLeapYear() ? 366 : 365;
		double daysInYear2 = this.maturityDate.isLeapYear() ? 366 : 365;
		double daysInYear;
		
		//calculating for start month
		this.sum += this.sum * (this.interestRate) * (startDays/daysInYear1) / 100.0;
		
		//calculating for each month between startDate and maturityDate
		for(int i = 0; i < monthsBetween; i++){
			tmp = tmp.plusMonths(1);
			daysInYear = tmp.isLeapYear() ? 366 : 365;
			this.sum += this.sum * this.interestRate * tmp.getMonth().length(tmp.isLeapYear()) / 100.0 / daysInYear;
		}
		
		//calculating for maturity month
		this.sum += this.sum * (this.interestRate ) * (endDays/daysInYear2) / 100.0;
		this.interest += this.sum - startSum;
	}
	
	private void simpleCalculation(){
		double daysInYear1 = this.startDate.isLeapYear() ? 366 : 365;
		double daysInYear2 = this.maturityDate.isLeapYear() ? 366 : 365;
		double period1;
		double period2;
		
		
		if(startDate.getYear() == maturityDate.getYear()){
			this.interest = this.sum * (this.interestRate / 100.0) * (this.days / daysInYear1);
		} else {
			period1 = ChronoUnit.DAYS.between(this.startDate, LocalDate.of(startDate.getYear(), 12, 31));
			period2 = ChronoUnit.DAYS.between(LocalDate.of(this.maturityDate.getYear(), 1, 1), this.maturityDate) + 1;
			
			this.interest = this.sum * (this.interestRate / 100.0) * (period1 / daysInYear1 + period2 / daysInYear2);
			
		}
	}

}
