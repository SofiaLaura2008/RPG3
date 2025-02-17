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

import br.ifpe.jaboatao.RPG.models.Especialista;
import br.ifpe.jaboatao.RPG.repositories.EspecialistaRepository;


@Controller
public class EspecialistaController {
    @Autowired
    private EspecialistaRepository especialistaRepository;

    @GetMapping("/novoEspecialista")
    public String novoEspecialista(Model model) {
        return "formularioEspecialista"; 
    }

    @PostMapping("/adicionarEspecialista")
    public String adicionarEspecialista(@ModelAttribute Especialista especialista) {
        especialistaRepository.save(especialista);
        return "redirect:/especialista"; 
    }

    @GetMapping("/especialista")
    public String listarEspecialista(Model model) {
        List<Especialista> especialistas = especialistaRepository.findAll();
        model.addAttribute("especialistas", especialistas);
        return "listarEspecialista"; 
    }

    @GetMapping("especialistas/{id}/editar")
    public String editarEspecialista(@PathVariable("id") Long id, Model model) {
        Optional<Especialista> especialistas = especialistaRepository.findById(id);
        if (especialistas.isPresent()) {
            model.addAttribute("especialista", especialistas.get());
            return "editarEspecialista"; // Página de edição do combatente
        } else {
            return "redirect:/especialista"; // Se não encontrar, redireciona para a lista
        }
    }

    @PostMapping("especialista/{id}/atualizar")
    public String atualizarEspecialista(@PathVariable("id") Long id, @ModelAttribute Especialista especialista) {
        Optional<Especialista> especialistaExistente = especialistaRepository.findById(id);
        if (especialistaExistente.isPresent()) {
            Especialista especialistaAtualizado = especialistaExistente.get();
            especialistaAtualizado.setNome_personagem(especialista.getNome_personagem());
            especialistaAtualizado.setIdade_personagem(especialista.getIdade_personagem());   
            especialistaAtualizado.setForca(especialista.getForca());             
            especialistaAtualizado.setAgilidade(especialista.getAgilidade());         
            especialistaAtualizado.setIntelecto(especialista.getIntelecto());     
            especialistaAtualizado.setVigor(especialista.getVigor());     
            especialistaAtualizado.setPresenca(especialista.getPresenca());     
            especialistaAtualizado.setNivel_exposicao(especialista.getNivel_exposicao());     
            especialistaAtualizado.setSanidade(especialista.getSanidade());     
            especialistaAtualizado.setPontos_esforcos(especialista.getPontos_esforcos());     
            especialistaAtualizado.setVida(especialista.getVida());     
            especialistaAtualizado.setDeslocamento(especialista.getDeslocamento());     
            especialistaAtualizado.setP_e_rodada(especialista.getP_e_rodada());
            especialistaAtualizado.setInvestigacao(especialista.getInvestigacao());
            especialistaAtualizado.setPercepcao(especialista.getPercepcao());
            especialistaAtualizado.setPontaria(especialista.getPontaria());
            especialistaRepository.save(especialistaAtualizado);
            return "redirect:/especialista";
        } else {
            return "redirect:/especialista";
        }
    }

    @GetMapping("/especialistas/{id}/deletar")
    public String deletarEspecialista(@PathVariable("id") Long id) {
        especialistaRepository.deleteById(id);
        return "redirect:/especialista"; 
    }

    @GetMapping("/especialistas/filtro")
    public String filtrarEspecialista(@RequestParam(name = "investigacao", required = false) Integer investigacao,
                                    @RequestParam(name = "percepcao", required = false) Integer percepcao,
                                    @RequestParam(name = "pontaria", required = false) Integer pontaria,
                                    Model model) {

        List<Especialista> especialistas;

        if (investigacao != null && percepcao != null && pontaria != null) {
            especialistas = especialistaRepository.findByInvestigacaoAndPercepcaoAndPontaria(investigacao, percepcao, pontaria);
        } else if (investigacao != null) {
            especialistas = especialistaRepository.findByInvestigacao(investigacao);
        } else if (percepcao != null) {
            especialistas = especialistaRepository.findByPercepcao(percepcao);
        } else if (pontaria != null) {
            especialistas = especialistaRepository.findByPontaria(pontaria);
        } else {
            especialistas = especialistaRepository.findAll();
        }

        model.addAttribute("especialistas", especialistas);
        return "listarEspecialistaFiltrado";  // Página para exibir os resultados filtrados
    }


}