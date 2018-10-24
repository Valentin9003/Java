package json.processing;

import json.processing.model.dto.jsonAndXmlDto.ExportPersonDto;
import json.processing.model.dto.jsonAndXmlDto.PersonDto;
import json.processing.model.dto.jsonAndXmlDto.PersonsWrapperDto;
import json.processing.model.entity.Person;
import json.processing.serialize.Serializer;
import json.processing.serialize.XmlSerializer;
import json.processing.service.personService.PersonService;
import json.processing.util.DtoConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class CmdRunner implements CommandLineRunner {

    private static final String PERSON_INPUT_JSON = "/files/input/json/person.json";
    private static final String PERSONS_INPUT_JSON = "/files/input/json/persons.json";
    private static final String PERSONS_OUTPUT_JSON = "src/main/resources/files/output/jsonAndXmlDto/personsByCountry.jsonAndXmlDto";
    private static final String PERSON_INPUT_XML = "/files/input/xml/person.xml";
    private static final String PERSONS_INPUT_XML = "/files/input/xml/persons.xml";
    private static final String PERSONS_OUTPUT_XML = "src/main/resources/files/output/xml/personsByCountry.xml";

    private final Serializer serializerJson;
    private final Serializer serializerXml;

    private PersonService personService;

    @Autowired
    public CmdRunner(PersonService personService,
                     @Qualifier(value = "XmlSerializer") Serializer serializerXml,
                     @Qualifier(value = "JsonSerializer") Serializer serializerJson) {
        this.personService = personService;
        this.serializerXml = serializerXml;
        this.serializerJson = serializerJson;
    }

    @Override
    public void run(String... args) throws Exception {
        //Json
        importPersonJson();
        importPersonsJson();
        exportPersonByCountry();

        //Xml
        importPersonXml();
        importPersonsXml();
        exportPersonsByCountryXml();
    }

    private void exportPersonsByCountryXml() {
        List<Person> bulgarians = personService.findByCountry("Bulgaria");
        List<PersonDto> bulgarianDtos = DtoConvertUtil.convert(bulgarians, PersonDto.class);
        PersonsWrapperDto wrapperDto = new PersonsWrapperDto();
        wrapperDto.setPersonDtos(bulgarianDtos);
        serializerXml.serialize(wrapperDto, PERSONS_OUTPUT_XML);
    }

    private void importPersonsXml() {
        PersonsWrapperDto personsDto = serializerXml.deserialize(PersonsWrapperDto.class, PERSONS_INPUT_XML);
        List<Person> personsList = DtoConvertUtil.convert(personsDto.getPersonDtos(), Person.class);
        for (Person person : personsList) {
            personService.create(person);
        }
    }

    private void importPersonXml() {
        PersonDto personDto = serializerXml.deserialize(PersonDto.class, PERSON_INPUT_XML);
        Person person = DtoConvertUtil.convert(personDto, Person.class);
        personService.create(person);
    }

    private void exportPersonByCountry() {
        List<Person> bulgarians = personService.findByCountry("Bulgaria");
        List<ExportPersonDto> exportPersonDtos = DtoConvertUtil.convert(bulgarians, ExportPersonDto.class);
        serializerJson.serialize(exportPersonDtos, PERSONS_OUTPUT_JSON);
    }

    private void importPersonsJson() {
        PersonDto[] personDtos = serializerJson.deserialize(PersonDto[].class, PERSONS_INPUT_JSON);
        for (PersonDto personDto : personDtos) {
            importPerson(personDto);
        }
    }

    private void importPersonJson() {
        PersonDto personDto = serializerJson.deserialize(PersonDto.class, PERSON_INPUT_JSON);
        importPerson(personDto);
    }

    private void importPerson(PersonDto personDto) {
        Person person = DtoConvertUtil.convert(personDto, Person.class);
        personService.create(person);
        String debug = "";
    }
}
