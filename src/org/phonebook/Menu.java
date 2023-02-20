package org.phonebook;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {
    public enum validType{vtNone, vtEmail};
    public static void mainMenu() {
        int input;
        do {
            Scanner in = new Scanner(System.in);
            System.out.println("1 - Отобразить справочник");
            System.out.println("2 - Выгрузить данные ");
            System.out.println("3 - Загрузить данные");
            System.out.println("4 - AddEntry");
            System.out.println("7 - search person");
            System.out.println("0 - EXIT");
            System.out.println(" - ".repeat(15));

            input = in.nextInt();
            FileManager run = new FileManager();
            TBook phones = new TBook();
            phones.TBook();
            switch (input) {
                case 1:
                    phones.showBook();
                    break;

                case 2:
                    phones.TBook();
                    run.fileExport(phones.bookentries);
                    System.out.println("Export finish");
                    break;

                case 3:
                    phones.TBook();
                    run.ImportFile(phones.bookentries);
                    phones.showBook();
                    break;
                case 4:
                    phones.TBook();
                    System.out.println(" Input FIO");
                    String fio = getString1(validType.vtNone);

                    System.out.println("Input Phone");
                    String phone= getString1(validType.vtNone);
                    System.out.println("Input adress");
                    String adress = getString1(validType.vtNone);
                    System.out.println("Input EMAIL (в формате *******@****.**)");
                    String email= getString1(validType.vtEmail);
                    TBook.addEntry(new TBookentry(fio, phone,adress,email));
                    break;
                  case 7:
                    System.out.println(" Input FIO");
                    phones.searchEntry();
                    break;
            }
        } while (input != 0);
    }

    public static String getString1(validType vt) {
        while (true) {
            Scanner in = new Scanner(System.in);
            String str = in.next();
            if (str.equals("")){
                return str;
            }
            if (vt == validType.vtEmail) {
                Pattern pattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
                Matcher matcher = pattern.matcher(str);
                if (matcher.find()){
                    return str;
                }
            }else{
                return str;
            }
        }
    }

}
