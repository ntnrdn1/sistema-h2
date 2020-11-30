package sistemahs.com.br.sistema;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;




@Controller

public class ComprasController {

    @Autowired
    ComprasRepository comprasRepository;

    @GetMapping(value="/cadastro-compras")
    public ModelAndView getCompras() {
        Compras compras = new Compras();
        ModelAndView modelAndView = new ModelAndView("cadastro-compras");
        modelAndView.addObject("compras", compras);
        return modelAndView;
    }
 

    @PostMapping(value="/adicionar-compras")
    public String postAdicionarCompras(Compras compras) {
        comprasRepository.save(compras);
        return "redirect:/lista-compras";
    }

    @GetMapping(value="/lista-compras")
    public ModelAndView getListaCompra() {
        List <Compras> listaCompra = comprasRepository.findAll();

        ModelAndView modelAndView = new ModelAndView("lista-compras");
        modelAndView.addObject("listaCompra", listaCompra);
        return modelAndView;
    }

    @GetMapping(value="/detalhes-compras/{id}")
    public ModelAndView getMostrarPorIdCompras(@PathVariable Long id) {

        Compras compras = comprasRepository.findById(id).get();

        ModelAndView modelAndView = new ModelAndView("detalhes-compras");
        modelAndView.addObject("compras", compras);

        return modelAndView;
    }

    @GetMapping(value="/deletarcompras/{id}")
    public String getDeletarPorIdCompras(@PathVariable Long id) {
        
        comprasRepository.deleteById(id);

        return "redirect:/lista-compras";
    }

    @GetMapping(value="/editarcompras/{id}")
    public ModelAndView getEditarPorIdCompras(@PathVariable Long id) {
        Compras compras = comprasRepository.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("cadastro-compras");
        modelAndView.addObject("compras", compras);
        return modelAndView;
    }


}
