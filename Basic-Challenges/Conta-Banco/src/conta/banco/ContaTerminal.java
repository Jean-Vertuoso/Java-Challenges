package conta.banco;

import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {

    public static void main(String[] args) throws ParseException {
        //TODO: Conhecer e importar a classe Scanner
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        
        //Exibir as mensagens para o nosso usuário
        
        System.out.print("Por favor, digite o número da Conta: " );
        Integer conta = sc.nextInt();
        
        System.out.print("Por favor, digite o número da Agência: " );
        String agencia = sc.next();
        sc.nextLine();
        System.out.print("Por favor, digite o nome do cliente: " );
        String nome = sc.nextLine();
        
        System.out.print("Por favor, digite o saldo da Conta: " );
        Double saldo = sc.nextDouble();
        
        //Obter pela classe Scanner os valores digitados no terminal
        
        //Exibir a mensagem da conta criada.
        
        System.out.println("Olá "+ nome +", obrigado por criar uma conta em nosso banco.\n Sua Agência é "+ agencia +", conta "+ conta +" e seu saldo "+ saldo +" já está disponível para saque.");
        
        sc.close();
    }
    
}
