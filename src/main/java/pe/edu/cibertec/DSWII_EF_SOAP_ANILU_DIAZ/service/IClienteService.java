package pe.edu.cibertec.DSWII_EF_SOAP_ANILU_DIAZ.service;

import pe.edu.cibertec.ws.objects.*;

public interface IClienteService {
    GetClientesResponse listarClientes();

    GetClienteResponse obtenerClientePorId(Integer id);

    PostClienteResponse registrarCliente(PostClienteRequest request);
    ActuClienteResponse actualizarCliente(ActuClienteRequest request);
}
