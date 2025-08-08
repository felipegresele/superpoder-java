package com.example.demo.controller;

import com.example.demo.model.Superpoder;
import com.example.demo.repository.SuperpoderRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/superpoderes")
public class SuperpoderController {

    @Autowired
    private SuperpoderRepository superpoderRepository;

    // Listar todos os superpoderes
    @GetMapping
    public String listarSuperpoderes(Model model) {
        List<Superpoder> superpoderes = superpoderRepository.findAll();
        model.addAttribute("superpoderes", superpoderes);
        return "superpoder/lista";
    }

    // Mostrar formulário para cadastro de superpoder
    @GetMapping("/novo")
    public String mostrarFormulario(Superpoder superpoder) {
        return "superpoder/formulario";
    }

    // Processar o formulário de cadastro
    @PostMapping("/novo")  // Usando @PostMapping para o envio do formulário
    public String cadastrarSuperpoder(@Valid Superpoder superpoder, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "superpoder/formulario"; // Voltar para o formulário em caso de erro
        }
        superpoderRepository.save(superpoder); // Salvar no banco de dados
        return "redirect:/superpoderes"; // Redirecionar para a lista de superpoderes após salvar
    }
}
