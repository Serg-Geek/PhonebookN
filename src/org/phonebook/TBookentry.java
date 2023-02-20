package org.phonebook;

public class TBookentry {
    String Name;
    String Phone;
    String Adress;
    String Email;


    public TBookentry(String name, String phone, String adress, String email) {
        this.Name = name;
        this.Phone = phone;
        this.Adress = adress;
        this.Email = email;

    }

    public void setName(String name) {
        Name = name;

    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }
public void setEmail (String email){
        Email= email;

}


    public String getName() {
        return Name;
    }

    public String getPhone() {
        return Phone;

    }

    public String getAdress() {
        return Adress;
    }
    public String getEmail(){
        return Email;
    }
}
