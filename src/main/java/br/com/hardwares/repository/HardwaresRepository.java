
package br.com.hardwares.repository;

import br.com.hardwares.model.Hardware;
import org.springframework.data.repository.CrudRepository;

public interface HardwaresRepository extends CrudRepository<Hardware,Long>{
    
}
