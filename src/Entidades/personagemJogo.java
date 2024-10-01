package Entidades;

import java.util.Random;

public class personagemJogo {

    private String nome;
    private int vida;
    private String poder;
    private double danoPoder;
    private String situacao;

    public personagemJogo(String nome) {
        this.nome = nome;
        this.vida = 30;
    }

    public void perderVida(int vidaPerdida){
        this.vida -= vidaPerdida;
    }

    public void ganharVida(int vidaGanha){
        this.vida += vidaGanha;
    }

    public void diminuirAtaque(){
        if(this.danoPoder > 0){
            this.danoPoder = this.danoPoder-(this.danoPoder*0.5);
        }
    }

    public void sortearPoder(){

        Random random = new Random();
        int numero = random.nextInt(1,4);

        if(numero == 1){
            this.poder = "Shazamm";
            this.danoPoder = 20;
        }else if(numero == 2){
            this.poder = "Defensee";
            this.danoPoder = 0;
        }else{
            this.poder = "Revive";
            this.danoPoder = 0;
        }

    }

    public void situacao(personagemJogo personagem){

        if(this.vida <= 0 && personagem.getVida() <= 0){
            this.situacao = "Empate";
        }else if(this.vida <= 0){
            this.situacao = "Derrota";
        }else {
            this.situacao= "Vitoria";
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPoder() {
        return poder;
    }

    public void setPoder(String poder) {
        this.poder = poder;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public double getDanoPoder() {
        return danoPoder;
    }

    public void setDanoPoder(double danoPoder) {
        this.danoPoder = danoPoder;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    @Override
    public String toString() {
        return "personagemJogo{" +
                "nome='" + nome + '\'' +
                ", vida=" + vida +
                ", poder='" + poder + '\'' +
                '}';
    }
}
