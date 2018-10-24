package app.exam.parser;

import org.springframework.stereotype.Component;
import app.exam.parser.interfaces.Parser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component(value = "XMLParser")
public class XMLParser implements Parser {

    private JAXBContext jaxbContext;

    @Override
    public <T> T read(Class<T> objectClass, String fileContent) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(objectClass);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        //Set adapter for date parsing
        unmarshaller.setAdapter(new DateTimeAdapter());

        T t = (T)unmarshaller.unmarshal(new StringReader(fileContent));
        return t;
    }

    @Override
    public <T> String write(T object) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter writer = new StringWriter();
        marshaller.marshal(object, writer);
        return writer.toString();
    }

    /** Creating the Adapter.class with our DateFormat */
    public class DateTimeAdapter extends XmlAdapter<String, Date> {
        private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        @Override
        public Date unmarshal(String v) throws Exception {
            return this.sdf.parse(v);
        }

        @Override
        public String marshal(Date v) throws Exception {
            return this.sdf.format(v);
        }
    }
}
