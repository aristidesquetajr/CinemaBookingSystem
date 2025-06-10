
import Util.LimparTela;
import Controller.ServicoFilme;
import View.ViewFilme;
import View.ViewReserva;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
/**
 *
 * @author kashiki
 */
public class App {

    public static void main(String[] args) {
        ServicoFilme servicoFilme = new ServicoFilme();

        ViewFilme viewFilme = new ViewFilme(servicoFilme);
        ViewReserva viewReserva = new ViewReserva(servicoFilme);

        Scanner scan = new Scanner(System.in);

        final int MENUFILME = 1, MENURESERVA = 2, SAIR = 3;

        int option;

        do {
            LimparTela.Clear();
            System.out.println("\n*****Sistema de Reserva de Bilhetes de Cinema*****");
            System.out.format("1 - Menu Filmes\n2 - Menu Reservas\n3 - Sair\nEscolha uma opção: ");

            option = scan.nextInt();
            scan.nextLine();

            switch (option) {
                case MENUFILME ->
                    viewFilme.menu();
                case MENURESERVA ->
                    viewReserva.menu();
                case SAIR ->
                    System.exit(0);
                default ->
                    System.out.println("Opção Inválida!");
            }
        } while (option != 3);

    }
}
