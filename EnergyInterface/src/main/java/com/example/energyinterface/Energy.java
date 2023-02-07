package com.example.energyinterface;

/**
 * @author Борисова Екатерина ИВТ-20
 * Класс описание энергитического напитка
 */
public class Energy {

    /**
     * поля класса: бренд, вкус, название напитка, энергетическая ценность, кол-во кофеина, кол-во таурина, цена, объем
     */
    private String Brand;
    private String Taste;
    private String Name;
    private double EnergyValue, Сaffeine, Taurine, Price, Volume;

    /**
     * Конструктор по умолчанию
     */
    Energy() {
        this.Brand = "black monster";
        this.EnergyValue = 325;
        this.Name = "ultra";
        this.Price = 565;
        this.Taste = "coconut and fructs";
        this.Taurine = 56;
        this.Volume = 0.5;
        this.Сaffeine = 56;
    }
////////////////////////////////////////////

    /**
     * геттер для бренда
     * @return бренд
     */
    public String getBrand() {
        return Brand;
    }

    /**
     * сеттер для бренда
     * @param brand бренд
     */
    public void setBrand(String brand) {
        Brand = brand;
    }

    /**
     * геттер для вкуса
     * @return вкус
     */
    public String getTaste() {
        return Taste;
    }

    /**
     * сеттер для вкуса
     * @param taste вкус
     */
    public void setTaste(String taste) {
        Taste = taste;
    }

    /**
     * геттер для названия
     * @return название
     */
    public String getName() {
        return Name;
    }

    /**
     * сеттер для названия
     * @param name название
     */
    public void setName(String name) {
        Name = name;
    }

    /**
     * геттер для энергетической ценности
     * @return энергетическую ценность
     */
    public double getEnergyValue() {
        return EnergyValue;
    }

    /**
     * сеттер для энергетической ценности
     * @param energyValue энергетическая ценность
     */
    public void setEnergyValue(double energyValue) {
       /* try {
            if (energyValue > 0) {
                EnergyValue = energyValue;
            }
        }
        catch ()*/
        if (energyValue > 0)
        {
            EnergyValue = energyValue;
        }
        else {
            throw new IllegalArgumentException("Значение не может быть меньше нуля");
        }
    }

    /**
     * геттер для кофеина
     * @return кол-во кофеина
     */
    public double getСaffeine() {
        return Сaffeine;
    }

    /**
     * сеттер для кофеина
     * @param сaffeine кофеин
     */
    public void setСaffeine(double сaffeine) {
        if (сaffeine > 0)
        {
            Сaffeine = сaffeine;
        }
        else {
            throw new IllegalArgumentException("Значение не может быть меньше нуля");
        }
    }

    /**
     * геттер для таурина
     * @return кол-во таурина
     */
    public double getTaurine() {
        return Taurine;
    }

    /**
     * сеттер для таурина
     * @param taurine таурин
     */
    public void setTaurine(double taurine) {
        if (taurine > 0)
        {
            Taurine = taurine;
        }
        else {
            throw new IllegalArgumentException("Значение не может быть меньше нуля");
        }
    }

    /**
     * геттер для цены
     * @return цену
     */
    public double getPrice() {
        return Price;
    }

    /**
     * сеттер для цены
     * @param price цена
     */
    public void setPrice(double price) {
        if (price > 0)
        {
            Price = price;
        }
        else {
            throw new IllegalArgumentException("Значение не может быть меньше нуля");
        }
    }

    /**
     * геттер для объема (в мл)
     * @return объем (в мл)
     */
    public double getVolume() {
        return Volume;
    }

    /**
     * сеттер для объема
     * @param volume объем
     */
    public void setVolume(double volume) {
        if (volume > 0)
        {
            Volume = volume;
        }
        else {
            throw new IllegalArgumentException("Значение не может быть меньше нуля");
        }

    }

    ////

    /**
     * метод, который собираем всю информацию в одну строку
     * @return строку с полной информацией про энергетик
     */
    public String AllInformation() {
        String information = "Information about Energy drink:\n";
        information +=
                "\tBrand: " + Brand + "\n" +
                        "\tName: " + Name + "\n" +
                        "\tTaste: " + Taste + "\n" +
                        "\tEnergyValue: " + EnergyValue + "\n" +
                        "\tCaffeine: " + Сaffeine + "\n" +
                        "\tTaurine: " + Taurine + "\n" +
                        "\tPrice: " + Price + "\n" +
                        "\tVolume: " + Volume + "\n";
        return information;

    }


}
