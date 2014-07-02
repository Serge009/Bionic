package app9;

import java.time.LocalDate;
import java.util.ArrayList;


public class DepoList {
	private ArrayList<DepoBase> list = new ArrayList<>();
	
	public DepoList() {
		init();
	}

	private void init(){
		list.add(new Deposit(2500, 61, 18, LocalDate.of(2013, 9, 8)));
		list.add(new SimpleDepo(10_000, 181, 21, LocalDate.of(2012, 2, 8)));
		list.add(new Deposit(5500, 30, 15.3, LocalDate.of(2013, 11, 12)));
		list.add(new BarrierDepo(43_000, 370, 19.56, LocalDate.of(2011, 12, 18)));
		list.add(new SimpleDepo(12_000, 91, 16, LocalDate.of(2013, 7, 12)));
	}
	
	public double getPrincipal(){
		double res = 0;
		
		for(DepoBase d : list){
			res += d.getSum();
		}
		
		return res;
	}

}
