package pack;
import java.text.SimpleDateFormat;
import java.util.*;

public class Doc{
	
	private Integer id;
	private Integer specId;
	
	private String fio;
	private String bday;
	private String hiring;
	private Integer number;
	private Double payment;
	
	SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

	
	
	public void setPayment() {
		try {
			String now="16.11.2021";
			Date hiringDate = format.parse(hiring);
			Date nowDate=format.parse(now);
			long difference = nowDate.getTime() - hiringDate.getTime();
			
			int years=(int) (difference / (365.25 *24 * 60 * 60 * 1000));
			//System.out.println(hiringDate);
			//System.out.println(nowDate);
			//System.out.println(years);
			Spec spec=Storage.readByIdSpec(this.specId);
			int salary=spec.getSalary();
			//System.out.println(salary);
			if(years>=5 && years <10) {
				this.payment=spec.getSalary()*1.05;
			}else if(years>=10 && years<20) {
				this.payment=spec.getSalary()*1.1;
			}else if(years>=20 && years<35) {
				this.payment=spec.getSalary()*1.2;
			}else if(years>=35) {
				this.payment=spec.getSalary()*1.5;
			}else {
				this.payment=(double)spec.getSalary();
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Integer getSpecId() {
		return specId;
	}
	public void setSpecId(Integer specId) {
		this.specId = specId;
	}
	public String getFio() {
		return fio;
	}
	public void setFio(String fio) {
		this.fio = fio;
	}
	public String getBday() {
		return bday;
	}
	public void setBday(String bday) {
		this.bday = bday;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Double getPayment() {
		return payment;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	public void setPayment(Double payment) {
		this.payment = payment;
	}
	public String getHiring() {
		return hiring;
	}
	public void setHiring(String hiring) {
		this.hiring = hiring;
	}
}
