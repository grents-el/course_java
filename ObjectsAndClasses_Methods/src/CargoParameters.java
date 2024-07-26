public final class CargoParameters {
    private final Dimensions dimensions;
    private final double weight;
    private final String address;
    private final boolean abilityToFlip;
    private final String number;
    private final boolean fragility;

    public CargoParameters(Dimensions dimensions, double weight, String address, boolean abilityToFlip, String number, boolean fragility){
        this.dimensions = dimensions;
        this.address = address;
        this.weight = weight;
        this.fragility = fragility;
        this.abilityToFlip = abilityToFlip;
        this.number = number;
    }


    public CargoParameters setWeight(int weight) {
        return new CargoParameters(dimensions,weight, address, abilityToFlip, number, fragility);
    }
    public CargoParameters setAddress(String address) {
        return new CargoParameters(dimensions,weight, address, abilityToFlip, number, fragility);
    }

    public String toString() {
        return "вес: " + weight + "\n" + "адрес: " + address + "\n" + "Возможно ли переворачивать: " + abilityToFlip + "\n" + "Номер груза: " + number + "\n" + "Хрупкий: " + fragility;
    }
    public int getWeight(int weight){
        return weight;
    }
    public  String getAddress(String address){
        return address;
    }


}
