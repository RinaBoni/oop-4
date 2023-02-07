//Борисова Екатерина ИВТ-20
#include "mainwindow.h"
#include "ui_mainwindow.h"
#include <QMessageBox>
#include <QString>

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::MainWindow)
{
    ui->setupUi(this);
}

MainWindow::~MainWindow()
{
    delete ui;
}


void MainWindow::read()
{
    double a=0;
    a = ui->Edit_result->text().toDouble();
    ui->Edit_result->setText("");
    ui->lineEdit->setText("");
    try
    {
        calc.set_x(calc.calculation(a));
    }
    catch (const QString &str)
    {

        ui->lineEdit->setText(str);

//        QMessageBox::information(this, "error", str);
//        ui->Edit_result->insert(str);
    }
}


void MainWindow::on_Button_clear_clicked()          //очистить поля класса и Edit
{
    ui->Edit_result->setText("");   //очищаем Edit для дальнейшего использования
    calc.set_all(0,PLUS);           //устанавливаем в поля значения по умолчанию
}


void MainWindow::on_Button_dot_clicked()            //точка
{
    if(!ui->Edit_result->text().contains('.')){ //если нет точек
        ui->Edit_result->insert(".");           //вставляем точку
    }
}


void MainWindow::on_Button_power_clicked()          //возведение в степень
{
    read();             //выполнение предыдущей операции (в данном случае запоминание первой переменной)
    calc.set_op(POW);   //запоминаем операцию
}


void MainWindow::on_Button_division_clicked()       //деление
{
    read();                 //выполнение предыдущей операции (в данном случае запоминание первой переменной)
    calc.set_op(DIVISION);  //запоминаем операцию
}


void MainWindow::on_Button_mult_clicked()           //умножение
{
    read();                       //выполнение предыдущей операции (в данном случае запоминание первой переменной)
    calc.set_op(MULTIPLICATION);  //запоминаем операцию
}


void MainWindow::on_Button_minus_clicked()          //вычитание
{
    read();              //выполнение предыдущей операции (в данном случае запоминание первой переменной)
    calc.set_op(MINUS);  //запоминаем операцию
}


void MainWindow::on_Button_plus_clicked()           // сложение
{
    read();             //выполнение предыдущей операции (в данном случае запоминание первой переменной)
    calc.set_op(PLUS);  //запоминаем операцию
}


void MainWindow::on_Button_equal_clicked()          //показ результата
{
    read();             //выполнение предыдущей операции
    calc.set_op(NONE);  //сбрасываем операцию для дальнейшего использования
    ui->Edit_result->setText(QString::number(calc.get_x()));    //выводим результат вычесления
}


void MainWindow::on_Button_ln_clicked()             //натуральный логорифм
{
    read();            //выполнение предыдущей операции (в данном случае запоминание первой переменной)
    calc.set_op(LN);   //запоминаем операцию
}


void MainWindow::on_Button_exp_clicked()            //экспонента
{
    read();             //выполнение предыдущей операции (в данном случае запоминание первой переменной)
    calc.set_op(EXP);   //запоминаем операцию
}


void MainWindow::on_Button_tan_clicked()            //тангенс
{
    read();             //выполнение предыдущей операции (в данном случае запоминание первой переменной)
    calc.set_op(TAN);   //запоминаем операцию
}


void MainWindow::on_Button_cos_clicked()            //косинус
{
    read();             //выполнение предыдущей операции (в данном случае запоминание первой переменной)
    calc.set_op(COS);   //запоминаем операцию
}


void MainWindow::on_Button_sin_clicked()            //синус
{
    read();             //выполнение предыдущей операции (в данном случае запоминание первой переменной)
    calc.set_op(SIN);   //запоминаем операцию
}


/*************цифры*************/
void MainWindow::on_Button_0_clicked()
{
    ui->Edit_result->insert("0");
}


void MainWindow::on_Button_1_clicked()
{
    ui->Edit_result->insert("1");
}


void MainWindow::on_Button_2_clicked()
{
    ui->Edit_result->insert("2");
}


void MainWindow::on_Button_3_clicked()
{
    ui->Edit_result->insert("3");
}


void MainWindow::on_Button_4_clicked()
{
    ui->Edit_result->insert("4");
}


void MainWindow::on_Button_5_clicked()
{
    ui->Edit_result->insert("5");
}


void MainWindow::on_Button_6_clicked()
{
    ui->Edit_result->insert("6");
}


void MainWindow::on_Button_7_clicked()
{
    ui->Edit_result->insert("7");
}


void MainWindow::on_Button_8_clicked()
{
    ui->Edit_result->insert("8");
}


void MainWindow::on_Button_9_clicked()
{
    ui->Edit_result->insert("9");
}


void MainWindow::on_actionAbout_author_triggered()  //об авторе
{
    QMessageBox::warning(this, "Author", "Borisova Ekaterina IVT-20");
}

