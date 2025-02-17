package br.ifpe.jaboatao.RPG.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.ifpe.jaboatao.RPG.models.Combatente;
import java.util.List;

public interface CombatenteRepository extends JpaRepository<Combatente, Long> {
    List<Combatente> findByLuta(int luta);
    List<Combatente> findByFortitude(int fortitude);
    List<Combatente> findByLutaAndFortitude(int luta, int fortitude);
}
