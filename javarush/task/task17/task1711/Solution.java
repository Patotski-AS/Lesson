package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
CRUD 2

CrUD Batch - multiple Creation, Updates, Deletion.

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...

Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u - обновляет соответствующие данные людей с заданными id
-d - производит логическое удаление человека с id, заменяет все его данные на null
-i - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке.
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople.
Порядок вывода данных соответствует вводу данных.
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных).
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat.

Пример вывода для параметра -і с двумя id:
Миронов м 15-Apr-1990
Миронова ж 25-Apr-1997
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {

        switch (args[0]) {
            case "-c":
                synchronized (allPeople){
                // с - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
                //-c name1 sex1 bd1 name2 sex2 bd2 ...
                int c = 1;
                while (args[c] != null || c> allPeople.size()) {
                    if (args[c + 1].equals("м")) {
                        allPeople.add(Person.createMale(args[c], new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[c + 2])));
                    } else {
                        allPeople.add(Person.createFemale(args[c], new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[c + 2])));
                    }
                    System.out.println(allPeople.size() - 1);
                    c = c +3;
                }

                break;}
            case "-u":
                synchronized (allPeople){

                    // -u - обновляет соответствующие данные людей с заданными id
                //-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
                int u = 1;
                while (args[u] != null) {
                    allPeople.get(Integer.parseInt(args[u])).setName(args[u + 1]);
                    if (args[u + 2].equals("м")) {
                        allPeople.get(Integer.parseInt(args[u])).setSex(Sex.MALE);
                    } else {
                        allPeople.get(Integer.parseInt(args[u])).setSex(Sex.FEMALE);
                    }
                    allPeople.get(Integer.parseInt(args[u])).setBirthDate(new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[u + 3]));
                    u =u+4;
                }}
                break;
            case "-d":
                synchronized (allPeople){
                    // -d - производит логическое удаление человека с id, заменяет все его данные на null
                //-d id1 id2 id3 id4 ...
                int d = 1;
                while (args[d] != null) {
                    allPeople.get(Integer.parseInt(args[d])).setName(null);
                    allPeople.get(Integer.parseInt(args[d])).setSex(null);
                    allPeople.get(Integer.parseInt(args[d])).setBirthDate(null);
                    d =d+1;
                }}
                break;
            case "-i":
                synchronized (allPeople){
                    // -i - выводит на экран информацию о всех людях с заданными id: name sex bd
               //-i id1 id2 id3 id4 ...
               // Пример вывода для параметра -і с двумя id:
               // Миронов м 15-Apr-1990
               // Миронова ж 25-Apr-1997
                int i=1;
                while (args[i] != null) {
                    Person person = allPeople.get(Integer.parseInt(args[i]));
                    String sex = null;
                    if (person.getSex().equals(Sex.MALE))
                        sex = "м";
                    else if (person.getSex().equals(Sex.FEMALE))
                        sex = "ж";
                    System.out.println(person.getName() + " " + sex + " " + new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(person.getBirthDate()));
                    i=i+1;
                }}
                break;
        }

        //start here - начни тут
    }
}






























