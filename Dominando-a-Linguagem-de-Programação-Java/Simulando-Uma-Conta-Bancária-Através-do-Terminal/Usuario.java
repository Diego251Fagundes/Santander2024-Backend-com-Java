public class Usuario {
    private String nomeCliente;
    private int numero;
    private String agencia;
    private double saldo;

    public Usuario(String nomeCliente, int numero, String agencia, double saldo) {
        this.nomeCliente = nomeCliente;
        this.numero = numero;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}