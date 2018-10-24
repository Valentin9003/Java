package com.example.automapping.util;

import com.example.automapping.dto.EmployeeDto;
import com.example.automapping.model.Employee;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.ArrayList;
import java.util.List;

public class DtoConvertUtil {

    private static ModelMapper mapper = new ModelMapper();

    public DtoConvertUtil() {
    }

    public static <S, D> D convert(S source, Class<D> destinationClass) {
        return mapper.map(source, destinationClass);
    }

    public static <S, D> List<D> convert(Iterable<S> source, Class<D> destinationClass) {
        List<D> resultList = new ArrayList<>();
        for (S s : source) {
            D d = convert(s, destinationClass);
            resultList.add(d);
        }
        return resultList;
    }

//    public static EmployeeDto convertWithConfig(Employee source, Class<EmployeeDto> destinationClass) {
//        PropertyMap<Employee, EmployeeDto> propMap = new PropertyMap<Employee, EmployeeDto>() {
//            @Override
//            protected void configure() {
//                map().setManagerLastName(source.getManager().getLastName());
//            }
//        };
//        mapper.addMappings(propMap);
//        return mapper.map(source, destinationClass);
//    }

    public static List<EmployeeDto> convertEmployeeList(List<Employee> source, Class<EmployeeDto> destination) {
        PropertyMap<Employee, EmployeeDto> propMap = new PropertyMap<Employee, EmployeeDto>() {
            @Override
            protected void configure() {
                map().setManagerLastName(source.getManager().getLastName());
            }
        };
        mapper.addMappings(propMap);

        List<EmployeeDto> resultList = new ArrayList<>();
        for (Employee empl : source) {
            EmployeeDto d = convert(empl, destination);
            resultList.add(d);
        }
        return resultList;
    }

}
