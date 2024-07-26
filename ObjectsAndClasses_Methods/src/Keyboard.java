public final class Keyboard {
    private final String typeKeyboard;
    private final boolean suspension;
    private final double weightKeyboard;

    public Keyboard(String typeKeyboard,boolean suspension,double weightKeyboard){
        this.typeKeyboard = typeKeyboard;
        this.suspension = suspension;
        this.weightKeyboard = weightKeyboard;
    }
    public Keyboard setTypeKeyboard(String typeKeyboard){
        return  new Keyboard(typeKeyboard,suspension,weightKeyboard);
    }
    public Keyboard setSuspension(boolean suspension){
        return new Keyboard(typeKeyboard,suspension,weightKeyboard);
    }
    public Keyboard setWeightKeyboard(double weightKeyboard){
        return new Keyboard(typeKeyboard,suspension,weightKeyboard);
    }
    public String getTypeKeyboard(){
        return typeKeyboard;
    }
    public boolean getSuspension(){
        return suspension;
    }

    public double getWeightKeyboard() {
        return weightKeyboard;
    }

    public String toString(){
        return "Клавиатура:" + "\n"+ "- Тип: " + typeKeyboard + "\n" + "- Подвеска: " + suspension + "\n" + "- Вес: "+ weightKeyboard + "\n";
    }
}
