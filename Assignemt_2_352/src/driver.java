import myNodeList.*;

public class driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] elements ={1,2,3,4,5,6,7,8};
        NodeList myList = new NodeList(elements);
        //test all implemented methods
        try{
        	//test first()
        	Position p1 = myList.first();
			System.out.println("the first element is: "+p1.element());
        	//test next()
        	Position p2 = myList.next(p1);
			System.out.println("the second element is: "+p2.element());
            //test last()
        	Position lastP = myList.last();
        	System.out.println("the last element is: "+lastP.element());
        	//test prev()
        	Position preP = myList.prev(lastP);
        	System.out.println("the second last element is: "+preP.element());
        	//test set()
        	int olde = myList.set(preP, 10);
        	System.out.println("the second last element after setting is: "+preP.element());
        	System.out.println("the old value of second last element is: "+olde);
        	//test addFirst()
        	p1=myList.addFirst(88);
        	System.out.println("the first element after addFirst() is: "+p1.element());
        	p2=myList.next(p1);
        	System.out.println("the second element after addFirst() is: "+p2.element());
        
        	int size = myList.getSize();
        	int counter = myList.getNumOfElements();
        	System.out.println("the size before expansion using double method: "+size);
        	System.out.println("the total of elements stored: "+counter);
        	//test expansion() under double rule and addLast()
        	lastP=myList.addLast(89);
        	System.out.println("the last element  after addLast is: "+lastP.element());
            size = myList.getSize();
        	counter = myList.getNumOfElements();
        	p1=myList.first();
        	System.out.println("the first element after expansion is: "+p1.element());
        	System.out.println("the size after expansion using double method: "+size);
        	for(int i = 0; i<10; ++i){
        		myList.addLast(i);
        	}
        	size = myList.getSize();
        	System.out.println("the size after expansion using double method again: "+size);
        	counter = myList.getNumOfElements();
        	System.out.println("the total of elements stored now: "+counter);
        	//test setExpansionRule() and the expansion under constant method
        	myList.setExpansionRule('c');
        	for(int i = 0;i< 20;++i){
        		myList.addLast(i);
        	}
            size = myList.getSize();
        	counter = myList.getNumOfElements();
        	p1=myList.first();
        	System.out.println("the first element after expansion is: "+p1.element());
        	System.out.println("the size after expansion using constant method: "+size);
        	System.out.println("the total of elements stored now: "+counter);
        	
            //test addBefore()
            myList.addBefore(p2, 100);
            //now the position stored after firstP should be changed to be the one storing 100 and the original secondP 
            //should be placed after the new secondP
            System.out.println("the second element before addBefore() is: "+p2.element());
            Position p3;
            p2 = myList.next(p1);
            p3 = myList.next(p2);
            System.out.println("the second element after addBefore() is: "+p2.element());
            System.out.println("the third element after addBefore() is: "+p3.element());
            //test addAfter()
            myList.addAfter(p2, 101);
            //now the position stored after secondP should be changed to be the one storing 101 and the original thirdP 
            //should be placed after the new thirdP
            System.out.println("the third element before addAfter() is: "+p3.element());
            p3 = myList.next(p2);
            Position p4;
            p4 = myList.next(p3);
            System.out.println("the third element after addBefore() is: "+p3.element());
            System.out.println("the forth element after addBefore() is: "+p4.element());
            Position p5;
            p5=myList.next(p4);
            System.out.println("the fifth element after addBefore() is: "+p5.element());		
            //test swap()
            myList.swap(p3, p4);
            System.out.println("the third element after swap() is: "+p3.element());
            System.out.println("the forth element after swap() is: "+p4.element());
            p5=myList.next(p4);
            System.out.println("the fifth element after addBefore() is: "+p5.element());
            //test delete()
            counter = myList.getNumOfElements();
            System.out.println("the total of elements before delete: "+counter);
            int elementDelete= myList.delete(p3);
            System.out.println("the value deleted is: "+ elementDelete);
            p3=myList.next(p2);
            System.out.println("the third element after delete() is: "+p3.element());
            counter = myList.getNumOfElements();
            System.out.println("the total of elements before delete: "+counter);
            //test truncate()
            size = myList.getSize();
            System.out.println("the size before truncate() : "+size);
            myList.truncate();
            size = myList.getSize();
            System.out.println("the size after truncate(): "+size);
        }
        catch(emptyListException e){
        	System.out.println(e.getMessage());
        }
        catch(inValidInputException e){
        	System.out.println(e.getMessage());
        }
        // test the amortized time of addLast()
        long t1,t2;
        NodeList testList1= new NodeList();
        NodeList testList2= new NodeList();
        //set expansion rule to be doubling
        try{testList1.setExpansionRule('d');}
        catch(inValidInputException e){};
        t1 = System.currentTimeMillis();   
        for(int i=0;i<10000;++i){
        	testList1.addLast(i);
        }
        t2 = System.currentTimeMillis();
        System.out.println("10000 add operation with doubling incremental strategy, T(n)/n = "+(t2-t1)/1000.0/10000);
        for(int i=0;i<10000;++i){
        	testList1.addLast(i);
        }
        t2 = System.currentTimeMillis();
        System.out.println("20000 add operation with doubling incremental strategy, T(n)/n = "+(t2-t1)/1000.0/20000);
        for(int i=0;i<10000;++i){
        	testList1.addLast(i);
        }
        t2 = System.currentTimeMillis();
        System.out.println("30000 add operation with doubling incremental strategy, T(n)/n = "+(t2-t1)/1000.0/30000);
        for(int i=0;i<10000;++i){
        	testList1.addLast(i);
        }
        t2 = System.currentTimeMillis();
        System.out.println("40000 add operation with doubling incremental strategy, T(n)/n = "+(t2-t1)/1000.0/40000);
        for(int i=0;i<10000;++i){
        	testList1.addLast(i);
        }
        t2 = System.currentTimeMillis();
        System.out.println("50000 add operation with doubling incremental strategy, T(n)/n = "+(t2-t1)/1000.0/50000);
        //set expansion rule to be constant
        try{testList2.setExpansionRule('c');}
        catch(inValidInputException e){};
        t1 = System.currentTimeMillis();   
        for(int i=0;i<10000;++i){
        	testList2.addLast(i);
        }
        t2 = System.currentTimeMillis();
        System.out.println("10000 add operation with constant incremental strategy, T(n)/n = "+(t2-t1)/1000.0/10000);
        for(int i=0;i<10000;++i){
        	testList2.addLast(i);
        }
        t2 = System.currentTimeMillis();
        System.out.println("20000 add operation with constant incremental strategy, T(n)/n = "+(t2-t1)/1000.0/20000);
        for(int i=0;i<10000;++i){
        	testList2.addLast(i);
        }
        t2 = System.currentTimeMillis();
        System.out.println("30000 add operation with constant incremental strategy, T(n)/n = "+(t2-t1)/1000.0/30000);
        for(int i=0;i<10000;++i){
        	testList2.addLast(i);
        }
        t2 = System.currentTimeMillis();
        System.out.println("40000 add operation with constant incremental strategy, T(n)/n = "+(t2-t1)/1000.0/40000);
        for(int i=0;i<10000;++i){
        	testList2.addLast(i);
        }
        t2 = System.currentTimeMillis();
        System.out.println("50000 add operation with constant incremental strategy, T(n)/n = "+(t2-t1)/1000.0/50000);
        
	}

}
