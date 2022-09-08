package Persons;
//L-принцип замены Барбары Лисков(Liskov Substitution Principle)
// Наследуй только тогда, когда можешь играть роль за предка
// Не уверен насчет того, что этот принцип здесь соблюдается,
// но от этого абстрактного класса наследуются все персонажи данной программы
public abstract class Human {
    protected final String name;
    protected final String lastName;
    protected String eMail;
    protected String phoneNumber;


    public Human(String name, String lastName, String eMail, String phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
    }
}
