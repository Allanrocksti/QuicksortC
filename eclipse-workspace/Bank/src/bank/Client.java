package bank;

/*
 * Classe do cliente
 * 
 * @author Allan Roque Barbosa da Silva - 1610013738
 */

public class Client {

	private String cpf;
	private String name;

	/*
	 * Metodos get-set, construtores e etc...
	 */
	@Override
	public String toString() {
		return "Client [cpf=" + cpf + ", name=" + name + "]";
	}

	public Client() {
		
	}
	
	public Client(String cpf, String name) {
		super();
		this.cpf = cpf;
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
