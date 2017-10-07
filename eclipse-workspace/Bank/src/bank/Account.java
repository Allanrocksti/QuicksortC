package bank;

import java.util.ArrayList;
import java.util.Date;

/*
 * Classe Que implementa funções de da conta
 * 
 * @author Allan Roque Barbosa da Silva - 1610013738
 */

public class Account{

	private String number;
	private Client client;
	private ArrayList<Launch> releases;

	/*
	 * Função que insere um lançamento de credito
	 * 
	 * @param value Valor a ser creditado
	 */
	public void credit(float value) {
		releases.add(new Launch(new Date(), value));
	}
	
	/*
	 * Função que insere um lançamento de debito
	 * 
	 * @param value Valor a ser debitado
	 */
	public void debit(float value) {
		releases.add(new Launch(new Date(), value*-1));
	}
	
	/*
	 * Função que retorna o calculo de todos os lançamentos
	 * 
	 * @return Saldo da conta
	 */
	public float getbalance() {
		
		float balance = 0;
		
		for (Launch launch : releases) {
			balance += launch.getValue();
		}
		
		return balance;
		
	}

	/*
	 * Metodos get-set, construtores e etc...
	 */
	@Override
	public String toString() {
		return "Account [number=" + number + ", releases=" + releases + "]";
	}
	
	public Account() {
		super();
	}
	
	public Account(String number, Client client) {
		super();
		this.number = number;
		this.client = client;
		this.releases = new ArrayList<Launch>();
	}
	
	public Account(String number) {
		super();
		this.number = number;
		this.releases = new ArrayList<Launch>();
	}
	
	public Account(String number, ArrayList<Launch> releases) {
		super();
		this.number = number;
		this.releases = releases;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
