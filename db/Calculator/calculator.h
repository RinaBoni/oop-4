//Борисова Екатерина ИВТ-20
#ifndef CALCULATOR_H
#define CALCULATOR_H

#include <cmath>
#include <QString>

enum operations     //возможные операции
{
    NONE,
    PLUS,
    MINUS,
    MULTIPLICATION,
    DIVISION,
    POW,
    SIN,
    COS,
    TAN,
    EXP,
    LN,
};


class Calculator
{
private:
    double x;       //первая переменная/ответ
    operations op;  //выбранная операция
public:
    Calculator();   //конструктор

    /*сеттеры*/
    void set_x(double x);                   //задать переменную
    void set_op(operations op);             //задать операцию
    void set_all(double x, operations op);  //задать все

    /*геттеры*/
    double get_x();         //получаем переменную
    operations get_op();    //получаем операцию

    double calculation(double a);   //вычисление
};

#endif // CALCULATOR_H
