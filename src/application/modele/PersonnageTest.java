package src.application.modele;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonnageTest {

	@Test
	public final void testPerdrePv() {
		Personnage p = new Hero(50,50,null);
		p.perdrePv(5);
		assertEquals(95, p.getPv(), "cas Hero 100 PV se prend un coup de 5 PV");
		
		Personnage p2 = new Hero(50,50,null);
		p2.perdrePv(120);
		assertEquals(0, p2.getPv(), "cas degat plus important que PV restant du hero");
		
		Personnage p3 = new Hero(50,50,null);
		p3.perdrePv(100);
		assertEquals(0, p3.getPv(), "cas degat égal au PV du hero");
		
	}
	
	@Test
	public final void testSetPv() {
		Personnage p = new Hero(50,50,null);
		p.setPv(p.getPv()+20);
		assertEquals(100, p.getPv(), "cas surcharge PV");
		
		Personnage p2 = new Hero(50,50,null);
		p2.setPv(-120);
		assertEquals(0, p2.getPv(), "cas degat plus important que PV restant du hero");
		
		Personnage p3 = new Hero(50,50,null);
		p3.setPv(-100);
		assertEquals(0, p3.getPv(), "cas degat égal au PV du hero");
		
		Personnage p4 = new Hero(50,50,null);
		p4.setPv(50);
		assertEquals(50, p4.getPv(), "cas normal");
		
		p4.setPv(p4.getPv()+20);
		assertEquals(70, p4.getPv(),"cas regain de PV");
		
	}

}
