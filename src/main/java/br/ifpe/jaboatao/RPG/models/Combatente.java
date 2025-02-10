package br.ifpe.jaboatao.RPG.models;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) 
public class Combatente extends Ficha{
    
    @Column(nullable = false)
    private int luta;

    @Column(nullable = false)
    private int fortitude;

    public Combatente(String nome_personagem, int idade_personagem, int forca, int agilidade, int intelecto, int vigor, int presenca, int nivel_exposicao, int sanidade, int pontos_esforcos, int vida, int deslocamento, int p_e_rodada, int luta, int fortitude) {
        super(nome_personagem, idade_personagem, forca, agilidade, intelecto, vigor, presenca, nivel_exposicao, sanidade, pontos_esforcos, vida, deslocamento, p_e_rodada);
        this.luta = luta;
        this.fortitude = fortitude;
    }
    
    public Combatente() {
        super(); 
    }

    public int getLuta() {
        return this.luta;
    }

    public void setLuta(int luta) {
        this.luta = luta;
    }

    public int getFortitude() {
        return this.fortitude;
    }

    public void setFortitude(int fortitude) {
        this.fortitude = fortitude;
    }

    @Override
    public void habilidades() {
        System.out.println("Nome do personagem: " + getNome_personagem() +", Idade do personagem: " + getIdade_personagem() + "Luta: " + getLuta() + ", Fortitude: " + getFortitude());
    }
}