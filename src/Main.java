import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user = new User();

        int menuOption;

        do {
            System.out.println("\nEscolha uma opção:\n1 - Cadastrar usuário\n2 - Fazer login\n0 - Sair");
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
                case 0:
                    System.out.println("\nFinalizando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (menuOption != 0);
    }
}