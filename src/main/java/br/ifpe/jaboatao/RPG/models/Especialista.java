package br.ifpe.jaboatao.RPG.models;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Especialista extends Ficha{
    @Column(nullable = false)
    private int investigacao;
    
    @Column(nullable = false)
    private int percepcao;
    
    @Column(nullable = false)
    private int pontaria;
    
    public Especialista(String nome_personagem, int idade_personagem, int forca, int agilidade, int intelecto, int vigor, int presenca, int nivel_exposicao, int sanidade, int postos_esforcos, int vida, int deslocamento, int p_e_rodada, int investigacao, int percepcao, int pontaria){
        super(nome_personagem, idade_personagem, forca, agilidade, intelecto, vigor, presenca, nivel_exposicao, sanidade, postos_esforcos, vida, deslocamento, p_e_rodada); 
        this.investigacao = investigacao;
        this.percepcao = percepcao;
        this.pontaria = pontaria;
    }    

    public Especialista() {
        super(); 
    }

    public int getInvestigacao() {
        return this.investigacao;
    }

    public void setInvestigacao(int investigacao) {
        this.investigacao = investigacao;
    }

    public int getPercepcao() {
        return this.percepcao;
    }

    public void setPercepcao(int percepcao) {
        this.percepcao = percepcao;
    }

    public int getPontaria() {
        return this.pontaria;
    }

    public void setPontaria(int pontaria) {
        this.pontaria = pontaria;
    }

    @Override
    public void habilidades() {
        System.out.println("Nome do personagem: " + getNome_personagem() + ", Idade do personagem: " +  ", Investigação: " + getInvestigacao() + ", Percepção: " + getPercepcao() + ", Pontaria: " + getPontaria());
    }
}