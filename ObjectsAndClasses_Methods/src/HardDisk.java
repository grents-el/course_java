public final class HardDisk {
    private final HardDiskType diskType;
    private final int volumeDisk;
    private final int weightDisk;

    public HardDisk(HardDiskType diskType, int volumeDisk, int weightDisk){
        this.weightDisk = weightDisk;
        this.diskType = diskType;
        this.volumeDisk = volumeDisk;

    }

    public HardDisk setDiskType(HardDiskType diskType){
        return new HardDisk(diskType,volumeDisk, weightDisk);
    }
    public HardDisk setVolumeDisk(int volumeDisk){
        return new HardDisk(diskType,volumeDisk, weightDisk);
    }
    public HardDisk setWeightDisk(int weightDisk){
        return new HardDisk(diskType,volumeDisk, weightDisk);
    }
    public HardDiskType getDiskType(){
        return diskType;
    }
    public int getVolumeDisk(){
        return volumeDisk;
    }
    public int getWeightDisk(){
        return weightDisk;
    }
    public String toString(){
        return "Жесткий диск:" + "\n"+ "- Тип: " + diskType + "\n" + "- Обьем: " + volumeDisk + "\n" + "- Вес: "+ weightDisk;
    }
}
