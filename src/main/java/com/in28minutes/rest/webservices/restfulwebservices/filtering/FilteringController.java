package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FilteringController {
    @GetMapping(path = "/filtering")
    public MappingJacksonValue filtering() {
        SomeBean someBean = new SomeBean("a", "b", "c");

        return getFilteredMappingJacksonValue(someBean);
    }


    @GetMapping(path = "/filtering-list")
    public MappingJacksonValue filteringList() {
        List<SomeBean> someBeanList = new ArrayList<SomeBean>();
        someBeanList.add(new SomeBean("a", "b", "c"));
        someBeanList.add(new SomeBean("d", "e", "f"));
        someBeanList.add(new SomeBean("g", "h", "i"));

        return getFilteredMappingJacksonValue(someBeanList);
    }

    private MappingJacksonValue getFilteredMappingJacksonValue(Object value, String... propertyArray) {
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(value);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }
}
