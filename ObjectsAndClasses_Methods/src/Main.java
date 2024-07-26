    public class Main {
        public static void main(String[] args) {
        RAM ram = new RAM("SDRAM",7,6);
        HardDisk hardDisk = new HardDisk(HardDiskType.HDD,3,4);
        CPU cpu = new CPU(3,4, "intel2",1.0);
        Screen screen = new Screen(17.6,ScreenType.TN,4);
        Keyboard keyboard = new Keyboard("membrane",true,4.5);
        Computer computer = new Computer("ASUS","TUF A15",cpu,ram,hardDisk,screen,keyboard);
        System.out.println(computer.toString());
        System.out.println("Общий вес: " + computer.TotalWeight());
        Computer computer1 = new Computer("Apple","Mac",cpu,ram,hardDisk,screen,keyboard);
        computer1.setCPU(new CPU(1,6,"intel7",5.8));
        computer1.setHardDisk(new HardDisk(HardDiskType.SDD,4,5));
        System.out.println(computer1.toString());
        System.out.println("Общий вес: " + computer1.TotalWeight());

        }
    }
