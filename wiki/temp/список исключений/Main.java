//В java 7 появилась возможность ловить список исключений
//  это удобно если нужно обработать все исключения одинаково

class E extends Exception{ public String getMsg(){return "E";} }
class E1 extends E { @Override public String getMsg(){return "E1";} public void fE1(){}; }
class E2 extends E { @Override public String getMsg(){return "E2";} public void fE2(){}; }

public class Main
{
    public static void main(String[] args)
    {
        new Main().f();
    }
    void fThrowable() throws E1, E2
    { throw new E2(); }
    void f()
    {
        try
        {
            fThrowable();
        }
        catch( E1 | E2 e) //Указываем список исключений через оператор | при этом
        {
            e.getMsg();   //  тип переменной исключений будет ближайший общий тип для всех типов списка
            //e.fE1(); //Индивидуальные методы
            //e.fE2(); //  не доступны
        }
    
        //Честно говоря не понятно зачем нужна эта конструкция. если можно сделать так:
        try
        {
            fThrowable();
        } catch(E e)
        {
            e.getMsg();
        }

    }
}
