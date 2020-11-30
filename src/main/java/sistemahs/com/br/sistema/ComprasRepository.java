package sistemahs.com.br.sistema;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ComprasRepository extends CrudRepository <Compras, Long> {

    List<Compras> findAll();
    
}
