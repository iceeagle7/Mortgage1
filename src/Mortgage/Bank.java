package Mortgage;

public abstract class Bank {
    protected double sum;     /*Толық төлем*/
    protected double percent; /*банктік пайыздық мөлшерлеме*/
    protected double leftSum; /*Ипотека бойынша артық төленетін сома*/

    public Bank(double sum) { /*Барлық қасиеттерге мағына беретін конструктор*/
        this.sum = sum;
        leftSum = 0; /*Артық төлем нөлге тең*/
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public double getLeftSum() {
        return leftSum;
    }

    public void setLeftSum(double leftSum) {
        this.leftSum = leftSum;
    }

    public int CalculateYear(double monthSum) {   /*ай сайынгы уакытты есептеуге жауап беретин функция  */
        int year = 0;/*бастапқыда 0-ге тең, себебі бұл ең бастамасы*/
        int Sum = 0; /*негізгі сомамен салыстыратын уақытша сома (Толық төлем)*/
        /*уақытша сома негізгі сомаға тең немесе одан жоғары болғанша жалғасатын цикл*/
        while(Sum < sum) {
            for(int i = 0; i < 12; i++) { /*цикл 12-ге дейін жетеді, яғни біз ай бойынша есептейміз*/
                Sum += monthSum; /*ай сайынғы соманы уақытша сомаға қосамыз*/
            }
            /*біз артық төлемді есептейміз (негізгі соманың пайызын есептеп, оны артық төлемге қосамыз)*/
            leftSum += ((sum * percent) / 100);
            year++; /* жыл косамыз*/
        }

        return year; /*алынған нәтижені бір жыл ішінде қайтарамыз*/
    }

}
