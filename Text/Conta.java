package Text;

public class Conta {
    private int senha;
    private String nome;
    private double saldo;

    public Conta(String nome, int senha) {
        this.senha = senha;
        this.nome = nome;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public String toString() {
        return String.format("Seu saldo é de: %.2f", saldo);
    }
}
