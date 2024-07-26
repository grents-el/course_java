public class Elevator {
    private int currentFloor = 1;
    private int minFloor;
    private int maxFloor;

    public Elevator(int minFloor, int maxFloor) {
        this.maxFloor = maxFloor;
        this.minFloor = minFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }
    public void moveDown(){
        currentFloor = currentFloor > minFloor ? currentFloor - 1 : currentFloor;
    }
    public  void moveUp(){
        currentFloor = currentFloor < maxFloor ? currentFloor + 1 : currentFloor;
    }
    public void move(int floor){
        if (floor > maxFloor || floor < minFloor) {
            System.out.println("Введенного вами этажа несуществует");
        } else {
            while (currentFloor != floor){
                if (currentFloor < floor){
                    moveUp();
                    System.out.println(currentFloor);
                } else {
                    moveDown();
                    System.out.println(currentFloor);
                }
            }
        }
    }



}
