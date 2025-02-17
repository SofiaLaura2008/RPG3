package br.ifpe.jaboatao.RPG.repositories;

import br.ifpe.jaboatao.RPG.models.Ocultista;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OcultistaRepository extends JpaRepository<Ocultista, Long>{
    List<Ocultista> findByOcultismo(int ocultismo);
    List<Ocultista> findByVontade(int vontade);
    List<Ocultista> findByIntuicao(int intuicao);
    List<Ocultista> findByOcultismoAndVontadeAndIntuicao(int ocultismo, int vontade, int intuicao);

}
