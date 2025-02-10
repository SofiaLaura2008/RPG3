package br.ifpe.jaboatao.RPG.repositories;

import br.ifpe.jaboatao.RPG.models.Combatente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CombatenteRepository extends JpaRepository<Combatente, Long> {
}
