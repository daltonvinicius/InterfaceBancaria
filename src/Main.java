import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int escolha = 0;
        int senha = 1234;
        double saldo = 1000;
        String tipoConta = "Corrente";
        String nome = "Peter Parker";
        String primeiroNome = nome.split(" ")[0];
        String saldoEmTexto = String.valueOf(saldo);
        String saldoMascarado = "*".repeat(saldoEmTexto.length());
        String interfaceBanco = """
                ************************************************************
                Dados Iniciais do cliente:
                
                Nome:                %s
                Tipo de conta:       %s
                Saldo:               R$%.2f
                ************************************************************
                Operações
                
                1- Consultar Saldo
                2- Receber PIX
                3- Fazer PIX
                4- Sair
                ************************************************************
                Digite a opção desejada:
                """;


        System.out.println("*".repeat(60));
        System.out.println("Dados Iniciais do cliente:");
        System.out.println();
        System.out.printf("%-20s %s\n", "Nome:", nome);
        System.out.printf("%-20s %s\n", "Tipo de conta:", tipoConta);
        System.out.printf("%-20s R$ %s\n", "Saldo:", saldoMascarado);
        System.out.println("*".repeat(60));
        System.out.println("Para acessar a conta digite a senha de 4 digitos");
        System.out.println("*".repeat(60));

        int senhaResposta = scanner.nextInt();


        for (int tentativas = 2; tentativas >= 0; tentativas--) {
            if (senhaResposta == senha) {
                System.out.println("Senha Correta, entrando na conta.");
                break;
            } else {
                System.out.printf("""
                        Senha incorreta, tente novamente.
                        Tentativas restantes: %d
                        """, tentativas);
                senhaResposta = scanner.nextInt();
                if (tentativas == 0) {
                    System.out.println("Senha Cancelada por exesso de tentativas.");
                    System.exit(0);
                }
            }
        }
        while (true) {
           /*
           Laço for para pular linhas e "limpar a tela do prompt de comando"
           for (int i = 0; i < 50; i++) {

                System.out.println();
            }
            */

            System.out.printf(interfaceBanco, nome, tipoConta,saldo);
            escolha = scanner.nextInt();

            if (escolha < 1 || escolha > 4) {
                System.out.println("Opção inválida, digite novamente.");
            }

            switch (escolha) {
                case 1:
                    System.out.printf("%s, o seu saldo é de %.2f\n", primeiroNome, saldo);
                    break;

                case 2:
                    System.out.printf("%s, qual o valor que você vai receber no pix?\n", primeiroNome);
                    double valorRecebido = scanner.nextDouble();
                    saldo += valorRecebido;
                    System.out.printf("O saldo atualizado é de %.2f reais\n", saldo);
                    break;

                case 3:
                    System.out.printf("%s, qual o valor que você vai enviar?\n", primeiroNome);
                    double valorEnviado = scanner.nextDouble();
                    if (valorEnviado > saldo) {
                        System.out.println("Saldo insuficiente para completar operação.\n");
                    } else {
                        saldo -= valorEnviado;
                        System.out.printf("O saldo atualizado é de %.2f reais\n", saldo);
                    }
                    break;
                case 4:
                    System.out.printf("""
                            Até logo %s!
                            Saindo da conta e encerrando a sessão.
                            """, primeiroNome);
                    System.exit(0);

            }
        }
    }

}
