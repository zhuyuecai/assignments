package myNodeList;
import myNodeList.Position;
import myNodeList.emptyListException;
import myNodeList.inValidInputException;
public class NodeList {
    private Position[] list;
    private char expand;
    private int size;
    private int counter;
    //default constructor
    public NodeList(){
    	this.list=new Position[10];
    	this.expand='d';
    	this.size=10;
    	this.counter=0;
    	
    }
    //constructor with an input of an array of elements
    public NodeList(int[] eList){
    	counter=eList.length;
    	this.list=new Position[10];
    	while (counter>=size){
    	    this.expansion();  
    	}
    	for(int i =0;i<counter;++i){
    		this.addLast(eList[i]);
    	}
    }
    //get expand rule
	public char getExpand() {
		return expand;
	}
	//set up the expansion rule manually 
	public void setExpansionRule(char expand) throws inValidInputException {
		if(expand == 'd'||expand == 'c'){
		this.expand = expand;
		}else{
			throw (new inValidInputException("wrong input, input should be either 'd' or 'c' !"));
		}
	}
	//return the total number of elements stored in the list
	public int getNumOfElements(){
		return counter;
	}
	// and a Position with the input element in the first place of the array and return the Position 
	public Position addFirst(int e){
		if (counter>=size){this.expansion();}
		for(int i = counter-1;i>=0;--i){
			
		}
		list[0] = new Position(e,0);
		return list[0];
	}
	//return the Position in the first place of the array
	public Position first() throws emptyListException{
		if ((f+1+size)%size==l){throw new emptyListException("the list is empty!");}
		else{return list[(f+1+size)%size];}
	}
	//return the Position in the last place of the array
	public Position last() throws emptyListException{
		if ((f+1+size)%size==l){throw new emptyListException("the list is empty!");}
		else{return list[(l-1+size)%size];}
	}
	//
	public Position addLast(int e){
		if (f==l){this.expansion();}
		list[l] = new Position(e);
		f=(l+1+size)%size;
		return list[(l-1+size)%size];
	}
/*	
	@Override
	public Iterator<Position> iterator() {
		// TODO Auto-generated method stub
		Iterator<Position> it = new Iterator<Position>(){
			private Position currentP = list[f];
			public boolean hasNext(){
				return currentP.getPro() != null;
			}
			public Position next(){
				currentP=currentP.getPro();
				return currentP.getPre();
			}
			@Override
			public void remove() {
				// TODO Auto-generated method stub
				
			}
		};
		return it;
	}
	*/
	//todo: expand the double end circular array 
	private void expansion(){
		Position[] newList;
		if (this.expand == 'd'){
			newList = new Position[this.size+10];
		}
		else{
			newList = new Position[this.size*2];
		}
		
        
		this.list=newList;
	}
    
}
