package com.projeto.curso.web.controller;

import com.projeto.curso.Service.CargoService;
import com.projeto.curso.Service.FuncionarioService;
import com.projeto.curso.domain.Cargo;
import com.projeto.curso.domain.Funcionario;
import com.projeto.curso.domain.UF;
import com.projeto.curso.web.validator.FuncionarioValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;
    @Autowired
    private CargoService cargoService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new FuncionarioValidator());
    }

    @GetMapping("/cadastrar")
    public String cadastrar(Funcionario funcionario) {
        return "/funcionario/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("funcionarios", funcionarioService.buscarTodos());
        return "/funcionario/lista";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "/funcionario/cadastro";
        }
        funcionarioService.salvar(funcionario);
        attributes.addFlashAttribute("success", "Funcionario inserido com sucesso!");
        return "redirect:/funcionarios/cadastrar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap modelMap) {
        modelMap.addAttribute("funcionario", funcionarioService.buscarPorId(id));
        return "funcionario/cadastro";
    }

    @PostMapping("/editar")
    public String editar(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "/funcionario/cadastro";
        }
        funcionarioService.editar(funcionario);
        redirectAttributes.addFlashAttribute("success", "Funcionario atualizado com sucesso!");
        return "redirect:/funcionarios/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        funcionarioService.excluir(id);
        redirectAttributes.addFlashAttribute("success", "Funcionario removido com sucesso!");
        return "redirect:/funcionarios/listar";
    }

    @GetMapping("/buscar/nome")
    public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {
        model.addAttribute("funcionarios", funcionarioService.buscarPorNome(nome));
        return "funcionario/lista";
    }

    @GetMapping("/buscar/cargo")
    public String getPorCargo(@RequestParam("id") Long id, ModelMap model) {
        model.addAttribute("funcionarios", funcionarioService.buscarPorCargo(id));
        return "funcionario/lista";
    }

    @GetMapping("/buscar/data")
    public String getPorData(@RequestParam(value = "entrada", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate entrada,
                             @RequestParam(value = "saida", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate saida,
                             ModelMap model) {
        model.addAttribute("funcionarios", funcionarioService.buscarPorData(entrada, saida));
        return "funcionario/lista";
    }


    @ModelAttribute("cargos")
    public List<Cargo> getCargos() {
        return cargoService.buscarTodos();
    }

    @ModelAttribute("ufs")
    public UF[] getUfs() {
        return UF.values();
    }


}
