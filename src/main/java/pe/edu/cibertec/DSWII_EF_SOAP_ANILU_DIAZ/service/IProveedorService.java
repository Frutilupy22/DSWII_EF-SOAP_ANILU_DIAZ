package pe.edu.cibertec.DSWII_EF_SOAP_ANILU_DIAZ.service;

import pe.edu.cibertec.ws.objects.*;

public interface IProveedorService {
    GetProveedoresResponse listarProveedores();

    GetProveedorResponse obtenerProveedorPorId(Integer id);

    PostProveedorResponse registrarProveedor(PostProveedorRequest request);

    ActuProveedorResponse actualizarProveedor(ActuProveedorRequest request);
}
