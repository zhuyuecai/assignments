package myNodeList;
import java.util.Iterator;
import myNodeList.Position;
import myNodeList.emptyListException;
import myNodeList.inValidInputException;
public class NodeList implements Iterable<Position> {
    private Position[] list;
    private char expand;
    private int size;
    private int f,l;
    public NodeList(){
    	this.list=new Position[10];
    	this.expand='d';
    	this.size=10;
    	this.f=0;
    	this.l=0;
    }
	public char getExpand() {
		return expand;
	}
	public void setExpansionRule(char expand) throws inValidInputException {
		if(expand == 'd'||expand == 'c'){
		this.expand = expand;
		}else{
			throw (new inValidInputException("wrong input, input should be either 'd' or 'c' !"));
		}
	}
	//todo: add expansion rule
	public Position addFirst(int e){
		list[l] = new Position(e,list[f+1]);
		return list[f];
	}
	
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
	
	private void expansion(){
		Position[] newList;
		if (this.expand == 'd'){
			newList = new Position[this.size+10];
		}
		else{
			newList = new Position[this.size*2];
		}
		int counter =0;
		for(Position i : this){
			newList[counter++]=i;
		}
		this.list=newList;
	}
    
}
