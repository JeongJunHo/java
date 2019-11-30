package edu.ssafy.chap07.two;

public class DisPatcher {
	public DisPatcher() {
		
	}
	
	public void go() {
		AquaMan aq = new AquaMan();
		toWalk(aq);
		toSwimming(aq);
		toFly(aq);
//		Animal a = new Animal();
//		Eagle ea = new Eagle();
//		Lion li = new Lion();
//		승우 a = new 승우();
//		어린승우 b = new 어린승우();
//		
//		toWalk(ea);
//		toWalk(b);
//		
//		toFly(ea);
//		toFly(b);
	}
	
	private void toSwimming(ISwim s) {
		s.swimming();
	}
	
	private void toFly(IFly f) {
		f.fly();
	}
	
	private void toWalk(Animal a) {
		a.walk();
	}
	
	public static void main(String[] args) {
		new DisPatcher().go();
	}
}
