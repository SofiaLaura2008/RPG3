package br.ifpe.jaboatao.RPG.controllers;

import br.ifpe.jaboatao.RPG.models.Combatente;
import br.ifpe.jaboatao.RPG.repositories.CombatenteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
public class CombatenteController {
    @Autowired
    private CombatenteRepository combatenteRepository;

    @GetMapping("/")
    public String paginaInicial() {
        return "home"; 
    }

    @GetMapping("/novoCombatente")
    public String novoCombatente(Model model) {
        return "formularioCombatente"; 
    }

    @PostMapping("/adicionarCombatente")
    public String adicionarCombatente(@ModelAttribute Combatente combatente) {
        combatenteRepository.save(combatente);
        return "redirect:/combatentes"; 
    }

    @GetMapping("/combatentes")
    public String listarCombatentes(Model model) {
        List<Combatente> combatentes = combatenteRepository.findAll();
        model.addAttribute("combatentes", combatentes);
        return "listarCombatente"; 
    }


    @GetMapping("/combatentes/{id}")
    public String exibirCombatente(@PathVariable("id") Long id, Model model) {
        Optional<Combatente> combatente = combatenteRepository.findById(id);
        if (combatente.isPresent()) {
            model.addAttribute("combatente", combatente.get());
            return "detalhesCombatente"; 
        } else {
            return "redirect:/combatentes"; 
        }
    }

    @GetMapping("combatentes/{id}/editar")
    public String editarCombatente(@PathVariable("id") Long id, Model model) {
        Optional<Combatente> combatente = combatenteRepository.findById(id);
        if (combatente.isPresent()) {
            model.addAttribute("combatente", combatente.get());
            return "editarCombatentes"; // Página de edição do combatente
        } else {
            return "redirect:/combatentes"; // Se não encontrar, redireciona para a lista
        }
    }

    @PostMapping("combatentes/{id}/atualizar")
    public String atualizarCombatente(@PathVariable("id") Long id, @ModelAttribute Combatente combatente) {
        Optional<Combatente> combatenteExistente = combatenteRepository.findById(id);
        if (combatenteExistente.isPresent()) {
            Combatente combatenteAtualizado = combatenteExistente.get();
            combatenteAtualizado.setNome_personagem(combatente.getNome_personagem());
            combatenteAtualizado.setIdade_personagem(combatente.getIdade_personagem());
            combatenteAtualizado.setLuta(combatente.getLuta());
            combatenteAtualizado.setFortitude(combatente.getFortitude());
            // Atualize outros campos conforme necessário

            combatenteRepository.save(combatenteAtualizado);
            return "redirect:/combatentes";
        } else {
            return "redirect:/combatentes";
        }
    }

    @GetMapping("/combatentes/{id}/deletar")
    public String deletarCombatente(@PathVariable("id") Long id) {
        combatenteRepository.deleteById(id);
        return "redirect:/combatentes"; 
    }
}
