package pe.edu.cibertec.DSWII_EF_SOAP_ANILU_DIAZ.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DSWII_EF_SOAP_ANILU_DIAZ.exception.NotFoundException;
import pe.edu.cibertec.DSWII_EF_SOAP_ANILU_DIAZ.model.Cliente;
import pe.edu.cibertec.DSWII_EF_SOAP_ANILU_DIAZ.repository.ClienteRepository;
import pe.edu.cibertec.DSWII_EF_SOAP_ANILU_DIAZ.service.IClienteService;
import pe.edu.cibertec.DSWII_EF_SOAP_ANILU_DIAZ.util.convert.ClienteConvert;
import pe.edu.cibertec.ws.objects.*;

@RequiredArgsConstructor
@Service
public class ClienteService implements IClienteService {
    private final ClienteRepository clienteRepository;
    private final ClienteConvert clienteConvert;

    @Override
    public GetClientesResponse listarClientes() {
        GetClientesResponse getClientesResponse = new GetClientesResponse();
        getClientesResponse.getClientes().addAll(
            clienteConvert.mapToClientewsList(clienteRepository.findAll())
        );
        return getClientesResponse;
    }

    @Override
    public GetClienteResponse obtenerClientePorId(Integer id) {
        GetClienteResponse clienteResponse = new GetClienteResponse();
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente == null){
            throw new NotFoundException("El cliente con Id " + id+" no existe");
        }
        clienteResponse.setCliente(
                clienteConvert.maptToClientews(cliente));
        return clienteResponse;
    }

    @Override
    public PostClienteResponse registrarCliente(PostClienteRequest request) {
            PostClienteResponse postClienteResponse = new PostClienteResponse();
            Cliente nuevoCliente = clienteRepository.save(
                    clienteConvert.maptToCliente(request.getCliente())
            );
            postClienteResponse.setCliente(
                    clienteConvert.maptToClientews(nuevoCliente));
        return postClienteResponse;
    }
    @Override
    public ActuClienteResponse actualizarCliente(ActuClienteRequest request) {
        ActuClienteResponse actuClienteResponse = new ActuClienteResponse();
        Cliente cliente = clienteRepository.findById(request.getCliente().getId()).orElse(null);
        if (cliente == null) {
            throw new NotFoundException("El cliente con Id " + request.getCliente().getId() + " no existe");
        }
        cliente.setNombre(request.getCliente().getNombre());
        cliente.setEmail(request.getCliente().getEmail());
        cliente.setTelefono(request.getCliente().getTelefono());
        cliente.setDireccion(request.getCliente().getDireccion());
        clienteRepository.save(cliente);
        actuClienteResponse.setCliente(clienteConvert.maptToClientews(cliente));

        return actuClienteResponse;
    }
}
