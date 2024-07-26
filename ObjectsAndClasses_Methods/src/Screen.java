public final class Screen {
    private final double screenDiagonal;
    private  final ScreenType typeScreen;
    private final int weight;
    public Screen(double screenDiagonal, ScreenType typeScreen, int weight){
        this.screenDiagonal = screenDiagonal;
        this.typeScreen = typeScreen;
        this.weight = weight;

    }
    public Screen setScreenType(ScreenType typeScreen){
        return new Screen(screenDiagonal, typeScreen, weight);
    }
    public Screen setScreenDiagonal(double screenDiagonal){
        return new Screen(screenDiagonal, typeScreen,weight);
    }
    public Screen setWeight(int weight){
        return new Screen(screenDiagonal,typeScreen,weight);
    }
    public ScreenType getTypeScreen(){
        return typeScreen;
    }
    public double getScreenDiagonal(){
        return screenDiagonal;
    }
    public int getWeight(){
        return weight;
    }
    public String toString(){
        return "Экран:" + "\n"+ "- Тип: " + typeScreen + "\n" + "- Диагональ: " + screenDiagonal + "\n" + "- Вес: "+ weight + "\n";
    }
}
