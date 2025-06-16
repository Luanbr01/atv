
package poo.atv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import poo.atv.model.Jogos;
import poo.atv.model.jogosService;


@Controller
public class MainController {

    @Autowired
    ApplicationContext ctx;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/formulario")
    public String form(Model model){
        model.addAttribute("jogos", new Jogos());
        model.addAttribute("titulo", "CADASTRO DE JOGOS");
        model.addAttribute("link", "/cadastro");
        model.addAttribute("valor", "Cadastrar");
        return "formulario";
    }

    @GetMapping("/editar/{id}")
    public String editar(Model model, @PathVariable int id){
        jogosService cs = ctx.getBean(jogosService.class);
        Jogos teste = cs.puxarjogos(id);
        model.addAttribute("jogos", teste);
        model.addAttribute("titulo", "EDITAR JOGOS");
        model.addAttribute("link", "/editar/" + id);
        model.addAttribute("valor", "Editar");
        return "formulario";
    }

    @PostMapping("/editar/{id}")
    public String editar(Model model, 
                         @ModelAttribute Jogos jog, 
                         @PathVariable int id){
        jogosService cs = ctx.getBean(jogosService.class);
        cs.atualizarjogos(id, jog);
        return "redirect:/listar";
    }

    @PostMapping("/cadastro")
    public String cadastro(Model model, @ModelAttribute Jogos jog){
        jogosService cs = ctx.getBean(jogosService.class);
        cs.inserirjogos(jog);
        return "redirect:/listar";
    }

    @GetMapping("/listar")
    public String listar(Model model){
        jogosService cs = ctx.getBean(jogosService.class);
        List<Jogos> lista = cs.puxarTodosjogos();
        model.addAttribute("jogos", lista);
        return "listar";
    }

    @PostMapping("/deletar/{id}")
    public String deletar(@PathVariable int id){
        jogosService cs = ctx.getBean(jogosService.class);
        cs.deletar(id);
        return "redirect:/listar";
    }


}
