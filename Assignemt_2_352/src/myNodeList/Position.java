package myNodeList;

public class Position {
    protected int value;
    //private int rank;
    public Position(){
    	value=0;
    	//rank=0;
    }
    /*
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (rank != other.rank)
			return false;
		return true;
	}
	*/
	public Position(int value){
    	this.value = value;
    	//this.rank=rank;
    }
    public int element(){
    	return this.value;
    }
    /*
    protected void setRank(int newRank){
    	this.rank=newRank;
    }
    protected int getRank(){
    	return rank;
    }
    */

}
