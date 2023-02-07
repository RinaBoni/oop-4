# UI Language

## JAVA FXML

### Загрузка FXML файла
```JAVA
public class DataBaseApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // запуск главного окна с БД
        FXMLLoader fxmlLoader = new FXMLLoader(DataBaseApplication.class.getResource("DB.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Database");
        stage.setScene(scene);
        stage.show();
    }
```
### Добавление компонентов

Теперь пришло время добавить некоторые компоненты. метку (label):

```xml
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.Label?>

<!--Допускается только один компонент на корневом уровне-->
<Label>Hello World!</Label>
```

VBox, который размещает свои дочерние элементы вертикально друг над другом.

```xml
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.Label?>
<?import javafx.scene.layout.VBox?>
<?import javafx.scene.control.Button?>

<VBox>
    <Label text="Hello world!"/>
    <Label text="This is a simple demo application."/>
    <Button text="Click me!"/>
</VBox>
```
### FX Namespace

Существует пара элементов и атрибутов FXML, которые по умолчанию недоступны. Для досупа нужно добавить пространство имён (Namespace) FXML, чтобы сделать их доступными. Его необходимо добавить к корневому компоненту:

```xml
<?xml version="1.0" encoding="UTF-8"?>
    ...

<VBox xmlns="http://javafx.com/javafx"
      xmlns:fx="http://javafx.com/fxml">
    ...
</VBox>
````

Теперь можно использовать новые элементы из пространства имен ```fx```.

```xml
<Label fx:id="mainTitle" text="Hello world!"/>
```
Атрибут ```fx:id``` является уникальным идентификатором компонента, который можно использовать для ссылки на компонент из других частей нашего FXML и даже из нашего контроллера.

### style
```xml
style = "-fx-background-color - устанавливает цвет фона
-fx-text-fill - устанавливает цвет текста
-fx-border-radius - устанавливает закругление у обьекта в пикселях
-fx-border-color - устанавливает цвет border
-fx-background-image - устанавливает фоновую картинку
-fx-font-size - устанавливает размер шрифта
-fx-font-name - устанавливает шрифт"
```

### Скрипты

Первое, что нужно сделать, это добавить обработчик события onAction для кнопки.
```xml
<Button fx:id="mainButton" text="Click me!" onAction="buttonClicked()"/>
```
Обратите внимание на fx:id, это идентификатор, который будет использоваться позже для ссылки на кнопку.

Теперь нужно предоставить функцию, которая будет вызвана для обработки события. Ее можно определить внутри тега ```fx:script```. Можно использовать различные языки для написания скрипта, JavaScript, Groovy или Clojure

### Пример
Пример окна базы данных
```xml
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.geometry.*?>
<?import javafx.scene.control.*?>
<?import javafx.scene.layout.*?>

<VBox alignment="CENTER" prefHeight="469.0" prefWidth="785.0" spacing="20.0" xmlns="http://javafx.com/javafx/16" xmlns:fx="http://javafx.com/fxml/1" fx:controller="com.example.demo.DataBaseController">
    <padding>
        <Insets bottom="20.0" left="20.0" right="20.0" top="20.0" />
    </padding>
   <HBox prefHeight="42.0" prefWidth="522.0">
      <children>
         <Button fx:id="saveFile" onAction="#clickSaveFileButton" text="Save file" />
         <Button fx:id="informationText" onAction="#onMenuItemExportClick" text="Save as" />
         <Button fx:id="informationText1" onAction="#onMenuItemImportClick" text="Open file" />
         <Button fx:id="deleteButton" onAction="#clickDeleteButton" text="delete" />
         <Button fx:id="clearButton" onAction="#clickClearButton" prefHeight="26.0" prefWidth="52.0" text="clear" />
      </children>
   </HBox>
   <TableView fx:id="objectsTableView" prefHeight="364.0" prefWidth="522.0">
     <columns>
       <TableColumn fx:id="IDColumn" minWidth="7.99993896484375" prefWidth="44.799983978271484" text="ID" />
       <TableColumn fx:id="FamColumn" prefWidth="141.60000610351562" text="Fam" />
         <TableColumn fx:id="NameColumn" prefWidth="112.00001525878906" text="Name" />
         <TableColumn fx:id="OtchColumn" prefWidth="158.4000244140625" text="Otch" />
         <TableColumn fx:id="AgeColumn" prefWidth="67.20001220703125" text="Age" />
         <TableColumn fx:id="SeriesColumn" prefWidth="76.79998779296875" text="Series" />
         <TableColumn fx:id="NumberColumn" prefWidth="140.7999267578125" text="Number" />
     </columns>
   </TableView>
   <Button fx:id="AddButton" onAction="#clickAddPButton" prefHeight="26.0" prefWidth="159.0" text="Добавить" />
</VBox>
```
Для понимания куда нужно смотреть в поиске методов с формы 
```xml
<VBox alignment="CENTER" prefHeight="469.0" prefWidth="785.0" spacing="20.0" xmlns="http://javafx.com/javafx/16" xmlns:fx="http://javafx.com/fxml/1" fx:controller="com.example.demo.DataBaseController">
```
Чтобы изменить параметр ,н-р, кнопки, сначала нужно объявить кнопку в контроллере.

```JAVA
@FXML
    private Button informationText;
```
