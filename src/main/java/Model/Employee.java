/**
 * 
 */
package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author tanbirul.hashan
 *
 */
@Data
@AllArgsConstructor
@ToString
public class Employee {
	
	private int eID;
	private String eName;
	private int eSalary;
	private String eAdress;
	
	public Employee(String eName,int eSalary,String eAddress){
		this.eName=eName;
		this.eSalary=eSalary;
		this.eAdress=eAddress;
	}
}
