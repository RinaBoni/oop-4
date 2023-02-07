package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

import java.io.File;
import java.io.IOException;

/**
 * Констроллер для взаимодейсвия с базой данных
 * @author Борисова Екатерина ИВТ-20
 */
public class DataBaseController {

    @FXML
    private TableColumn<Person, Integer> IDColumn;
    @FXML
    private TableColumn<Person, String> FamColumn;
    @FXML
    private TableColumn<Person, String> NameColumn;
    @FXML
    private TableColumn<Person, String> OtchColumn;
    @FXML
    private TableColumn<Person, Integer> AgeColumn;
    @FXML
    private TableColumn<Person, Integer> SeriesColumn;
    @FXML
    private TableColumn<Person, Integer> NumberColumn;
    @FXML
    private Button informationText;
    @FXML
    private Button informationText1;

    @FXML
    private TableView<Person> objectsTableView; //создает таблицу, заполненную данными из коллекции
    private final DataBase data = new DataBase(); //экземпляр класса DataBase
    private String fileName = "data2.txt";        //файл

    /**
     * Срабатывает при запуске
     */
    public void initialize(){
        // ==== Инициализация таблицы
        // связывает колонку и метод из Student, с помощью которого колонка будет получать значения для каждой ячейки данных
        // аргумента PropertyValueFactory должен быь таким, чтобы получить име геттера и сеттера добавив get и set соответственно
        objectsTableView.setItems(data.objects);// связывает табличку и класс базы данных

        //setCellValueFactory определяет, какое поле внутри класса Person будут использоваться для конкретного столбца в таблице.
        //PropertyValueFactory позволяет установить привязку столбца к определенному свойству данных
        IDColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        FamColumn.setCellValueFactory(new PropertyValueFactory<>("Fam"));
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        OtchColumn.setCellValueFactory(new PropertyValueFactory<>("Otch"));
        AgeColumn.setCellValueFactory(new PropertyValueFactory<>("Age"));
        SeriesColumn.setCellValueFactory(new PropertyValueFactory<>("Series"));
        NumberColumn.setCellValueFactory(new PropertyValueFactory<>("Number"));

        //для редактирования
        //setEditable Включение или выключение возможности редактирования текста
        //setCellFactory метод корректирования ячейки
        //TextFieldTableCell представляется как a Label если не будучи отредактированным, и как TextField, когда в режиме редактирования.
        // TextField будет, по умолчанию, простираться, чтобы заполнить всю табличную ячейку.
        //forTableColumn Предоставляет TextField, которое позволяет редактировать содержимое ячейки при двойном щелчке по ячейке
        objectsTableView.setEditable(true);
        IDColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        FamColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        NameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        OtchColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        AgeColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        SeriesColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        NumberColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

    }

    /**
     * Вызывает окно с анкетой для добавления нового человека в БД
     * @param event
     * @throws IOException
     */
    @FXML
    void clickAddPButton(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(DataBaseApplication.class.getResource("NewPerson.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("New person");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);//он будет блокировать все другие окна (Stage), открытые этим приложением. Вы не можете получить доступ к ним, пока это окно рабочей области не будет закрыто.
        stage.getUserData();                                //Получает данные указанного пользователя в виде объекта
        stage.setResizable(false);                          //пользователь не право изменять размеры фрейма.
        stage.show();

        NewPersonController newPersonController = fxmlLoader.getController();   //открывает NewPersonController
        newPersonController.setDataBase(data);
        newPersonController.setTable(objectsTableView);
    }

    /**
     * Удаляет выбранное поле из БД
     * @param actionEvent
     */
    public void clickDeleteButton(ActionEvent actionEvent) {
        //getSelectionModel возвращает объект класса
        // getSelectedItem возвращает строку
        data.objects.remove(data.objects.indexOf(objectsTableView.getSelectionModel().getSelectedItem()));
        objectsTableView.refresh(); //обновляем таблицу
    }

    /**
     * Очищает всю БД
     * @param actionEvent
     */
    public void clickClearButton(ActionEvent actionEvent) {
        data.objects.clear();           //очищаем таблицу
        objectsTableView.refresh();     //обновляем таблицу
    }
    @FXML
    /**
     * Сохраняет БД в файл (данные с формы)
     */
    void clickSaveFileButton(ActionEvent event) {
        data.saveFile(fileName);    //Считывает данные с таблицы и записывает в файл
    }
    @FXML
    /**
     * Заполняет БД на форме данными из файла
     */
    void clickReadFileButton(ActionEvent event) {
        try {
            data.objects.clear();       //очищаем таблицу
            data.readFile(fileName);    //Считываем данные из файла и вставляет в таблицу
        } catch (IOException e) {       //если не получилось, кидаем исключение
            e.printStackTrace();
        }
        objectsTableView.refresh();     //обновляем таблицу
    }

    /**
     * Вызывает окно с информациией о разработчике
     * @throws IOException
     */
    @FXML
    void clickInfoButton() throws IOException {//TODO
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(DataBaseApplication.class.getResource("Z.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Info");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * Вызывает диалоговое окно для сохранения файла.
     */
    @FXML
    private void onMenuItemExportClick() {
        Stage stage = (Stage) informationText.getScene().getWindow();

        //FileChooser позволяет перемещаться в систему файлов, чтобы выбрать файл
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Export File");    //даем тайтл окну
        File file = fileChooser.showSaveDialog(stage); //showSaveDialog Функция открытия диалогового окна «Сохранить файл»

        if(file != null) {
            //getAbsolutePath возвращает полный пути до файла
            data.saveFile(file.getAbsolutePath());  //сохраняем файл
        }
    }

    /**
     * Вызывает диалоговое окно для открытия файла.
     */
    @FXML
    private void onMenuItemImportClick() {
        Stage stage = (Stage) informationText1.getScene().getWindow();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Import File");
        File file = fileChooser.showOpenDialog(stage);

        if(file != null) {
            data.objects.clear();
            try {
                data.readFile(file.getAbsolutePath());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}