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

import br.ifpe.jaboatao.RPG.models.Ocultista;
import br.ifpe.jaboatao.RPG.repositories.OcultistaRepository;

@Controller
public class OcultistaController {
    @Autowired
    private OcultistaRepository ocultistaRepository;

    @GetMapping("/novoOcultista")
    public String novoOcultista(Model model) {
        return "formularioOcultista"; 
    }

    @PostMapping("/adicionarOcultista")
    public String adicionarOcultista(@ModelAttribute Ocultista ocultista) {
        ocultistaRepository.save(ocultista);
        return "redirect:/ocultistas"; 
    }

    @GetMapping("/ocultistas")
    public String listarOcultista(Model model) {
        List<Ocultista> ocultistas = ocultistaRepository.findAll();
        model.addAttribute("ocultistas", ocultistas);
        return "listarOcultista"; 
    }

    @GetMapping("ocultistas/{id}/editar")
    public String editarOcultista(@PathVariable("id") Long id, Model model) {
        Optional<Ocultista> ocultista = ocultistaRepository.findById(id);
        if (ocultista.isPresent()) {
            model.addAttribute("ocultista", ocultista.get());
            return "editarOcultista"; 
        } else {
            return "redirect:/ocultistas"; 
        }
    }

    @PostMapping("ocultistas/{id}/atualizar")
    public String atualizarOCultista(@PathVariable("id") Long id, @ModelAttribute Ocultista ocultista) {
        Optional<Ocultista> ocultistaExistente = ocultistaRepository.findById(id);
        if (ocultistaExistente.isPresent()) {
            Ocultista ocultistaAtualizado = ocultistaExistente.get();
            ocultistaAtualizado.setNome_personagem(ocultista.getNome_personagem());
            ocultistaAtualizado.setIdade_personagem(ocultista.getIdade_personagem());   
            ocultistaAtualizado.setForca(ocultista.getForca());             
            ocultistaAtualizado.setAgilidade(ocultista.getAgilidade());         
            ocultistaAtualizado.setIntelecto(ocultista.getIntelecto());     
            ocultistaAtualizado.setVigor(ocultista.getVigor());     
            ocultistaAtualizado.setPresenca(ocultista.getPresenca());     
            ocultistaAtualizado.setNivel_exposicao(ocultista.getNivel_exposicao());     
            ocultistaAtualizado.setSanidade(ocultista.getSanidade());     
            ocultistaAtualizado.setPontos_esforcos(ocultista.getPontos_esforcos());     
            ocultistaAtualizado.setVida(ocultista.getVida());     
            ocultistaAtualizado.setDeslocamento(ocultista.getDeslocamento());     
            ocultistaAtualizado.setP_e_rodada(ocultista.getP_e_rodada());
            ocultistaAtualizado.setOcultismo(ocultista.getOcultismo());
            ocultistaAtualizado.setVontade(ocultista.getVontade());
            ocultistaAtualizado.setIntuicao(ocultista.getIntuicao());
            ocultistaRepository.save(ocultistaAtualizado);
            return "redirect:/ocultistas";
        } else {
            return "redirect:/ocultistas";
        }
    }

    @GetMapping("/ocultista/{id}/deletar")
    public String deletarOcultista(@PathVariable("id") Long id) {
        ocultistaRepository.deleteById(id);
        return "redirect:/ocultistas"; 
    }

    @GetMapping("/ocultistas/filtro")
    public String filtrarOcultista(@RequestParam(name = "ocultismo", required = false) Integer ocultismo,
                                @RequestParam(name = "vontade", required = false) Integer vontade,
                                @RequestParam(name = "intuicao", required = false) Integer intuicao,
                                Model model) {

        List<Ocultista> ocultistas;

        if (ocultismo != null && vontade != null && intuicao != null) {
            ocultistas = ocultistaRepository.findByOcultismoAndVontadeAndIntuicao(ocultismo, vontade, intuicao);
        } else if (ocultismo != null) {
            ocultistas = ocultistaRepository.findByOcultismo(ocultismo);
        } else if (vontade != null) {
            ocultistas = ocultistaRepository.findByVontade(vontade);
        } else if (intuicao != null) {
            ocultistas = ocultistaRepository.findByIntuicao(intuicao);
        } else {
            ocultistas = ocultistaRepository.findAll();
        }

        model.addAttribute("ocultistas", ocultistas);
        return "listarOcultistaFiltrado";  
    }

}
