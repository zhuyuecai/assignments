package myNodeList;
import myNodeList.Position;
import myNodeList.emptyListException;
import myNodeList.inValidInputException;
public class NodeList {
    private Position[] list;
    private char expand;
    private int size;
    //private int counter;
    private int f,l;
    //default constructor
    public NodeList(){
    	this.size=10;
    	this.list=new Position[size];
    	this.expand='d';
    	//this.counter=0;
    	this.f=0;
    	this.l=0;
    	
    }
    //constructor with an input of an array of elements
    public NodeList(int[] eList){
    	//counter=eList.length;
    	this.size=10;
    	this.list=new Position[10];
    	while (eList.length>=size){
    	    this.expansion();  
    	}
    	this.f=0;
    	this.l=0;
    	for(int i =0;i<eList.length;++i){
    		this.addLast(eList[i]);
    	}
    	
    	
    }
    //get expand rule
	public char getExpand() {
		return expand;
	}
	public int getSize(){
		return list.length;
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
		return (l-f+size)%size;
	}
	// and a Position with the input element in the first place of the array and return the Position 
	public Position addFirst(int e){
	    f=(f-1+size)%size;
		list[f] = new Position(e);
		if (f==l){this.expansion();}
		return list[f];
	}
	//return the Position in the first place of the array
	public Position first() throws emptyListException{
		if (f==l){throw new emptyListException("the list is empty!");}
		else{return list[f];}
	}
	//return the Position in the last place of the array
	public Position last() throws emptyListException{
		if (l==f){throw new emptyListException("the list is empty!");}
		else{return list[(l-1+size)%size];}
	}
	//
	public Position addLast(int e){
		list[l] = new Position(e);
		l=(l+1+size)%size;
		if (l==f){this.expansion();}
		return list[(l-1+size)%size];
	}
	public Position prev(Position P) throws inValidInputException{
		int index=this.findPosition(P);
		
		if (index == f){throw (new inValidInputException("The input position is the first position, no preceding position!"));}
		else{
			index=(index-1+size)%size;
		}
		return list[index];
	}
	
	public Position next(Position P) throws inValidInputException{
		int index=this.findPosition(P);
		if (index == ((l-1+size)%size)){throw (new inValidInputException("The input position is the last position, no following position!"));}
		else{
			index=(index+1+size)%size;
		}
		return list[index];
	}
	public int set(Position p,int e){
		//int index=this.findPosition(p);
		int re = p.element();
		//Position newP=new Position(e);
		//list[index]=newP;
		//p = newP;
		p.value=e;
		return re;
	}
	
	public Position addBefore(Position p,int e){
		int index=this.findPosition(p);
		this.moveElementsForward(index);
		Position newP= new Position(e);
		list[index]=newP;
		if (l==f){this.expansion();}
		return newP;
	}
	public Position addAfter(Position p,int e){
		int index=this.findPosition(p);
		index=(index+1+size)%size;
		this.moveElementsForward(index);
		Position newP= new Position(e);
		list[index]=newP;
		if (l==f){this.expansion();}
		return newP;
	}
	public void swap(Position p1,Position p2){
		//int index1=this.findPosition(p1);
		//int index2=this.findPosition(p2);
		int e1 = p1.element();
		int e2 = p2.element();
		p1.value=e2;
		p2.value=e1;
		//Position np1= new Position(e2);
		//Position np2= new Position(e1);
		//list[index1]=np1;
		//list[index2]=np2;
	}
	public int delete(Position p){
		int e=p.element();
		int index = this.findPosition(p);
		int count=(l-index+size)%size;
		for(int i =0;i<count;++i){
			list[(index+i+size)%size]=list[(index+i+1+size)%size];
		}
		l=(l-1+size)%size;
		return e;
	}
	public void truncate(){
		int newS=this.getNumOfElements();
		Position[] newList = new Position[newS];
		for (int i=0;i<newS;++i){
			newList[i]=list[(f+i+size)%size];
		}
	    list=newList;
	    size=list.length;
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
	//todo: expand the circular array f==l and list[f] is always the first position
	private void expansion(){
		Position[] newList;
		int newSize=0;
		if (this.expand == 'c'){
			newSize=this.size+10;
			newList = new Position[newSize];
		}
		else{
			newSize=this.size*2;
			newList = new Position[newSize];
		}
		if (list[f]!=null){
		    for(int i=0;i<size;++i){
			    newList[i]=list[(f+i+size)%size];
		    }
		    this.l=size;
		}else{
			this.l=0;
		}
        this.f=0;
        this.size=newSize;
		this.list=newList;
		
	}
	//move all elements after startFrom(including startFrom) one step forward
	private void moveElementsForward(int startFrom){
	    int i = (l-1+size)%size;
	    while(i>=startFrom){
	    	list[(i+1+size)%size]=list[i];
	    	i=(i-1+size)%size;
	    }
	    l=(l+1+size)%size;
	}
	//return the array index of p
    private int findPosition(Position p){
    	int index=0;
    	int count=this.getNumOfElements();
    	for(int i=0;i<count;++i){
    		index=(f+i+size)%size;
    		if (list[index]==p){
    			break;
    		}
    	}
    	return index;
    }
}
