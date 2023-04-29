package it.epicode.incendi.sonda;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.epicode.incendi.puntodiascolto.PuntoDiAscolto;

class SondaTest {

	private Sonda s = new Sonda();
	private Sonda s2 = new Sonda();
	private Sonda s3 = new Sonda();
	private PuntoDiAscolto p = new PuntoDiAscolto();
	@BeforeEach
	void setUp() throws Exception {
		s.setId_sonda(1l);
		s.setLat(100l);
		s.setLng(100l);
		s.setLivelloFumo(5);
		s.setPuntoDiAscolto(p);
		//paramentri sonda due
		s2.setId_sonda(2l);
		s2.setLat(200l);
		s2.setLng(200l);
		s2.setLivelloFumo(7);
		s2.setPuntoDiAscolto(p);
		//paramentri sonda 3
		s3.setId_sonda(3l);
		s3.setLat(300l);
		s3.setLng(300l);
		s3.setLivelloFumo(-10);
		s3.setPuntoDiAscolto(p);
	}

	@Test
	@DisplayName("test incendio")
	void testIncendio() {
		String r = s.controllaSituzione(); // "ok"
		String r2 = s2.controllaSituzione(); //"incendio in corso"
		assertEquals(r, "ok");
		assertEquals(r2, "incendio in corso");
		
	}
	@Test
	@DisplayName("test incendio 2")
	void testIncendio2() {
		String r = s.controllaSituzione(); // "ok"
		String r2 = s2.controllaSituzione(); //"incendio in corso"

		assertTrue(s2.isIncendioInCorso());
		assertFalse(s.isIncendioInCorso());
		
	}
	@Test
	@DisplayName("test manutenzione")
	void testManutenzione() {
		String r = s3.controllaSituzione(); // "problema di rilevamento"
	
		assertEquals(r, "problema di rilevamento");
	
		
	}

	@Test
	@DisplayName("test latitudine")
	void testGetLat() {
		long l = s.getLat();
		assertEquals(l,100l);
	}

	@Test
	@DisplayName("test longitudine")
	void testGetLng() {
		long l = s.getLng();
		assertEquals(l,100l);
	}

	@Test
	@DisplayName("test livello di fumo")
	void testGetLivelloFumo() {
		int i = s.getLivelloFumo();
		assertEquals(i,5);
	}

}
