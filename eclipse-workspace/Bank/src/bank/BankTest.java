package bank;

/*
 * Classe para realizar testes
 * 
 * @author Allan Roque Barbosa da Silva - 1610013738
 */

public class BankTest {

	public static void main(String[] args) {

		Bank bank = new Bank();
		
		Client client1 = new Client("1", "oi");
		Client client2 = new Client("2", "tim");
		Client client3 = new Client("3", "claro");
		
		Account c1 = new Account("1", client1);
		c1.credit(100);
		c1.debit(20);
		
		Account c2 = new Account("2", client1);
		c2.credit(300);
		c2.debit(120);
		
		Account c3 = new Account("3", client2);
		c3.credit(500);
		c3.debit(256);
		
		Account c4 = new Account("4", client2);
		c4.credit(666);
		c4.debit(616);
		
		Account c5 = new Account("5", client3);
		c5.credit(10);
		c5.debit(20);

		bank.insert(c1.getNumber(), c1);
		bank.insert(c2.getNumber(), c2);
		bank.insert(c3.getNumber(), c3);
		bank.insert(c4.getNumber(), c4);
		bank.insert(c5.getNumber(), c5);
		
		System.out.println("O saldo da conta 1 é de: R$ " + bank.searchAccount("1").getbalance());
		System.out.println("O saldo da conta 2 é de: R$ " + bank.searchAccount("2").getbalance());
		System.out.println("O saldo da conta 3 é de: R$ " + bank.searchAccount("3").getbalance());
		System.out.println("O saldo da conta 4 é de: R$ " + bank.searchAccount("4").getbalance());
		System.out.println("O saldo da conta 5 é de: R$ " + bank.searchAccount("5").getbalance());
		
		System.out.println("O cliente 1 é: " + bank.searchClient("1").getName());
		System.out.println("O cliente 2 é: " + bank.searchClient("2").getName());
		System.out.println("O cliente 3 é: " + bank.searchClient("3").getName());
		
		System.out.println(bank.searchAccountsOfClient("1"));
		System.out.println(bank.searchAccountsOfClient("2"));
		System.out.println(bank.searchAccountsOfClient("3"));
		
	}
	


	
}
