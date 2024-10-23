package pe.edu.cibertec.DSWII_EF_SOAP_ANILU_DIAZ.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CUSTOM,
customFaultCode = "{http://www.cibertec.edu.pe/ws}001" )
public class NotFoundException extends RuntimeException {

    public NotFoundException(String message){
        super(message);
    }

}
