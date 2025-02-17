package br.ifpe.jaboatao.RPG.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.ifpe.jaboatao.RPG.models.Missao;

public interface MissaoRepository extends JpaRepository<Missao, Long> {
}
