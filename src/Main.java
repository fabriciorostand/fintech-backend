import br.com.fiap.fintech.model.*;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        User user = new User();
        BankAccount bankAccount = null;
        Transaction transaction = null;

        int menuOption;

        do {
            System.out.println("""
                    Escolha uma opção:
                    1 - Cadastrar usuário
                    2 - Fazer login
                    3 - Adicionar Conta Bancária
                    4 - Fazer um Lançamento
                    5 - Consultar saldo
                    6 - Exibir Extrato (Último Lançamento)
                    7 - Exibir informações do usuário
                    8 - Exibir informações da Conta Bancária
                    0 - Sair
                    """);

            menuOption = scanner.nextInt();

            switch (menuOption) {
                case 1:
                    System.out.println("\nNome:");
                    user.setName(scanner.next() + scanner.nextLine());
                    System.out.println("E-mail:");
                    user.setEmail(scanner.nextLine());
                    System.out.println("Senha:");
                    user.setPassword(scanner.nextLine());

                    System.out.println("\nCadastro feito com sucesso!\n");
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
                    if (!user.isLogged()) {
                        System.out.println("\nErro: Faça o login para fazer lançamentos.");
                    } else if (bankAccount == null) {
                        System.out.println("\nErro: Para fazer lançamentos primeiro cadastre uma Conta Bancária.\n");
                    } else {
                        transaction = new Transaction();
                        TransactionType transactionType = new TransactionType();
                        TransactionCategory category = new TransactionCategory();

                        System.out.println("\nTipo do Lançamento (Receita/Despesa): ");
                        transactionType.setName(scanner.next() + scanner.nextLine());

                        System.out.println("Categoria do Lançamento (Ex. Alimentação): ");
                        category.setName(scanner.nextLine());

                        System.out.println("Nome do Lançamento: ");
                        transaction.setName(scanner.nextLine());

                        System.out.println("Data (dd/mm/aaaa): ");
                        String dateStr = scanner.nextLine();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        transaction.setDate(LocalDate.parse(dateStr, formatter));

                        System.out.println("Valor: ");
                        transaction.setValue(scanner.nextDouble());

                        System.out.println("Descrição: ");
                        transaction.setDescription(scanner.next() + scanner.nextLine());

                        transaction.setType(transactionType);
                        transaction.setCategory(category);

                        bankAccount.makeTransaction(transaction);
                    }
                    break;
                case 5:
                    if (!user.isLogged()) {
                        System.out.println("\nErro: Faça o login para consultar o saldo.");
                    } else if (bankAccount == null) {
                        System.out.println("\nErro: Cadastre uma conta bancária para consultar o saldo.");
                    } else {
                        bankAccount.checkBalance();
                    }
                    break;
                case 6:
                    if (!user.isLogged()) {
                        System.out.println("\nErro: Usuário não está logado. Não é possível exibir lançamentos.");
                    } else if (transaction == null) {
                        System.out.println("\nNenhum lançamento feito ainda.\n");
                    } else {
                        bankAccount.displayLastTransaction(transaction);
                    }
                    break;
                case 7:
                    if (user.isLogged()) {
                        user.displayUser();
                    } else {
                        System.out.println("\nErro: Faça o login para exibir as informações de usuário.");
                    }
                    break;
                case 8:
                    if (!user.isLogged()) {
                        System.out.println("\nErro: Usuário não está logado. Não é possível exibir as informações de Conta Bancária.");
                    } else if (bankAccount == null) {
                        System.out.println("\nNenhuma Conta Bancária cadastrada.");
                    } else {
                        bankAccount.displayBankAccount();
                    }
                    break;
                case 0:
                    System.out.println("\nFinalizando o programa...");
                    break;
                default:
                    System.out.println("Erro: Opção inválida!");
            }
        } while (menuOption != 0);
    }
}