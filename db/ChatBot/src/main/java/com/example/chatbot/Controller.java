package com.example.chatbot;

import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.Button;
        import javafx.scene.control.TextArea;
        import javafx.scene.control.TextField;
        import javafx.scene.paint.Color;
        import javafx.scene.text.*;
        import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
        import java.util.Scanner;

public class Controller {

    //String User;
    private Bot bot = new Bot();


    /**
     * кнопка отправить
     */
    @FXML
    private Button buttonInput;


    /**
     * вывод сообщений
     */
    @FXML
    private TextArea textArea_dialogue;


    /**
     * ввод сообщения
     */
    @FXML
    private TextField textField_input;


    /**
     * метод обрабатывающий нажатие кнопки
     * @param actionEvent 	Пользователь нажал кнопку
     * @throws URISyntaxException Проверенное исключение, выданное, чтобы указать, что строка не могла быть проанализирована как ссылка URI.
     * @throws IOException Сигналы, что исключение ввода-вывода некоторого вида произошло.
     *                     Этот класс является общим классом исключений, произведенных отказавшими или прерванными операциями ввода-вывода.
     */
    public void button_click(ActionEvent actionEvent) throws URISyntaxException, IOException {

        //Читаем сообщение и очищаем строку
        String message = textField_input.getText();
        textField_input.clear();

        if (message.trim().length() > 0)    //Проверяем не пустая ли строка
        {
            //Печатаем наше сообщение в диалоговое окно
            textArea_dialogue.appendText(bot.getDate() + "\n" +
                    //User + ": " + message + "\n\n");
                    "yo: " + message + "\n\n");
            //И добавляем ответ бота
            textArea_dialogue.appendText(bot.getDate() + "\n" +
                    "Мистер Бот: " + bot.answer(message) + "\n\n");
        }
    }
}