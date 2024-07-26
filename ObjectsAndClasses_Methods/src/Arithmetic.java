public class Arithmetic {
    private int firstNum;
    private int secondNum;

    public Arithmetic() {
        this.firstNum = 4;
        this.secondNum = 5;
    }
    public Arithmetic(int firstNum, int secondNum) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
    }

    public int addsUp() {
        return firstNum+secondNum;

    }

    public int multiplies() {
        return firstNum*secondNum;

    }

    public int maxNum() {
        if (firstNum > secondNum){
            return firstNum;
        } else {
            return secondNum;
        }
    }

    public int minNum() {
        if (firstNum < secondNum){
            return firstNum;
        } else {
            return secondNum;
        }

    }

}
