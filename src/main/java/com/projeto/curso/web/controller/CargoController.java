package com.projeto.curso.web.controller;

import com.projeto.curso.Service.CargoService;
import com.projeto.curso.Service.DepartamentoService;
import com.projeto.curso.domain.Cargo;
import com.projeto.curso.domain.Departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/cargos")
public class CargoController {
    @Autowired
    private CargoService cargoService;

    @Autowired
    private DepartamentoService departamentoService;
    @GetMapping("/cadastrar")
    public String cadastrar(Cargo cargo){
        return "/cargo/cadastro";
    }
    @GetMapping("/listar")
    public String listar(){
        return "/cargo/lista";
    }
    @PostMapping("/salvar")
    public String salvar(Cargo cargo, RedirectAttributes attributes){
        cargoService.salvar(cargo);
        attributes.addFlashAttribute("success","Cargo inserido com sucesso!");
        return "redirect:/cargos/cadastrar";
    }
    @ModelAttribute("departamentos")
    public List<Departamento> listaDeDepartamentos(){
        return departamentoService.buscarTodos();
    }

}
