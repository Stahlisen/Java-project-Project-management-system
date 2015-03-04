package project_frest460_danko234;

public class calculatecost {

	int salary2 = 1500;
	int salary1 = 1000;
	int overtimesalary1 = 1200;
	double bonus = 1.1;
	double totalsalary;
	public double countcost (int regularhours, String overtimehours, String projectid, int role, String members){
		
			
	
			if (role == 0 || role == 1) {
				
				int overtime = Integer.parseInt(overtimehours);
				
				int regularsalary = regularhours * salary1;
				int overtimesalary = overtime * overtimesalary1;
				totalsalary = regularsalary+overtimesalary;
				
				
			} else if (role == 2) {
				int membersinproject = Integer.parseInt(members);
				
				if (membersinproject > 3) {
					
					totalsalary = regularhours * salary2 * bonus;
					
					
				} else if (membersinproject <= 3) {
					
					totalsalary = regularhours * salary2;
					
				}
				
				
				
				
				
				
				
			}
			return totalsalary;
		
	}
	
	public int countHours(int reghours, String overtime, int role) {
		int totalhours = 0;
		if (role == 0 || role == 1) {
			
			int overhours = Integer.parseInt(overtime);
			totalhours = reghours+overhours;
			
		}
		
		else if (role == 2) {
			
			totalhours = reghours;
		}
		
		
		return totalhours;
		
		
		
	}
	
}

