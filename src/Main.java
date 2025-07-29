import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int escolha = 0;
        int senha = 1234;

        //while (escolha !=4) {

        System.out.println("*".repeat(60));
        System.out.println("Dados Iniciais do cliente:");
        System.out.println();
        System.out.printf("%-20s %s\n", "Nome:", "Dalton Vinicius");
        System.out.printf("%-20s %s\n", "Tipo de conta:", "Corrente");
        System.out.printf("%-20s %s\n", "Saldo:", "R$ ****,**");
        System.out.println("*".repeat(60));
        System.out.println("Para acessar a conta digite a senha de 4 digitos");
        System.out.println("*".repeat(60));

        int senhaResposta = scanner.nextInt();


        for (int tentativas = 3; tentativas >= 0; tentativas--) {
            if (senhaResposta == senha) {
                System.out.println("Senha Correta, entrando na conta.");
                break  ;
            } else
                System.out.printf("Senha incorreta, tente novamente.\n" + "Tentativas restantes: %d\n", tentativas);
                senhaResposta = scanner.nextInt();
                if (tentativas == 0){
                    System.out.println("Senha Cancelada por exesso de tentativas.");
                    System.exit(0);
                }
            //}
        }
        System.out.println("saindo do for");

    }
}