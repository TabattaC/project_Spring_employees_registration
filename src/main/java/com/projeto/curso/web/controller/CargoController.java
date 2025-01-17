package com.projeto.curso.web.controller;

import com.projeto.curso.Service.CargoService;
import com.projeto.curso.Service.DepartamentoService;
import com.projeto.curso.domain.Cargo;
import com.projeto.curso.domain.Departamento;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
    public String listar(ModelMap modelMap){
        modelMap.addAttribute("cargos", cargoService.buscarTodos());
        return "/cargo/lista";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap modelMap){
        modelMap.addAttribute("cargo", cargoService.buscarPorId(id));
        return "cargo/cadastro";
    }

    @PostMapping("/editar")
    public String editar(@Valid  Cargo cargo, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "/cargo/cadastro";
        }
        cargoService.editar(cargo);
        redirectAttributes.addFlashAttribute("success", "Registro atualizado com sucesso!");
        return "redirect:/cargos/cadastrar";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Cargo cargo, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            return "/cargo/cadastro";
        }

        cargoService.salvar(cargo);
        attributes.addFlashAttribute("success","Cargo inserido com sucesso!");
        return "redirect:/cargos/cadastrar";
    }

    @ModelAttribute("departamentos")
    public List<Departamento> listaDeDepartamentos(){
        return departamentoService.buscarTodos();
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes redirectAttributes){
        if (cargoService.cargoTemFuncionarios(id)){
            redirectAttributes.addFlashAttribute("fail", "Cargo não exluido. Possui funcionário(s) vinculado(s).");
        }else{
            cargoService.excluir(id);
            redirectAttributes.addFlashAttribute("success", "Cargo excluido com sucesso");
        }
        return "redirect:/cargos/listar";
    }

}
