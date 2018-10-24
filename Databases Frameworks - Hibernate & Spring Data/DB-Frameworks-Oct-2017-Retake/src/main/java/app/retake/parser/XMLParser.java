package app.retake.parser;

import app.retake.parser.interfaces.Parser;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component(value = "XMLParser")
public class XMLParser implements Parser {

    private JAXBContext jaxbContext;

    @Override
    public <T> T read(Class<T> objectClass, String fileContent) throws IOException, JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(objectClass);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        /** Adapter Is for parsing date and with the adapter.class which we create down
         * After create this Adapter.class, we need to setAdapter(new adapter.class) on the unmarshaller.
         * And DON'T FORGOT - Then you use the
         * @XmlJavaTypeAdapter(XMLParser.DateTimeAdapter.class)
         * annotation in our models  to specify that the XmlAdapter should be used for a specific field/property.
         * - on the field where we want the Date to be parse */
        unmarshaller.setAdapter(new DateTimeAdapter());

        T t = (T)unmarshaller.unmarshal(new StringReader(fileContent));
        return t;
    }

    @Override
    public <T> String write(T object) throws IOException, JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter writer = new StringWriter();
        marshaller.marshal(object, writer);
        return writer.toString();
    }


    //Do not watching here :))
    /** Creating the Adapter.class with our DateFormat */
    public class DateTimeAdapter extends XmlAdapter<String, Date> {
        private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

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
