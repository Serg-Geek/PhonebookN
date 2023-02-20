package org.phonebook;

import java.util.ArrayList;

public class TBook {
    public static ArrayList<TBookentry> bookentries = new ArrayList<>();
    public static void addEntry(TBookentry bookentry) {
        bookentries.add(bookentry);
    }
    public void searchEntry( ) {
        String name = Menu.getString1(Menu.validType.vtNone);
        for (TBookentry i : bookentries) {
            if ( i.Name.equals(name) ){
                System.out.println(i.getName() + " " + i.getPhone() + " " + i.getAdress() + " " +i.getEmail());
                break;
            }else{
                System.out.println(" not found ");
            }
        }
    }
    public void TBook() {

    }

    public void showBook() {
        for (TBookentry i : bookentries) {
            System.out.println(i.getName() + " " + i.getPhone() + " " + i.getAdress()+  " " + i.getEmail());
        }
    }
}
