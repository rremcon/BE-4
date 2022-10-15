import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String middleName;
    private String lastName;
    private char sex;
    private int age;
    private Person mother;
    private Person father;
    private List<Person> siblings;
    private List<Person> children;
    private List<Pet> pets;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public List<Person> getSiblings() {
        return siblings;
    }

    public void setSiblings(List<Person> siblings) {
        this.siblings = siblings;
    }
    public List<Person> getChildren() {
        return children;
    }
    public void setChildren(List<Person> children) {
        this.children = children;
    }
    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }


    public Person(String name, String lastName, char sex, int age) {
        this.name = name;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
    }


    public Person(String name, String middleName, String lastName, char sex, int age) {
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
    }


    public void addParents(Person father, Person mother, Person child) {
        child.setMother(mother);
        mother.addChild(mother, child);
        child.setFather(father);
        father.addChild(father, child);
    }

    public void addChild(Person parent, Person child) {
        List<Person> children = new ArrayList<>();
        if (parent.getChildren() != null) {
            for (Person person : parent.getChildren()) {
                children.add(child);
            }
        } else {
            children.add(child);
        }
        parent.setChildren(children);
    }

        public void addPet(Person owner, Pet pet) {
            List<Pet> pets = new ArrayList<>();
            if (owner.getPets() != null) {
                for (Pet p : owner.getPets()) {
                    pets.add(pet);
                }
            }
        }

        public void addSibling(Person person, Person sibling) {
            List<Person> family = new ArrayList<>();
            if(this.getSiblings() != null) {
                for (Person people : person.getSiblings()) {
                    family.add(people);
                }
            }
            family.add(sibling);
            person.setSiblings(family);
        }


        public List<Person> getGrandChildren() {
            List<Person> grandChildren = new ArrayList<>();
            if(this.getChildren() !=null) {
                for (Person children : this.getChildren()) {
                    if(children.getChildren() !=null) {
                        for (Person grandKid : children.getChildren()) {
                            grandChildren.add(grandKid);
                        }
                    }
                }
            }
            return grandChildren;
        }

    }


