package pe.edu.cibertec.DSWII_EF_SOAP_ANILU_DIAZ.util.convert;

import org.springframework.stereotype.Component;
import pe.edu.cibertec.DSWII_EF_SOAP_ANILU_DIAZ.model.Proveedor;
import pe.edu.cibertec.ws.objects.Proveedorws;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProveedorConvert {
    public Proveedor mapToProveedor(Proveedorws proveedorws) {
        Proveedor proveedor = new Proveedor();
        proveedor.setId(proveedorws.getId());
        proveedor.setNombreProveedor(proveedorws.getNombreProveedor());
        proveedor.setTipoServicio(proveedorws.getTipoServicio());
        proveedor.setContacto(proveedorws.getContacto());
        proveedor.setEmail(proveedorws.getEmail());
        return proveedor;
    }

    public Proveedorws mapToProveedorws(Proveedor proveedor) {
        Proveedorws proveedorws = new Proveedorws();
        proveedorws.setId(proveedor.getId());
        proveedorws.setNombreProveedor(proveedor.getNombreProveedor());
        proveedorws.setTipoServicio(proveedor.getTipoServicio());
        proveedorws.setContacto(proveedor.getContacto());
        proveedorws.setEmail(proveedor.getEmail());
        return proveedorws;
    }

    public List<Proveedor> mapToProveedorList(List<Proveedorws> proveedorwsList) {
        List<Proveedor> proveedorList = new ArrayList<>();
        for (Proveedorws proveedorws : proveedorwsList) {
            proveedorList.add(mapToProveedor(proveedorws));
        }
        return proveedorList;
    }

    public List<Proveedorws> mapToProveedorwsList(List<Proveedor> proveedorList) {
        List<Proveedorws> proveedorwsList = new ArrayList<>();
        for (Proveedor proveedor : proveedorList) {
            proveedorwsList.add(mapToProveedorws(proveedor));
        }
        return proveedorwsList;
    }
}
