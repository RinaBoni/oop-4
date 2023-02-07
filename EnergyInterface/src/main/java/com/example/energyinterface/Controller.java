package com.example.energyinterface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    /**
     * создаем объект типа Energy
     */
    private Energy energy = new Energy();

    /**
     * кнопка добавить - выводит информацию об энергетике в textArea
     */
    @FXML
    private Button button_add;

    /**
     * для вывода информации об энергетике
     */
    @FXML
    private TextArea textArea;

    /**
     * для ввода бренда
     */
    @FXML
    private TextField textField_Brand;

    /**
     * для ввода энергетической ценности
     */
    @FXML
    private TextField textField_EnergyValue;

    /**
     * для ввода названия
     */
    @FXML
    private TextField textField_Name;

    /**
     * для ввода цены
     */
    @FXML
    private TextField textField_Price;

    /**
     * для ввода вкуса
     */
    @FXML
    private TextField textField_Taste;

    /**
     * для ввода таурина
     */
    @FXML
    private TextField textField_Taurine;

    /**
     * для ввода объема
     */
    @FXML
    private TextField textField_Volume;

    /**
     * для ввода кофеина
     */
    @FXML
    private TextField textField_Сaffeine;

    /**
     * по нажатию кнопки
     */
    public void button_add_clicked() {


        textArea.appendText(energy.AllInformation());

        /**
         * Задали бренд
         */
        energy.setBrand(textField_Brand.getText());

        /**
         * Задали имя
         */
        energy.setName(textField_Name.getText());

        /**
         * Задали вкус
         */
        energy.setTaste(textField_Taste.getText());

        try{
            /**
             * Задали цену
             */
            energy.setPrice(Double.parseDouble(textField_Price.getText()));

            /**
             * Задали энергетическую ценность
             */
            energy.setEnergyValue(Double.parseDouble(textField_EnergyValue.getText()));

            /**
             * Задали кофеин
             */
            energy.setСaffeine(Double.parseDouble(textField_Сaffeine.getText()));

            /**
             * Задали таурин
             */
            energy.setTaurine(Double.parseDouble(textField_Taurine.getText()));

            /**
             * Задали объем
             */
            energy.setVolume(Double.parseDouble(textField_Volume.getText()));

            /**
             * выводим всю информацию об энергетике
             */
            textArea.appendText(energy.AllInformation());
        }
        catch (IllegalArgumentException e){
            textArea.setText(e.getMessage());
        }


    }


}
