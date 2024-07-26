

public class Stations {
    public String stName;
    public String stNum;
    public boolean hasTransition;


    public Stations(String stName, String stNum, Object o, Object o1, boolean hasTransition) {
        this.stName = stName;
        this.stNum = stNum;
        this.hasTransition=hasTransition;
    }

    public String getStName(){
        return stName;
    }
    public boolean getHasTransition(){
        return hasTransition;
    }

    public String  toString() {
        return "Station{" + "name='" + stName +'\''+",lineNumber='"+stNum+'\''+ hasTransition+'}'+"\n";
    }

    public String getStNum() {
        return stNum;
    }
    public boolean getConn(){
        return hasTransition;
    }
}

