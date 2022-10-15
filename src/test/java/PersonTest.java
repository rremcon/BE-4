import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

class PersonTest {

    @Test
    void addParents() {
//        Arrange
        Person person1 = new Person("Piet", "Pietersen", 'M', 34);
        Person person2 = new Person("Jan", "Pietersen", 'M', 64);
        Person person3 = new Person("Hannah", "van der", "Plassen", 'F', 62);

//        Act
        person1.addParents(person2, person3, person1);
        Person mother = person1.getMother();
        Person father = person1.getFather();

//        Assert
        assertEquals(person2, father);
        assertEquals(person3, mother);

    }

    @Test
    void addChild() {
        //arange
        Person parent = new Person("Willem ", "Verwant ", 'M', 43);
        Person child = new Person("Junior", "Luipers", 'M', 15);
        List<Person> children = new ArrayList<>();
        children.add(child);

        //act
        parent.addChild(parent, child);
        List<Person> kids = parent.getChildren();

        //assert
        assertEquals(children, kids);
        assertEquals("Junior", parent.getChildren().get(0).getName());
        assertEquals("Verwant", parent.getChildren().get(0).getLastName());
    }


    @Test
    void addPet() {
//        Arrange
        Person person2 = new Person("Jan", "Pietersen", 'M', 64);
        Pet dog = new Pet("Luna", 3, "dogs");
        Pet cat = new Pet("Minoes", 4, "cats");
        List<Pet> pets = new ArrayList<>();
        pets.add(cat);
        pets.add(dog);
        person2.addPet(person2, cat);

//        Act
        person2.addPet(person2,dog);

//        Assert
        assertEquals(pets, person2.getPets());
    }


    @Test
    void addSibling() {
//      Arrange
        List<Person> sibblings = new ArrayList<>();
        Person person1 = new Person("Piet", "Pietersen", 'M', 34);
        Person person2 = new Person("Jade", "Pietersen", 'F', 22);
        Person person3 = new Person("Marie", "Pietersen", 'F', 22);
        sibblings.add(person3);
        sibblings.add(person2);
        person1.addSibling(person1, person3);

//        Act
        person1.addSibling(person1, person2);

//        Assert
        assertEquals(sibblings, person1.getSiblings());
    }

    @Test
    void getGrandChildren() {
        //        Arrange
        List<Person> grandChildren = new ArrayList<>();
        Person person1 = new Person("Jay Jay", "Pietersen", 'F', 3);
        Person person2 = new Person("James", "Pietersen", 'M', 22);
        Person person3 = new Person("Jan", "Pietersen", 'M', 64);
        grandChildren.add(person1);

//        Act
        person2.addChild(person2, person1);
        person3.addChild(person3, person2);
        List<Person> list = person3.getGrandChildren();

//        Assert
        assertEquals(grandChildren, list);

    }
}

