package bank;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/*
 * Classe Que implementa funções de pesquisa de contas no banco
 * 
 * @author Allan Roque Barbosa da Silva - 1610013738
 */

public class Bank {

	TreeMap<String, Account> accounts;

	/*
	 * Função que insere uma conta no TreeMap
	 */
	public void insert(String n, Account a) {		
		accounts.put(n, a);
	}
	
	/*
	 * Realiza a consulta de uma conta a partir do numero da conta
	 * 
	 * @param number Numero da conta
	 * 
	 * @return A conta ou null se não existir
	 */
	public Account searchAccount(String number) {
		return accounts.get(number);
	}
	
	/*
	 * Realiza a consulta de um cliente a partir do cpf
	 * 
	 * @param cpf Cadastro da pessoa fisica da conta
	 * 
	 * @return O cliente ou null se não existir
	 */
	public Client searchClient(String cpf) {
		
		Client client = null;
		
		for(Map.Entry<String, Account> entry : accounts.entrySet()) {
			if(entry.getValue().getClient().getCpf() == cpf) {
				client = entry.getValue().getClient();
			}
		}
		
		return client;
	
	}
	
	/*
	 * Realiza a consulta de quantas contas um só cliente tem
	 * 
	 * @param cpf Cadastro da pessoa fisica da conta
	 * 
	 * @return Arraylist com todas as contas de um cliente
	 */
	public ArrayList<Account> searchAccountsOfClient(String cpf) {
		
		ArrayList<Account> allAccounts = new ArrayList<Account>();
		
		for(Map.Entry<String, Account> entry : accounts.entrySet()) {
			if(entry.getValue().getClient().getCpf() == cpf) {
				allAccounts.add(entry.getValue());
			}
		}
		
		return allAccounts;
		
	}
	
	/*
	 * Metodos get-set, construtores e etc...
	 */
	public Bank() {
		super();
		accounts = new TreeMap<String, Account>();
	}
	
}
