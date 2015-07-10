package com.springapp.mvc.Person;

import java.util.List;

public interface PersonService {

    List<Person> getAll();

    Person randomPerson();

    String savePerson(Person person);
}
