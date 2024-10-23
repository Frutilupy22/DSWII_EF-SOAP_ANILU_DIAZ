package pe.edu.cibertec.DSWII_EF_SOAP_ANILU_DIAZ.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
public class EmpleadoWsdlConfig {
    @Bean(name = "empleados")
    public DefaultWsdl11Definition empleadoWsdl11Definition(XsdSchema empleadoEsquema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("EmpleadosPort");
        wsdl11Definition.setLocationUri("/ws/empleados");
        wsdl11Definition.setTargetNamespace("http://www.cibertec.edu.pe/ws/objects");
        wsdl11Definition.setSchema(empleadoEsquema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema empleadoEsquema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/empleado.xsd"));
    }
}
