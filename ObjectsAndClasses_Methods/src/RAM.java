public final class RAM {
    private final String typeRAM;
    private final int volumePAM;
    private final double weightRAM;

    public RAM(String typeRAM, int volumePAM, double weightRAM){
        this.typeRAM = typeRAM;
        this.volumePAM = volumePAM;
        this.weightRAM = weightRAM;

    }

    public RAM setTypeRAM(String typeRAM){
        return new RAM(typeRAM,volumePAM, weightRAM);
    }
    public RAM setWeightRAM(int weightRAM){
        return new RAM(typeRAM,volumePAM, weightRAM);
    }
    public RAM setVolumeRAM(int volumePAM){
        return new RAM(typeRAM,volumePAM, weightRAM);
    }
    public String getTypeRAM(){
        return typeRAM;
    }
    public int getVolumePAM(){
        return volumePAM;
    }
    public double getWeightRAM(){
        return weightRAM;
    }
    public String toString(){
        return "\n"+ "Оперативная память:" + "\n"+ "- Тип: " + typeRAM + "\n" + "- Объём: " + volumePAM + "\n" + "- Вес: "+ weightRAM + "\n";
    }

}
