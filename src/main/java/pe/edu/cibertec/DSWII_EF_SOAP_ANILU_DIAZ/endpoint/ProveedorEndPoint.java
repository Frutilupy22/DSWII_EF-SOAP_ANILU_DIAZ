package pe.edu.cibertec.DSWII_EF_SOAP_ANILU_DIAZ.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.edu.cibertec.DSWII_EF_SOAP_ANILU_DIAZ.service.IProveedorService;
import pe.edu.cibertec.ws.objects.*;

@Endpoint
public class ProveedorEndPoint {
    private static final String NAMESPACE_URI = "http://www.cibertec.edu.pe/ws/objects";

    @Autowired
    private IProveedorService proveedorService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProveedoresRequest")
    @ResponsePayload
    public GetProveedoresResponse getProveedores(@RequestPayload GetProveedoresRequest request) {
        return proveedorService.listarProveedores();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProveedorRequest")
    @ResponsePayload
    public GetProveedorResponse getProveedorPorId(@RequestPayload GetProveedorRequest request) {
        return proveedorService.obtenerProveedorPorId(request.getId());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postProveedorRequest")
    @ResponsePayload
    public PostProveedorResponse saveProveedor(@RequestPayload PostProveedorRequest request) {
        return proveedorService.registrarProveedor(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "actuProveedorRequest")
    @ResponsePayload
    public ActuProveedorResponse updateProveedor(@RequestPayload ActuProveedorRequest request) {
        return proveedorService.actualizarProveedor(request);
    }
}
