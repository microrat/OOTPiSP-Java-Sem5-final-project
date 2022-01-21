package pack;
import java.sql.SQLException;
import java.util.*;

public class Spec {
	private Integer id;
	private String name;
	private String uzk;
	private Integer amount;
	private Integer salary;	
	private Double costs;
	
	public void setCosts() throws SQLException {
		Collection<Doc> docList = (Collection<Doc>) Storage.readByIdDoc(this.id);
		this.costs =(double) 0;
		for (Doc doctor :docList) {
			
			doctor.setPayment();
			this.costs +=(double) doctor.getPayment();
		}
		
	}

	public double getCosts() throws SQLException {
		setCosts();
		return costs;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUzk() {
		return uzk;
	}
	public void setUzk(String uzk) {
		this.uzk = uzk;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
