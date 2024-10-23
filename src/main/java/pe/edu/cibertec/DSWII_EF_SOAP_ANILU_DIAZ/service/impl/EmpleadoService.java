package pe.edu.cibertec.DSWII_EF_SOAP_ANILU_DIAZ.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DSWII_EF_SOAP_ANILU_DIAZ.exception.NotFoundException;
import pe.edu.cibertec.DSWII_EF_SOAP_ANILU_DIAZ.model.Empleado;
import pe.edu.cibertec.DSWII_EF_SOAP_ANILU_DIAZ.repository.EmpleadoRepository;
import pe.edu.cibertec.DSWII_EF_SOAP_ANILU_DIAZ.service.IEmpleadoService;
import pe.edu.cibertec.DSWII_EF_SOAP_ANILU_DIAZ.util.convert.EmpleadoConvert;
import pe.edu.cibertec.ws.objects.*;

@RequiredArgsConstructor
@Service
public class EmpleadoService implements IEmpleadoService {
    private final EmpleadoRepository empleadoRepository;
    private final EmpleadoConvert empleadoConvert;

    @Override
    public GetEmpleadosResponse listarEmpleados() {
        GetEmpleadosResponse getEmpleadosResponse = new GetEmpleadosResponse();
        getEmpleadosResponse.getEmpleados().addAll(
                empleadoConvert.mapToEmpleadoWsList(empleadoRepository.findAll())
        );
        return getEmpleadosResponse;
    }

    @Override
    public GetEmpleadoResponse obtenerEmpleadoPorId(Integer id) {
        GetEmpleadoResponse empleadoResponse = new GetEmpleadoResponse();
        Empleado empleado = empleadoRepository.findById(id).orElse(null);
        if (empleado == null) {
            throw new NotFoundException("El empleado con Id " + id + " no existe");
        }
        empleadoResponse.setEmpleado(empleadoConvert.mapToEmpleadoWs(empleado));
        return empleadoResponse;
    }

    @Override
    public PostEmpleadoResponse registrarEmpleado(PostEmpleadoRequest request) {
        PostEmpleadoResponse postEmpleadoResponse = new PostEmpleadoResponse();
        Empleado nuevoEmpleado = empleadoRepository.save(
                empleadoConvert.mapToEmpleado(request.getEmpleado())
        );
        postEmpleadoResponse.setEmpleado(empleadoConvert.mapToEmpleadoWs(nuevoEmpleado));
        return postEmpleadoResponse;
    }

    @Override
    public ActuEmpleadoResponse actualizarEmpleado(ActuEmpleadoRequest request) {
        ActuEmpleadoResponse actuEmpleadoResponse = new ActuEmpleadoResponse();
        Empleado empleado = empleadoRepository.findById(request.getEmpleado().getId()).orElse(null);
        if (empleado == null) {
            throw new NotFoundException("El empleado con Id " + request.getEmpleado().getId() + " no existe");
        }
        empleado.setNombre(request.getEmpleado().getNombre());
        empleado.setPuesto(request.getEmpleado().getPuesto());
        empleado.setTelefono(request.getEmpleado().getTelefono());
        empleado.setEmail(request.getEmpleado().getEmail());
        empleadoRepository.save(empleado);
        actuEmpleadoResponse.setEmpleado(empleadoConvert.mapToEmpleadoWs(empleado));

        return actuEmpleadoResponse;
    }
}
