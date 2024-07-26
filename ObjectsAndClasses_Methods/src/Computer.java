public class Computer {

    private  CPU cpu;
    private final String vendor;
    private final String name;

    private  RAM ram;
    private  HardDisk hardDisk;
    private  Screen screen;
    private  Keyboard keyboard;
    private double totalWeight;

    public Computer(String vendor,String name,CPU cpu, RAM ram, HardDisk hardDisk, Screen screen,Keyboard keyboard){

        this.vendor = vendor;
        this.name = name;
        this.cpu = cpu;
        this.ram = ram;
        this.hardDisk = hardDisk;
        this.screen = screen;
        this.keyboard = keyboard;
    }
    public void setCPU(CPU cpu){
        this.cpu = cpu;

    }
    public void setRAM(RAM ram){
        this.ram = ram;
    }
    public void setHardDisk(HardDisk hardDisk){
        this.hardDisk = hardDisk;
    }
    public void setScreen(Screen screen){
        this.screen = screen;
    }
    public void setKeyboard(Keyboard keyboard){
        this.keyboard = keyboard;
    }
    public CPU getCpu(){
        return cpu;
    }
    public  RAM getRam(){
        return ram;
    }
    public HardDisk getHardDisk(){
        return hardDisk;
    }
    public Screen getScreen(){
        return screen;
    }
    public Keyboard getKeyboard(){
        return keyboard;
    }
    public double TotalWeight(){
        totalWeight = totalWeight + cpu.getWeightCPU() + ram.getWeightRAM() + hardDisk.getWeightDisk() + screen.getWeight() + keyboard.getWeightKeyboard();
        return totalWeight;
    }
    public double getTotalWeight(){
        return totalWeight;
    }
    public String toString(){
        return "Производитель: " + vendor + "\n" + "Название: " + "\n" + name + cpu.toString() + "\n" + hardDisk.toString() + ram.toString() + screen.toString() + keyboard.toString();
    }

}
