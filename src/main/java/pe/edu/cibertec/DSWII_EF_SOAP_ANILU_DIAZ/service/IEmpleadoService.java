package pe.edu.cibertec.DSWII_EF_SOAP_ANILU_DIAZ.service;

import pe.edu.cibertec.ws.objects.*;

public interface IEmpleadoService {
    GetEmpleadosResponse listarEmpleados();

    GetEmpleadoResponse obtenerEmpleadoPorId(Integer id);

    PostEmpleadoResponse registrarEmpleado(PostEmpleadoRequest request);

    ActuEmpleadoResponse actualizarEmpleado(ActuEmpleadoRequest request);
}
