package pe.edu.cibertec.DSWII_EF_SOAP_ANILU_DIAZ.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.DSWII_EF_SOAP_ANILU_DIAZ.model.Cliente;

@Repository
public interface ClienteRepository
        extends JpaRepository<Cliente, Integer> {
}
