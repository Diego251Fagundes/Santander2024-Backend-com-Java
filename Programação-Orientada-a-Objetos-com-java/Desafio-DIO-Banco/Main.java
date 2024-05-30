public class Main {
    public static void main(String[] args) {
        Cliente diego = new Cliente();
        diego.setNome("Diego");
        diego.setCpf("123456789-31");

        Conta cc = new ContaCorrente(diego);
        Conta cp = new ContaPoupanca(diego);

        cc.depositar(10000);
        cc.transferir(9000, cp);

        cc.imprimirExtrato();
        cp.imprimirExtrato();
    }
}