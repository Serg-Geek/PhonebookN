package org.phonebook;
import java.io.*;

import java.util.ArrayList;
import java.util.logging.Level;


public class FileManager {
    static String FILE_PATH = "./src/org/phonebook/";
    String FILE_NAME_EXPORT = "export.csv";
    String FILE_PATH_FULL = FILE_PATH + FILE_NAME_EXPORT;
    public void fileExport(ArrayList<TBookentry>phonebooks){
        Logging.LOGGER.log(Level.INFO,"Экспорт файла");
        ArrayList<TBookentry>tPhonebooks;
        try(FileWriter writer = new FileWriter(FILE_PATH + FILE_NAME_EXPORT, false))
        {
            for (TBookentry i: phonebooks) {


// запись всей строки
            String text =  i.getName() + ";"+ i.getPhone() + ";"+ i.getAdress()+";"+i.getEmail();
            writer.write(text);
// запись по символам
            writer.append('\n');
//            writer.append('E');

            writer.flush();
                Logging.LOGGER.log(Level.INFO,"Экспорт файла завершен");
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
            Logging.LOGGER.log(Level.WARNING ,"Ошибка записи файла");
        }

    }

    public void ImportFile(ArrayList<TBookentry> phonebooks){
        try {
            File file = new File(FILE_PATH_FULL);
//создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
//создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
// считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
              //  System.out.println(line);// выводит считанныу строки
                String[] tmp = line.split(";");
                phonebooks.add(new TBookentry(tmp[0],tmp[1], tmp[2],tmp[3]));
// считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
