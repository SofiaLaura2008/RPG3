package br.ifpe.jaboatao.RPG.models;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) 
public abstract class Ficha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100,nullable = false)
    private String nome_personagem;
    
    @Column(nullable = false)
    private int idade_personagem;

    @Column(nullable = false)
    private int forca;

    @Column(nullable = false)
    private int agilidade;

    @Column(nullable = false)
    private int intelecto;

    @Column(nullable = false)
    private int vigor;

    @Column(nullable = false)
    private int presenca;

    @Column(nullable = false)
    private int nivel_exposicao;
    
    @Column(nullable = false)
    private int sanidade;

    @Column(nullable = false)
    private int pontos_esforcos;

    @Column(nullable = false)
    private int vida;

    @Column(nullable = false)
    private int deslocamento;

    @Column(nullable = false)
    private int p_e_rodada;

    @OneToMany(mappedBy = "ficha", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Missao> missoes = new ArrayList<>();


    public Ficha(String nome_personagem, int idade_personagem, int forca, int agilidade, int intelecto, int vigor, int presenca, int nivel_exposicao, int sanidade, int pontos_esforcos, int vida, int deslocamento, int p_e_rodada) {
        this.nome_personagem = nome_personagem;
        this.idade_personagem = idade_personagem;
        this.forca = forca;
        this.agilidade = agilidade;
        this.intelecto = intelecto;
        this.vigor = vigor;
        this.presenca = presenca;
        this.nivel_exposicao = nivel_exposicao;
        this.sanidade = sanidade;
        this.pontos_esforcos = pontos_esforcos;
        this.vida = vida;
        this.deslocamento = deslocamento;
        this.p_e_rodada = p_e_rodada;
        this.missoes = new ArrayList<>();
    }

    public Ficha() {}

    public int getId() {
        return this.id;
    }

    public void setId(String nome_personagem) {
        this.nome_personagem = nome_personagem;
    }
    public String getNome_personagem() {
        return this.nome_personagem;
    }

    public void setNome_personagem(String nome_personagem) {
        this.nome_personagem = nome_personagem;
    }

    public int getIdade_personagem() {
        return this.idade_personagem;
    }

    public void setIdade_personagem(int idade_personagem) {
        this.idade_personagem = idade_personagem;
    }

    public int getForca() {
        return this.forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getAgilidade() {
        return this.agilidade;
    }

    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
    }

    public int getIntelecto() {
        return this.intelecto;
    }

    public void setIntelecto(int intelecto) {
        this.intelecto = intelecto;
    }

    public int getVigor() {
        return this.vigor;
    }

    public void setVigor(int vigor) {
        this.vigor = vigor;
    }

    public int getPresenca() {
        return this.presenca;
    }

    public void setPresenca(int presenca) {
        this.presenca = presenca;
    }

    public int getNivel_exposicao() {
        return this.nivel_exposicao;
    }

    public void setNivel_exposicao(int nivel_exposicao) {
        this.nivel_exposicao = nivel_exposicao;
    }

    public int getSanidade() {
        return this.sanidade;
    }

    public void setSanidade(int sanidade) {
        this.sanidade = sanidade;
    }

    public int getVida() {
        return this.vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getDeslocamento() {
        return this.deslocamento;
    }

    public void setDeslocamento(int deslocamento) {
        this.deslocamento = deslocamento;
    }

    public int getP_e_rodada() {
        return this.p_e_rodada;
    }

    public void setP_e_rodada(int p_e_rodada) {
        this.p_e_rodada = p_e_rodada;
    }

    public int getPontos_esforcos() {
        return this.pontos_esforcos;
    }

    public void setPontos_esforcos(int pontos_esforcos) {
        this.pontos_esforcos = pontos_esforcos;
    }
    
    public abstract void habilidades();

    public void adicionarMissao(Missao missao) {
        missoes.add(missao);
    }

    public void removerMissao(Missao missao) {
        missoes.remove(missao);
    }

    public void listarMissoes() {
        System.out.println("Missões de " + nome_personagem + ":");
        for (Missao missao : missoes) {
            missao.exibirDetalhes();
        }
    }
}
