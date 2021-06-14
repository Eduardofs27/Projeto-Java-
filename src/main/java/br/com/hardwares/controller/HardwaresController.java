package br.com.hardwares.controller;


import br.com.hardwares.model.Hardware;
import br.com.hardwares.repository.HardwaresRepository;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class HardwaresController {

    @Autowired
    private HardwaresRepository hardwaresRepository;

    @GetMapping("/gerenciarHardware")
    public String listarHardware(Model model) {
        model.addAttribute("listaHardware", hardwaresRepository.findAll());
        return "gerenciar_hardware";
    }

    @GetMapping("/novoHardware")
    public String novoHardware(Model model) {
        model.addAttribute("hardware", new Hardware());
        return "editar_hardware";
    }

    @GetMapping("/editarHardware/{id}")
    public String editarHardware(@PathVariable("id") long idHardware, Model model) {
        Optional<Hardware> hardware = hardwaresRepository.findById(idHardware);
        model.addAttribute("hardware", hardware.get());
        return "editar_hardware";
    }

    @PostMapping("/salvarHardware")
    public String salvarHardware(Hardware hardware, BindingResult result) {
        if (result.hasErrors()) {
            return "editar_hardware";
        }
        hardwaresRepository.save(hardware);
        return "redirect:/gerenciarHardware";
    }

    @GetMapping("/excluirHardware/{id}")
    public String excluirHardware(@PathVariable("id") long idHardware) {
        hardwaresRepository.deleteById(idHardware);
        return "redirect:/gerenciarHardware";
    }


}