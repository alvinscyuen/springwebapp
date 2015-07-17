package com.springapp.mvc.Person;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    List<Person> personList = new ArrayList<Person>();


    public List<Person> getAll() {

//        Person p1 = new Person();
//        p1.setFirstName("Bruce");
//        p1.setLastName("Yuen");
//
//        Person p2 = new Person();
//        p2.setFirstName("Alvin");
//        p2.setLastName("Yuen");
//
//        List<Person> people = new ArrayList<Person>();
//
//        people.add(p1);
//        people.add(p2);

        return personList;
    }



    public Person randomPerson() {
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Doe");
        return person;
    }



    public String savePerson(Person person) {

        personList.add(person);

        return "person saved: " + person.toString();
    }

}
