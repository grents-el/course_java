public final class Dimensions {
    private final int width;
    private final int length;
    private final int height;


    public Dimensions(int width, int length, int height){
        this.height = height;
        this.width = width;
        this.length = length;
    }
    public int calcVolume(){
        return height*width*length;
    }
    public Dimensions setWidth(int width){
        return new Dimensions(width, length, height);
    }
    public Dimensions setLength(int length){
        return new Dimensions(width, length, height);
    }
    public Dimensions setHeight(int height){
        return new Dimensions(width, length, height);
    }
    public String toString(){
        return "Габариты (ширина: " + width + " высота: " + height + " длина: " + length +")";
    }
    public int getWidth(int width){
        return width;
    }
    public int getLength(int length){
        return length;
    }
    public int getHeight(int height){
        return height;
    }

}
