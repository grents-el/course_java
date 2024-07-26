

public class Lines {

    private final String lineName;
    private final String lineNum;
    public Lines(String lineName, String lineNum){
        this.lineName=lineName;
        this.lineNum = lineNum;

    }
    @Override
    public String  toString() {
        return "Lines{" + "name='" + lineName +'\''+",lineNumber='"+lineNum+'\''+'}'+"\n";
    }
    public String getLineName(){
        return lineName;
    }
    public String getLineNum(){
        return lineNum;
    }


}
