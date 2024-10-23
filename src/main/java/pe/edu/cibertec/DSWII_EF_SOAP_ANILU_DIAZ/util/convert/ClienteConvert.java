package pe.edu.cibertec.DSWII_EF_SOAP_ANILU_DIAZ.util.convert;

import org.springframework.stereotype.Component;
import pe.edu.cibertec.DSWII_EF_SOAP_ANILU_DIAZ.model.Cliente;
import pe.edu.cibertec.ws.objects.Clientews;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClienteConvert {

   public Cliente maptToCliente(Clientews clientews){
      Cliente cliente = new Cliente();
      cliente.setId(clientews.getId());
      cliente.setNombre(clientews.getNombre());
      cliente.setEmail(clientews.getEmail());
      cliente.setTelefono(clientews.getTelefono());
      cliente.setDireccion(clientews.getDireccion());
      return cliente;
   }

   public Clientews maptToClientews(Cliente cliente){
      Clientews clientews = new Clientews();
      clientews.setId(cliente.getId());
      clientews.setNombre(cliente.getNombre());
      clientews.setEmail(cliente.getEmail());
      clientews.setTelefono(cliente.getTelefono());
      clientews.setDireccion(cliente.getDireccion());
      return clientews;
   }

   public List<Cliente> mapToClienteList(List<Clientews> clientewsList){
      List<Cliente> clienteList = new ArrayList<>();
      for (Clientews clientews : clientewsList){
         clienteList.add(maptToCliente(clientews));
      }
      return clienteList;
   }

   public List<Clientews> mapToClientewsList(List<Cliente> clienteList){
      List<Clientews> clientewsList = new ArrayList<>();
      for (Cliente cliente : clienteList){
         clientewsList.add(maptToClientews(cliente));
      }
      return clientewsList;
   }


}
