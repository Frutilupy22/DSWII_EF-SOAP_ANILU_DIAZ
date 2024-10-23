package pe.edu.cibertec.DSWII_EF_SOAP_ANILU_DIAZ.util.convert;

import org.springframework.stereotype.Component;
import pe.edu.cibertec.DSWII_EF_SOAP_ANILU_DIAZ.model.Empleado;
import pe.edu.cibertec.ws.objects.Empleadow;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmpleadoConvert {
    public Empleado mapToEmpleado(Empleadow empleadoWs) {
        Empleado empleado = new Empleado();
        empleado.setId(empleadoWs.getId());
        empleado.setNombre(empleadoWs.getNombre());
        empleado.setPuesto(empleadoWs.getPuesto());
        empleado.setTelefono(empleadoWs.getTelefono());
        empleado.setEmail(empleadoWs.getEmail());
        return empleado;
    }

    public Empleadow mapToEmpleadoWs(Empleado empleado) {
        Empleadow empleadow = new Empleadow();
        empleadow.setId(empleado.getId());
        empleadow.setNombre(empleado.getNombre());
        empleadow.setPuesto(empleado.getPuesto());
        empleadow.setTelefono(empleado.getTelefono());
        empleadow.setEmail(empleado.getEmail());
        return empleadow;
    }

    public List<Empleado> mapToEmpleadoList(List<Empleadow> empleadowList) {
        List<Empleado> empleadoList = new ArrayList<>();
        for (Empleadow empleadow : empleadowList) {
            empleadoList.add(mapToEmpleado(empleadow));
        }
        return empleadoList;
    }

    public List<Empleadow> mapToEmpleadoWsList(List<Empleado> empleadoList) {
        List<Empleadow> empleadoWsList = new ArrayList<>();
        for (Empleado empleado : empleadoList) {
            empleadoWsList.add(mapToEmpleadoWs(empleado));
        }
        return empleadoWsList;
    }
}
