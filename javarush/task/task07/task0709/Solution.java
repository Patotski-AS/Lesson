package com.javarush.task.task07.task0709;

//1. Создай список строк.
//2. Считай с клавиатуры 5 строк и добавь в список.
//3. Используя цикл, найди самую короткую строку в списке.
//4. Выведи найденную строку на экран.
//5. Если таких строк несколько, выведи каждую с новой строки.

/*
Выражаемся покороче
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            list.add(bufferedReader.readLine());
        }
        String min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (min.length() < list.get(i).length()) {
                min = list.get(i);
            } else continue;
        }
        for (int i = 0; i < list.size(); i++) {
            if (min.length() == list.get(i).length())
                System.out.println(list.get(i));

        }

        //напишите тут ваш код
    }
}






























