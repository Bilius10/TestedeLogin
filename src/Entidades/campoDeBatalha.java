package Entidades;

public class campoDeBatalha {

    private personagemJogo player1;
    private personagemJogo player2;

    public campoDeBatalha(personagemJogo player1, personagemJogo player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void batalha(personagemJogo atacante, personagemJogo defensor){

        System.out.println("Atacante: "+atacante.getNome());
        System.out.println("Defensor: "+defensor.getNome());

        if(atacante.getPoder().equals("Shazamm")){
            defensor.perderVida(20);
        }else if(atacante.getPoder().equals("Defensee")){
            defensor.diminuirAtaque();
        }else if(atacante.getPoder().equals("Revive")){
            atacante.ganharVida(15);
        }

    }

    public personagemJogo getPlayer1() {
        return player1;
    }

    public void setPlayer1(personagemJogo player1) {
        this.player1 = player1;
    }

    public personagemJogo getPlayer2() {
        return player2;
    }

    public void setPlayer2(personagemJogo player2) {
        this.player2 = player2;
    }
}
