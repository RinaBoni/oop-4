//Борисова Екатерина ИВТ-20
#include "calculator.h"

Calculator::Calculator()    //конструктор
{
    set_all(0,PLUS);
}

void Calculator::set_x(double x)                    //задать переменную
{
    this->x=x;
}

void Calculator::set_op(operations op)              //задать операцию
{
    this->op=op;
}

void Calculator::set_all(double x, operations op)   //задать все
{
    set_x(x);
    set_op(op);
}

double Calculator::get_x()          //получаем переменную
{
    return x;
}

operations Calculator::get_op()     //получаем операцию
{
    return op;
}

double Calculator::calculation(double a)    //вычисление
{
    double result = 0;      //результат

    if (op==NONE)                   //операция не выбрана
        result = get_x();

    if (op==PLUS)                   //сложение
        result = (get_x() + a);

    if (op==MINUS)                  //вычитание
        result = (get_x() - a);

    if (op==MULTIPLICATION)         //умножение
        result = (get_x() * a);

    if (op==DIVISION)               //деление
    {
        if (a!=0)
            result = (get_x() / a);
        else                        //для умников, которые хотят поделить на 0
        {
            QString str = "it is impossible to divide by 0, dumbass ";
            throw str;
        }
    }

    if (op==POW)                    //возведение в степень
        result = pow(get_x(), a);

    if (op==SIN)                    //синус
        result = sin(get_x());

    if (op==COS)                    //косинус
        result = cos(get_x());

    if (op==TAN)                    //тангенс
        result = tan(get_x());

    if (op==EXP)                    //экспонента
        result = exp(get_x());

    if (op==LN)                     //натуральный логорифм
    {
        if (get_x()>0)
           result = log(get_x());
        else if (get_x()==0)        //натуральный логорифм 0 не определен
        {
            QString str = "Ln(0)is not defined";
            throw str;
        }
        else if (get_x()<0)         //натуральный логорифм отрицательного цисла не определен
        {
            QString str = "the negative Ln is not defined";
            throw str;
        }
    }

    return result;

}
