package br.ifpe.jaboatao.RPG.repositories;

import br.ifpe.jaboatao.RPG.models.Especialista;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EspecialistaRepository extends JpaRepository<Especialista, Long>{
    List<Especialista> findByInvestigacao(int investigacao);
    List<Especialista> findByPercepcao(int percepcao);
    List<Especialista> findByPontaria(int pontaria);
    List<Especialista> findByInvestigacaoAndPercepcaoAndPontaria(int investigacao, int percepcao, int pontaria);
}
