package com.javarush.task.task17.task1714;

/*
Comparable
Реализуйте интерфейс Comparable<Beach> в классе Beach. Пляжи(Beach) будут использоваться нитями, поэтому позаботьтесь, чтобы все методы были синхронизированы.
Реализовать метод compareTo так, чтобы он при сравнении двух пляжей выдавал число, которое показывает что первый пляж лучше (положительное число)
или второй пляж лучше (отрицательное число), и насколько он лучше.
*/

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    @Override
    public synchronized int compareTo(Beach o) {
        return  (int) (this.quality - this.distance- o.quality +o.distance)   ;
    }


    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {

    }

}






























