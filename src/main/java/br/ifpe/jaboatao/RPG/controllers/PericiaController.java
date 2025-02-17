package br.ifpe.jaboatao.RPG.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.ifpe.jaboatao.RPG.models.Pericias;
import br.ifpe.jaboatao.RPG.repositories.PericiaRepository;

@Controller
public class PericiaController {
    @Autowired
    private PericiaRepository periciaRepository;

    @GetMapping("/novoPericia")
    public String novoPericia(Model model) {
        return "formularioPericia"; 
    }

    @PostMapping("/adicionarPericia")
    public String adicionarPericia(@ModelAttribute Pericias pericias) {
        periciaRepository.save(pericias);
        return "redirect:/pericias"; 
    }

    @GetMapping("/pericias")
    public String listarPericias(Model model) {
        List<Pericias> pericias = periciaRepository.findAll();
        model.addAttribute("pericias", pericias);
        return "listarPericia"; 
    }

    @GetMapping("pericias/{id}/editar")
    public String editarPericia(@PathVariable("id") Long id, Model model) {
        Optional<Pericias> pericias = periciaRepository.findById(id);
        if (pericias.isPresent()) {
            model.addAttribute("pericias", pericias.get());
            return "editarPericia"; 
        } else {
            return "redirect:/pericias"; 
        }
    }

    @PostMapping("pericias/{id}/atualizar")
    public String atualizarPericia(@PathVariable("id") Long id, @ModelAttribute Pericias pericias) {
        Optional<Pericias> periciaExistente = periciaRepository.findById(id);
        if (periciaExistente.isPresent()) {
            Pericias periciaAtualizado = periciaExistente.get();
            periciaAtualizado.setNome_personagem(pericias.getNome_personagem());
            periciaAtualizado.setIdade_personagem(pericias.getIdade_personagem());   
            periciaAtualizado.setForca(pericias.getForca());             
            periciaAtualizado.setAgilidade(pericias.getAgilidade());         
            periciaAtualizado.setIntelecto(pericias.getIntelecto());     
            periciaAtualizado.setVigor(pericias.getVigor());     
            periciaAtualizado.setPresenca(pericias.getPresenca());     
            periciaAtualizado.setNivel_exposicao(pericias.getNivel_exposicao());     
            periciaAtualizado.setSanidade(pericias.getSanidade());     
            periciaAtualizado.setPontos_esforcos(pericias.getPontos_esforcos());     
            periciaAtualizado.setVida(pericias.getVida());     
            periciaAtualizado.setDeslocamento(pericias.getDeslocamento());     
            periciaAtualizado.setP_e_rodada(pericias.getP_e_rodada());
            periciaAtualizado.setAcrobacia(pericias.getAcrobacia());
            periciaAtualizado.setAtletismo(pericias.getAtletismo());
            periciaAtualizado.setEnganacao(pericias.getEnganacao());
            periciaAtualizado.setFortitude(pericias.getFortitude());
            periciaAtualizado.setFurtividade(pericias.getFurtividade());
            periciaAtualizado.setIntimidacao(pericias.getIntimidacao());
            periciaAtualizado.setIntuicao(pericias.getIntuicao());
            periciaAtualizado.setInvestigacao(pericias.getInvestigacao());
            periciaAtualizado.setLuta(pericias.getLuta());
            periciaAtualizado.setMedicina(pericias.getMedicina());
            periciaAtualizado.setPercepcao(pericias.getPercepcao());
            periciaAtualizado.setPilotagem(pericias.getPilotagem());
            periciaAtualizado.setPontaria(pericias.getPontaria());
            periciaAtualizado.setReflexos(pericias.getReflexos());
            periciaAtualizado.setSobrevivencia(pericias.getSobrevivencia());
            periciaAtualizado.setTatica(pericias.getTatica());
            periciaAtualizado.setTecnologia(pericias.getTecnologia());
            periciaRepository.save(periciaAtualizado);
            return "redirect:/pericias";
        } else {
            return "redirect:/pericias";
        }
    }

    @GetMapping("/pericias/{id}/deletar")
    public String deletarOcultista(@PathVariable("id") Long id) {
        periciaRepository.deleteById(id);
        return "redirect:/pericias"; 
    }

    @GetMapping("/pericias/filtro")
public String filtrarPericia(@RequestParam(name = "luta", required = false) Integer luta,
                              @RequestParam(name = "percepcao", required = false) Integer percepcao,
                              @RequestParam(name = "reflexos", required = false) Integer reflexos,
                              Model model) {

    List<Pericias> pericias;

    if (luta != null && percepcao != null && reflexos != null) {
        pericias = periciaRepository.findByLutaAndPercepcaoAndReflexos(luta, percepcao, reflexos);
    } else if (luta != null) {
        pericias = periciaRepository.findByLuta(luta);
    } else if (percepcao != null) {
        pericias = periciaRepository.findByPercepcao(percepcao);
    } else if (reflexos != null) {
        pericias = periciaRepository.findByReflexos(reflexos);
    } else {
        pericias = periciaRepository.findAll();
    }

    model.addAttribute("pericias", pericias);
    return "listarPericiaFiltrado";  // Nome da página para exibir os resultados filtrados
}

}
