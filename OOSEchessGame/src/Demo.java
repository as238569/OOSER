
public class Demo {

	 public static void main(String[] args) {
		 
			
	        System.out.println("Hello! Chess!");
	        
	        Player p1 = new  Player("321");
	        Player p2 = new  Player("321");	        
	        ChChessBoard ccb = new  ChChessBoard ();
	        
	        
	        ccb.newGameFactory(p1,p2);
	        System.out.println(ccb.getTotalInfo());

	        		

	        
	 }
}
