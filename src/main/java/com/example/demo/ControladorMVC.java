package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import org.springframework.ui.Model;

import com.azure.cosmos.*;
import com.azure.storage.blob.*;

@Controller
public class ControladorMVC {

    @Autowired
    RepositorioLivro repositorioLivro;

    @GetMapping("/home")
    public String home(Model model) {
        List<Livro> livros = repositorioLivro.findAll();
        model.addAttribute("livros", livros);
        return "home";
    }

    @PostMapping("/processar")
    public String processarFormulario(@RequestParam("nome") String nome, @RequestParam("autor") String autor, @RequestParam("data") String data, @RequestParam("foto") MultipartFile imagem, @RequestParam("descricao") String descricao) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate data1 = LocalDate.parse(data, formatter);
        String fotoBase64 = Base64.getEncoder().encodeToString(imagem.getBytes());
        Livro l = new Livro(nome, autor, data1, fotoBase64, descricao);
        repositorioLivro.save(l);
        return "redirect:/sucesso";
    }

    @GetMapping("/sucesso")
    public String paginaSucesso() {
        return "sucesso";
    }

}

