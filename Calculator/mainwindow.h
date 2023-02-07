//Борисова Екатерина ИВТ-20
#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>

#include <calculator.h>

QT_BEGIN_NAMESPACE
namespace Ui { class MainWindow; }
QT_END_NAMESPACE

class MainWindow : public QMainWindow
{
    Q_OBJECT

    Calculator calc;    //создаем экземпляр класса

public:
    MainWindow(QWidget *parent = nullptr);
    ~MainWindow();



private slots:

    void read();

    void on_Button_clear_clicked();         //очистить

    void on_Button_dot_clicked();           //точка

    void on_Button_power_clicked();         //степень

    void on_Button_division_clicked();      //деление

    void on_Button_mult_clicked();          //умножение

    void on_Button_minus_clicked();         //минус

    void on_Button_plus_clicked();          //плюс

    void on_Button_equal_clicked();         //равно

    void on_Button_ln_clicked();            //натуральный логорифм

    void on_Button_exp_clicked();           //экспонента

    void on_Button_tan_clicked();           //тангенс

    void on_Button_cos_clicked();           //косинус

    void on_Button_sin_clicked();           //синус

    /*цифры от 0 до 9*/

    void on_Button_0_clicked();

    void on_Button_1_clicked();

    void on_Button_2_clicked();

    void on_Button_3_clicked();

    void on_Button_4_clicked();

    void on_Button_5_clicked();

    void on_Button_6_clicked();

    void on_Button_7_clicked();

    void on_Button_8_clicked();

    void on_Button_9_clicked();

    void on_actionAbout_author_triggered();  //об авторе

private:
    Ui::MainWindow *ui;
};
#endif // MAINWINDOW_H
