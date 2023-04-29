package it.epicode.incendi.centrodicontrollo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CentroDiControlloTest {
	
    CentroDiControllo c;
    CentroDiControllo c1;
	@BeforeEach
	void setUp() throws Exception {
		c = CentroDiControlloFactory.setTipo("fuoco");
		c1 = CentroDiControlloFactory.setTipo("fuoco");
		
	}

	@Test
	@DisplayName("Controllo del tipo generato dal factory")
	void testSetTipo() {
		assertTrue(c instanceof CentroDiControlloVigiliDelFuoco);
	}
	@Test
	@DisplayName("Controllo che Factory generi istanze diverse")
	void testGenerazioneDiIstanzeDiverse() {
		assertTrue(c instanceof CentroDiControlloVigiliDelFuoco);
		assertTrue(c1 instanceof CentroDiControlloVigiliDelFuoco);
		assertSame(c, c);
		assertSame(c1, c1);
		assertNotSame(c, c1);
	}

}
