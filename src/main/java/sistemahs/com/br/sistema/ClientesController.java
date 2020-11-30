package sistemahs.com.br.sistema;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;




@Controller

public class ClientesController {

    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping(value="/cadastro-clientes")
    public ModelAndView getCadastro() {
        Cliente cliente = new Cliente();
        ModelAndView modelAndView = new ModelAndView("cadastro-clientes");
        modelAndView.addObject("cliente", cliente);
        return modelAndView;
    }
 
    @GetMapping(value="/lista-clientes")
    public ModelAndView getListaClientes() {
        List <Cliente> listaClientes = clienteRepository.findAll();

        ModelAndView modelAndView = new ModelAndView("lista-clientes");
        modelAndView.addObject("listaClientes", listaClientes);
        return modelAndView;
    }


    @GetMapping(value="/detalhes-clientes/{id}")
    public ModelAndView getMostrarPorId(@PathVariable Long id) {

        Cliente cliente = clienteRepository.findById(id).get();

        ModelAndView modelAndView = new ModelAndView("detalhes-clientes");
        modelAndView.addObject("cliente", cliente);

        return modelAndView;
    }
    


    @GetMapping(value="/deletarcliente/{id}")
    public String getDeletarPorId(@PathVariable Long id) {
        
        clienteRepository.deleteById(id);

        return "redirect:/lista-clientes";
    }

    @GetMapping(value="/editarcliente/{id}")
    public ModelAndView getEditarPorId(@PathVariable Long id) {
        Cliente cliente = clienteRepository.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("cadastro-clientes");
        modelAndView.addObject("cliente", cliente);
        return modelAndView;
    }


    

    @PostMapping(value="/adicionar-clientes")
    public String postAdicionarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
        return "redirect:/lista-clientes";
    }
    
}
