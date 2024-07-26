public final class CPU {
    private final int frequency;
    private final int core;
    private final String producer;
    private final double weightCPU;


    public CPU(int frequency, int core, String producer, double weightCPU){
        this.frequency = frequency;
        this.core = core;
        this.producer = producer;
        this.weightCPU = weightCPU;
    }

    public CPU setFrequency(int frequency){
        return new CPU(frequency,core, producer, weightCPU);
    }
    public CPU setCore(int core){
        return new CPU(frequency,core, producer, weightCPU);
    }
    public CPU setProducer(String producer){
        return new CPU(frequency,core, producer, weightCPU);
    }
    public CPU setWeightCPU(double weightCPU){
        return new CPU(frequency,core, producer, weightCPU);
    }
    public int getFrequency(){
        return frequency;
    }
    public int getCore(){
        return core;
    }
    public double getWeightCPU(){
        return weightCPU;
    }
    public String getProducer(){
        return producer;
    }
    public String toString(){
        return "\n"+"Процессор:" + "\n"+ "- Частота: " + frequency + "\n" + "- Количество ядер: " + core + "\n" + "- Производитель: "+ producer + "\n" + "- Вес: " + weightCPU + "\n";
    }
}
