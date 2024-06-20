package Text2;
import java.util.Scanner;

import Text.Conta;

import java.util.Locale;
import java.util.InputMismatchException;

public class Contatestar {
    private static final int SENHA_CORRETA = 1503;
    private static final String NOME_CORRETO = "pedro";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.println("Bem-vindo, por favor digite sua senha e seu nome:");
        int senha = lerInteiro(sc, "Senha: ");
        String nome = sc.next();

        while (senha != SENHA_CORRETA || !nome.equalsIgnoreCase(NOME_CORRETO)) {
            System.out.println("Acesso negado, tente novamente.");
            senha = lerInteiro(sc, "Senha: ");
            nome = sc.next();
        }

        Conta conta = new Conta(nome, senha);
        conta.setSaldo(1200.0);

        System.out.println("Acesso liberado, bem-vindo " + conta.getNome() + "=)");

        int opcao;
        do {
            mostrarMenu();
            opcao = lerInteiro(sc, "Escolha uma opção: ");
            switch (opcao) {
                case 1:
                    System.out.println(conta);
                    break;
                case 2:
                    System.out.println("Digite o valor que você deseja sacar:");
                    double valorSaque = lerDouble(sc, "Valor do saque: ");
                    conta.sacar(valorSaque);
                    System.out.println("Saque realizado com sucesso");
                    System.out.println(conta);
                    break;
                case 3:
                    System.out.println("Digite o valor que você quer depositar:");
                    double valorDeposito = lerDouble(sc, "Valor do depósito: ");
                    conta.depositar(valorDeposito);
                    System.out.println("Depósito realizado com sucesso");
                    System.out.println(conta);
                    break;
                case 4:
                    System.out.println("Até mais :)");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 4);

        sc.close();
    }

    private static void mostrarMenu() {
        String menu = """
            1 - Ver saldo
            2 - Sacar
            3 - Depositar
            4 - Sair
        """;
        System.out.println(menu);
    }

    private static int lerInteiro(Scanner sc, String mensagem) {
        int valor = 0;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print(mensagem);
                valor = sc.nextInt();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                sc.next();
            }
        }
        return valor;
    }

    private static double lerDouble(Scanner sc, String mensagem) {
        double valor = 0;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print(mensagem);
                valor = sc.nextDouble();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número válido.");
                sc.next(); 
            }
        }
        return valor;
    }
}

