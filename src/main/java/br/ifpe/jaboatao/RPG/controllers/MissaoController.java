package br.ifpe.jaboatao.RPG.controllers;

import br.ifpe.jaboatao.RPG.models.Missao;
import br.ifpe.jaboatao.RPG.repositories.MissaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MissaoController {

    @Autowired
    private MissaoRepository missaoRepository;

    @GetMapping("/missoes")
    public String listarMissoes(Model model) {
        List<Missao> missoes = missaoRepository.findAll();
        model.addAttribute("missoes", missoes);
        return "listarMissoes"; 
    }

    // Modificar para adicionar missão sem ficha
    @GetMapping("/novaMissao")
    public String novaMissao(Model model) {
        model.addAttribute("missao", new Missao());
        return "formularioMissao"; // Formulário para criar nova missão
    }

    // O método de adicionar a missão sem ficha
    @PostMapping("/adicionarMissao")
    public String adicionarMissao(@ModelAttribute Missao missao) {
        // Aqui, estamos salvando a missão sem precisar da ficha
        missaoRepository.save(missao);
        return "redirect:/missoes"; // Redireciona para a lista de missões
    }

    // Editar missão
    @GetMapping("/missoes/{id}/editar")
    public String editarMissao(@PathVariable("id") Long id, Model model) {
        Optional<Missao> missao = missaoRepository.findById(id);
        if (missao.isPresent()) {
            model.addAttribute("missao", missao.get());
            return "editarMissao"; // Página de edição da missão
        } else {
            return "redirect:/missoes";
        }
    }

    // Atualizar missão
    @PostMapping("/missoes/{id}/atualizar")
    public String atualizarMissao(@PathVariable("id") Long id, @ModelAttribute Missao missao) {
        Optional<Missao> missaoExistente = missaoRepository.findById(id);
        if (missaoExistente.isPresent()) {
            Missao missaoAtualizada = missaoExistente.get();
            missaoAtualizada.setNome(missao.getNome());
            missaoAtualizada.setDificuldade(missao.getDificuldade());
            missaoAtualizada.setRecompensa(missao.getRecompensa());
            missaoAtualizada.setDescricao(missao.getDescricao());
            missaoRepository.save(missaoAtualizada);
        }
        return "redirect:/missoes";
    }

    // Deletar missão
    @GetMapping("/missoes/{id}/deletar")
    public String deletarMissao(@PathVariable("id") Long id) {
        missaoRepository.deleteById(id);
        return "redirect:/missoes";
    }
}
