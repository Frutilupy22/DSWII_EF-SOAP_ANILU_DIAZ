package pe.edu.cibertec.DSWII_EF_SOAP_ANILU_DIAZ.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.edu.cibertec.DSWII_EF_SOAP_ANILU_DIAZ.service.IEmpleadoService;
import pe.edu.cibertec.ws.objects.*;

@Endpoint
public class EmpleadoEndPoint {
    private static final String NAMESPACE_URI = "http://www.cibertec.edu.pe/ws/objects";

    @Autowired
    private IEmpleadoService empleadoService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmpleadosRequest")
    @ResponsePayload
    public GetEmpleadosResponse getEmpleados(@RequestPayload GetEmpleadosRequest request) {
        return empleadoService.listarEmpleados();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmpleadoRequest")
    @ResponsePayload
    public GetEmpleadoResponse getEmpleadoPorId(@RequestPayload GetEmpleadoRequest request) {
        return empleadoService.obtenerEmpleadoPorId(request.getId());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postEmpleadoRequest")
    @ResponsePayload
    public PostEmpleadoResponse saveEmpleado(@RequestPayload PostEmpleadoRequest request) {
        return empleadoService.registrarEmpleado(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "actuEmpleadoRequest")
    @ResponsePayload
    public ActuEmpleadoResponse updateEmpleado(@RequestPayload ActuEmpleadoRequest request) {
        return empleadoService.actualizarEmpleado(request);
    }
}
