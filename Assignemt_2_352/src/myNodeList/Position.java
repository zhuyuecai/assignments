package myNodeList;

public class Position {
    private int value;
    private int rank;
    public Position(){
    	value=0;
    	rank=0;
    }
    public Position(int value,int rank){
    	this.value = value;
    	this.rank=rank;
    }
    public int element(){
    	return this.value;
    }

}
