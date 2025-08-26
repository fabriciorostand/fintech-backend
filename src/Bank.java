public class Bank {
    int id;
    String name;
    int number;

    public Bank() {

    }

    public Bank(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public void displayBank() {
        System.out.println("\nNome do banco: " + name);
        System.out.println("Número do banco: " + number);
    }
}