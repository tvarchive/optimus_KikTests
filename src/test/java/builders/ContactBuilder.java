package builders;


import entities.Contact;

public class ContactBuilder{

    private Contact contact;

    public ContactBuilder() {
        contact = new Contact();
        contact.setName("Mayank");
    }

    public ContactBuilder withName(String name){
        contact.setName(name);
        return this;
    }

    public Contact build(){
        return contact;
    }
}
