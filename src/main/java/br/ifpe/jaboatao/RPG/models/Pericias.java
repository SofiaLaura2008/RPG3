package br.ifpe.jaboatao.RPG.models;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pericias extends Ficha{
    @Column(nullable = false)
    private int acrobacia;
    
    @Column(nullable = false)
    private int atletismo;

    @Column(nullable = false)
    private int enganacao;

    @Column(nullable = false)
    private int fortitude;

    @Column(nullable = false)
    private int furtividade;

    @Column(nullable = false)
    private int intimidacao;

    @Column(nullable = false)
    private int intuicao;

    @Column(nullable = false)
    private int investigacao;

    @Column(nullable = false)
    private int luta;

    @Column(nullable = false)
    private int medicina;

    @Column(nullable = false)
    private int percepcao;

    @Column(nullable = false)
    private int pilotagem;

    @Column(nullable = false)
    private int pontaria;

    @Column(nullable = false)
    private int reflexos;

    @Column(nullable = false)
    private int sobrevivencia;

    @Column(nullable = false)
    private int tatica;
    
    @Column(nullable = false)
    private int tecnologia;

    public Pericias(String nome_personagem, int idade_personagem, int forca, int agilidade, int intelecto, int vigor, int presenca, int nivel_exposicao, int sanidade, int postos_esforcos, int vida, int deslocamento, int p_e_rodada, int acrobacia, int atletismo, int enganacao, int fortitude, int furtividade, int intimidacao, int intuicao, int investigacao, int luta, int medicina, int percepcao, int pilotagem, int pontaria, int reflexos, int sobrevivencia, int tatica, int tecnologia){
        super(nome_personagem, idade_personagem, forca, agilidade, intelecto, vigor, presenca, nivel_exposicao, sanidade, postos_esforcos, vida, deslocamento, p_e_rodada); 
        this.acrobacia = acrobacia;
        this.atletismo = atletismo;
        this.enganacao = enganacao;
        this.fortitude = fortitude;
        this.furtividade = furtividade;
        this.intimidacao = intimidacao;
        this.intuicao = intuicao;
        this.investigacao = investigacao;
        this.luta = luta;
        this.medicina = medicina;
        this.percepcao = percepcao;
        this.pilotagem = pilotagem;
        this.pontaria = pontaria;
        this.reflexos = reflexos;
        this.sobrevivencia = sobrevivencia;
        this.tatica = tatica;
        this.tecnologia = tecnologia;
    }

    public Pericias() {
        super(); // Chamando o construtor padrão da classe pai (Ficha)
    }

    public int getAcrobacia() {
        return this.acrobacia;
    }

    public void setAcrobacia(int acrobacia) {
        this.acrobacia = acrobacia;
    }

    public int getAtletismo() {
        return this.atletismo;
    }

    public void setAtletismo(int atletismo) {
        this.atletismo = atletismo;
    }

    public int getEnganacao() {
        return this.enganacao;
    }

    public void setEnganacao(int enganacao) {
        this.enganacao = enganacao;
    }

    public int getFortitude() {
        return this.fortitude;
    }

    public void setFortitude(int fortitude) {
        this.fortitude = fortitude;
    }

    public int getFurtividade() {
        return this.furtividade;
    }

    public void setFurtividade(int furtividade) {
        this.furtividade = furtividade;
    }

    public int getIntimidacao() {
        return this.intimidacao;
    }

    public void setIntimidacao(int intimidacao) {
        this.intimidacao = intimidacao;
    }

    public int getIntuicao() {
        return this.intuicao;
    }

    public void setIntuicao(int intuicao) {
        this.intuicao = intuicao;
    }

    public int getInvestigacao() {
        return this.investigacao;
    }

    public void setInvestigacao(int investigacao) {
        this.investigacao = investigacao;
    }

    public int getLuta() {
        return this.luta;
    }

    public void setLuta(int luta) {
        this.luta = luta;
    }

    public int getMedicina() {
        return this.medicina;
    }

    public void setMedicina(int medicina) {
        this.medicina = medicina;
    }

    public int getPercepcao() {
        return this.percepcao;
    }

    public void setPercepcao(int percepcao) {
        this.percepcao = percepcao;
    }

    public int getPilotagem() {
        return this.pilotagem;
    }

    public void setPilotagem(int pilotagem) {
        this.pilotagem = pilotagem;
    }

    public int getPontaria() {
        return this.pontaria;
    }

    public void setPontaria(int pontaria) {
        this.pontaria = pontaria;
    }

    public int getReflexos() {
        return this.reflexos;
    }

    public void setReflexos(int reflexos) {
        this.reflexos = reflexos;
    }

    public int getSobrevivencia() {
        return this.sobrevivencia;
    }

    public void setSobrevivencia(int sobrevivencia) {
        this.sobrevivencia = sobrevivencia;
    }

    public int getTatica() {
        return this.tatica;
    }

    public void setTatica(int tatica) {
        this.tatica = tatica;
    }

    public int getTecnologia() {
        return this.tecnologia;
    }

    public void setTecnologia(int tecnologia) {
        this.tecnologia = tecnologia;
    }
    
    @Override
    public void habilidades() {
        System.out.println("Nome do personagem: " + getNome_personagem() + ", Idade do personagem" + getIdade_personagem() + ", " + "Acrobacia: " + getAcrobacia() + ", " + "Atletismo: " + getAtletismo() + ", " + "Enganação: " + getEnganacao() + ", " + "Fortitude: " + getFortitude() + ", " + "Furtividade: " + getFurtividade() + ", " + "Intimidação: " + getIntimidacao() + ", " + "Intuição: " + getIntuicao() + ", " + "Investigação: " + getInvestigacao() + ", " + "Luta: " + getLuta() + ", " + "Medicina: " + getMedicina() + ", " + "Percepção: " + getPercepcao() + ", " + "Pilotagem: " + getPilotagem() + ", " + "Pontaria: " + getPontaria() + ", " + "Reflexos: " + getReflexos() + ", " + "Sobrevivência: " + getSobrevivencia() + ", " + "Tática: " + getTatica() + ", " + "Tecnologia: " + getTecnologia());
    }
}
