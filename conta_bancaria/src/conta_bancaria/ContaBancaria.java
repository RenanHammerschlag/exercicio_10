package conta_bancaria;

public abstract class ContaBancaria {
	private String cliente;
	private int num_conta;
	private float saldo;
	
	public ContaBancaria(String cliente, int num_conta, float saldo) {
		this.cliente = cliente;
		this.num_conta = num_conta;
		this.saldo = saldo;
	}
	
	public String getCliente() {
		return cliente;
	}
	
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	public int getNum_conta() {
		return num_conta;
	}
	
	public void setNum_cliente(int num_conta) {
		this.num_conta = num_conta;
	}
	
	public float getSaldo() {
		return saldo;
	}
	
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	 public abstract void sacar(float valor);

	public void depositar(float valor) {
		saldo += valor;
	}
	 
	@Override
	public String toString() {
	    return "Cliente: " + cliente + ", Conta: " + num_conta + ", Saldo: " + saldo;
	}
}