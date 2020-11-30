package sistemahs.com.br.sistema;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;






@Controller

public class PrincipalController {

    @Autowired
    ClienteRepository clienteRepository;
    ComprasRepository comprasRepository;

    @GetMapping(value="/")
    public ModelAndView getIndex(){
        
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;

    }



}
