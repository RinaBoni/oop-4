//Борисова Екатерина ИВТ-20
#include "mainwindow.h"
#include "ui_mainwindow.h"

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::MainWindow)
{
    ui->setupUi(this);

    connect(ui->Button_1, SIGNAL(clicked()), this, SLOT(numbers_out()));    //
    connect(ui->Button_2, SIGNAL(clicked()), this, SLOT(numbers_out()));
    connect(ui->Button_3, SIGNAL(clicked()), this, SLOT(numbers_out()));
    connect(ui->Button_4, SIGNAL(clicked()), this, SLOT(numbers_out()));
    connect(ui->Button_5, SIGNAL(clicked()), this, SLOT(numbers_out()));
    connect(ui->Button_6, SIGNAL(clicked()), this, SLOT(numbers_out()));
    connect(ui->Button_7, SIGNAL(clicked()), this, SLOT(numbers_out()));
    connect(ui->Button_8, SIGNAL(clicked()), this, SLOT(numbers_out()));
    connect(ui->Button_9, SIGNAL(clicked()), this, SLOT(numbers_out()));

    connect(ui->delete_Button, SIGNAL(clicked()), this, SLOT(clear_label()));
}

MainWindow::~MainWindow()
{
    delete ui;
}

void MainWindow::numbers_out()
{
    QPushButton *button =(QPushButton*)sender();    //Создаем указатель для отслеживания кнопки на которую нажали
                                                       //sender вернет кнопку на которую нажали

    ui->label->setText(ui->label->text() + button->text());

}

void MainWindow::clear_label()
{
    QPushButton *button = (QPushButton*)sender();

    ui->label->clear();
}

