import DAO.InfoJogoDAO;
import DAO.loginUsuarioDAO;
import Entidades.InfoJogo;
import Entidades.loginUsuario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        loginUsuario loginUsuario = new loginUsuario();
        loginUsuarioDAO loginUsuarioDAO = new loginUsuarioDAO();

        InfoJogo infoJogo = new InfoJogo();
        InfoJogoDAO infoJogoDAO = new InfoJogoDAO();

        Jogo jogo = new Jogo();

        int opcao = 0;
        while (opcao != 4) {

            System.out.println("\n 1-Criar Conta \n 2-Logar \n 3-Rank de jogadores \n 4-Sair");
            opcao = teclado.nextInt();
            System.out.println(" ");

            switch (opcao) {
                case 1:

                    System.out.print("Nome: ");
                    loginUsuario.setNome(teclado.next());
                    System.out.print("Ano de nascimento:");
                    loginUsuario.setAno_nascimento(teclado.nextInt());
                    System.out.print("Cpf: ");
                    loginUsuario.setCpf(teclado.next());
                    System.out.print("Email: ");
                    loginUsuario.setEmail(teclado.next());
                    System.out.print("Login: ");
                    loginUsuario.setLogin(teclado.next());
                    System.out.print("Senha: ");
                    loginUsuario.setSenha(teclado.next());
                    loginUsuarioDAO.createLoginUsuario(loginUsuario);

                    infoJogo.setIdUsuario(loginUsuario.getIdUsuario());
                    infoJogoDAO.createInfoJogo(infoJogo);

                    break;
                case 2:

                    System.out.print("Login: ");
                    String login = teclado.next();
                    System.out.print("Senha: ");
                    String senha = teclado.next();
                    loginUsuario = loginUsuarioDAO.aprovarLogin(login, senha);

                    if(loginUsuario.getNome() != null){

                        System.out.println("Seja Bem-Vindo "+ loginUsuario.getNome());

                        String sairDoJogo = "S";
                        while (sairDoJogo.equals("S")){
                            sairDoJogo = jogo.jogar(loginUsuario);
                        }

                    }else {
                        System.out.println("Credenciais incorretas");
                    }
                    break;
                case 3:

                    infoJogoDAO.rankJogo();
                    break;
                default:
                    System.out.println("Saindo");
            }
        }
    }
}
