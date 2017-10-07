package bank;

import java.util.Date;

/*
 * Classe dos lançamentos
 * 
 * @author Allan Roque Barbosa da Silva - 1610013738
 */
public class Launch {

	Date date;
	float value;
	
	/*
	 * Metodos get-set, construtores e etc...
	 */
	@Override
	public String toString() {
		return "Launch [date=" + date + ", value=" + value + "]";
	}

	public Launch(Date date, float value) {
		super();
		this.date = date;
		this.value = value;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

}
