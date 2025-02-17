package br.ifpe.jaboatao.RPG.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.jaboatao.RPG.models.Pericias;

public interface PericiaRepository extends JpaRepository<Pericias, Long> {
    List<Pericias> findByLuta(int luta);
    List<Pericias> findByPercepcao(int percepcao);
    List<Pericias> findByReflexos(int reflexos);
    List<Pericias> findByLutaAndPercepcaoAndReflexos(int luta, int percepcao, int reflexos);

}
