import DAO.InfoJogoDAO;
import Entidades.InfoJogo;
import Entidades.campoDeBatalha;
import Entidades.loginUsuario;
import Entidades.personagemJogo;
import java.util.Random;

public class Jogo {
    
    public void jogar(loginUsuario loginUsuario){
        InfoJogoDAO infoJogoDAO = new InfoJogoDAO();
        InfoJogo infoJogo = infoJogoDAO.findById(loginUsuario.getIdUsuario());

        System.out.println(" ");

        System.out.println("Seja bem-vindo ao Duelo de feiticeiros");
        System.out.println("Teremos 3 poderes, e o jogo apenas acaba quando um dos dois morrer");

        Random random = new Random();
        personagemJogo usuario = new personagemJogo(loginUsuario.getNome());
        personagemJogo robo = new personagemJogo("Cleytin mill grau");
        campoDeBatalha campoDeBatalha = new campoDeBatalha(usuario, robo);

        int x = 1;
        int numeroSorteioComecar = random.nextInt(1,3);

        while (usuario.getVida() > 0 && robo.getVida() > 0){
            System.out.println(" ");
            System.out.println("Round "+x);

            usuario.sortearPoder();
            robo.sortearPoder();

            int numero = numeroSorteioComecar+x;
            if(numero % 2 == 0){
                campoDeBatalha.batalha(usuario, robo);
            }else{
                campoDeBatalha.batalha(robo, usuario);
            }

            System.out.println(" ");
            System.out.println(usuario.toString());
            System.out.println(robo.toString());
            x++;

            try {
                Thread.sleep(2000); // Pausa por 2 segundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        usuario.situacao(robo);
        robo.situacao(usuario);
        System.out.println(" ");
        System.out.println(robo.getNome()+"-"+robo.getSituacao());
        System.out.println(usuario.getNome()+"-"+usuario.getSituacao());

        if(usuario.getSituacao().equals("Empate")){
            infoJogo.setEmpates(infoJogo.getEmpates()+1);
            infoJogo.setPontuacao(infoJogo.getPontuacao()+1);
        }else if(usuario.getSituacao().equals("Vitoria")){
            infoJogo.setVitorias(infoJogo.getVitorias()+1);
            infoJogo.setPontuacao(infoJogo.getPontuacao()+2);
        }else{
            infoJogo.setDerrotas(infoJogo.getDerrotas()+1);
            infoJogo.setPontuacao(infoJogo.getPontuacao()-1);
        }
        infoJogo.setPartidasJogadas(infoJogo.getPartidasJogadas()+1);
        infoJogoDAO.atualizarInformacoes(infoJogo);
    }
}
