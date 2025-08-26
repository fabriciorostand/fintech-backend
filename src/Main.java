import br.com.fiap.fintech.model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        User user = new User();
        BankAccount bankAccount = new BankAccount();

        int menuOption;

        do {
            System.out.println("\nEscolha uma opção:\n1 - Cadastrar usuário\n2 - Fazer login\n3 - Adicionar conta bancária\n4 - Exibir informações da Conta Bancária\n0 - Sair");
            menuOption = scanner.nextInt();

            switch (menuOption) {
                case 1:
                    System.out.println("Nome:");
                    user.name = scanner.next() + scanner.nextLine();
                    System.out.println("E-mail:");
                    user.email = scanner.nextLine();
                    System.out.println("Senha:");
                    user.password = scanner.nextLine();
                    break;
                case 2:
                    System.out.println("\nE-mail: ");
                    String email = scanner.next() + scanner.nextLine();
                    System.out.println("Senha: ");
                    String password = scanner.nextLine();

                    Login login = new Login(user);
                    login.doLogin(email, password);
                    break;
                case 3:
                    System.out.println("\nNome do banco: ");
                    String bankName = scanner.next() + scanner.nextLine();
                    System.out.println("Número do banco:");
                    int bankNumber = scanner.nextInt();
                    Bank bank = new Bank(bankName, bankNumber);

                    System.out.println("Número da agência:");
                    int branchNumber = scanner.nextInt();
                    Branch branch = new Branch(bank, branchNumber);

                    System.out.println("Número da conta bancária:");
                    int bankAccountNumber = scanner.nextInt();
                    bankAccount = new BankAccount(user, branch, bankAccountNumber);
                    break;
                case 4:
                    bankAccount.displayBankAccount();
                    break;
                case 0:
                    System.out.println("\nFinalizando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (menuOption != 0);
    }
}