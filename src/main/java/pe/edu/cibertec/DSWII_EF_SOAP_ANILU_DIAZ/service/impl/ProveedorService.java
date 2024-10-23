package pe.edu.cibertec.DSWII_EF_SOAP_ANILU_DIAZ.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DSWII_EF_SOAP_ANILU_DIAZ.exception.NotFoundException;
import pe.edu.cibertec.DSWII_EF_SOAP_ANILU_DIAZ.model.Proveedor;
import pe.edu.cibertec.DSWII_EF_SOAP_ANILU_DIAZ.repository.ProveedorRepository;
import pe.edu.cibertec.DSWII_EF_SOAP_ANILU_DIAZ.service.IProveedorService;
import pe.edu.cibertec.DSWII_EF_SOAP_ANILU_DIAZ.util.convert.ProveedorConvert;
import pe.edu.cibertec.ws.objects.*;

@RequiredArgsConstructor
@Service
public class ProveedorService implements IProveedorService {
    private final ProveedorRepository proveedorRepository;
    private final ProveedorConvert proveedorConvert;

    @Override
    public GetProveedoresResponse listarProveedores() {
        GetProveedoresResponse getProveedoresResponse = new GetProveedoresResponse();
        getProveedoresResponse.getProveedores().addAll(
                proveedorConvert.mapToProveedorwsList(proveedorRepository.findAll())
        );
        return getProveedoresResponse;
    }

    @Override
    public GetProveedorResponse obtenerProveedorPorId(Integer id) {
        GetProveedorResponse proveedorResponse = new GetProveedorResponse();
        Proveedor proveedor = proveedorRepository.findById(id).orElse(null);
        if (proveedor == null) {
            throw new NotFoundException("El proveedor con Id " + id + " no existe");
        }
        proveedorResponse.setProveedor(proveedorConvert.mapToProveedorws(proveedor));
        return proveedorResponse;
    }

    @Override
    public PostProveedorResponse registrarProveedor(PostProveedorRequest request) {
        PostProveedorResponse postProveedorResponse = new PostProveedorResponse();
        Proveedor nuevoProveedor = proveedorRepository.save(
                proveedorConvert.mapToProveedor(request.getProveedor())
        );
        postProveedorResponse.setProveedor(proveedorConvert.mapToProveedorws(nuevoProveedor));
        return postProveedorResponse;
    }

    @Override
    public ActuProveedorResponse actualizarProveedor(ActuProveedorRequest request) {
        ActuProveedorResponse actuProveedorResponse = new ActuProveedorResponse();
        Proveedor proveedor = proveedorRepository.findById(request.getProveedor().getId()).orElse(null);
        if (proveedor == null) {
            throw new NotFoundException("El proveedor con Id " + request.getProveedor().getId() + " no existe");
        }
        proveedor.setNombreProveedor(request.getProveedor().getNombreProveedor());
        proveedor.setTipoServicio(request.getProveedor().getTipoServicio());
        proveedor.setContacto(request.getProveedor().getContacto());
        proveedor.setEmail(request.getProveedor().getEmail());
        proveedorRepository.save(proveedor);
        actuProveedorResponse.setProveedor(proveedorConvert.mapToProveedorws(proveedor));

        return actuProveedorResponse;
    }
}