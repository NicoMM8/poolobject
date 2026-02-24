/**
 * 
 */
package ubu.gii.dass.c01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Disabled;


/**
 * @author Nicolas Muñoz Martín, Alejandro Navas García, Gaspar Campos-Ansó Fernández, Josué Gabriel Granados Hernández
 *
 */
public class ReusablePoolTest {

	
	@BeforeAll
	public static void setUp(){
	}
	
	@AfterAll
	public static void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#getInstance()}.
	 */
        @Test
        @DisplayName("testGetInstance")
	public void testGetInstance() {
		// Obtengo la instancia del pool
		ReusablePool pool1 = ReusablePool.getInstance();
		ReusablePool pool2 = ReusablePool.getInstance();
		// Y compruebo que no es nula
		assertNotNull(pool1);
		// Y compruebo que las dos instancias son la misma
		assertSame(pool1, pool2);
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#acquireReusable()}.
	 */
		@Test
        @DisplayName("testAcquireReusable")
	public void testAcquireReusable() throws Exception {

		ReusablePool pool = ReusablePool.getInstance(); 
		// Saco el primer objeto disponible del pool
		Reusable r1 = pool.acquireReusable();
		// Y compruebo que no es nulo este objeto
		assertNotNull(r1);
		// Y voy a probar el uso del objeto sacado del pool
		String mensaje = r1.util();
		// Y compruebo que el mensaje contiene el texto esperado
		assertTrue(mensaje.contains("Uso del objeto Reutilizable"));
		// El pool se crea con dos objetos de normal. Por lo que sacamos el segundo
		Reusable r2 = pool.acquireReusable();
		// Y compruebo que no es nulo este objeto
		assertNotNull(r2);
		// Y voy a probar el uso del objeto sacado del pool
		String mensaje2 = r2.util();
		// Y compruebo que el mensaje contiene el texto esperado
		assertTrue(mensaje2.contains("Uso del objeto Reutilizable"));
		// Y ahora voy a probar a sacar un tercer objeto. Como el pool de 2 ya se ha vaciado, saltaría la excepción
		assertThrows(NotFreeInstanceException.class, () -> {
			pool.acquireReusable();
		}, "Debería lanzar la excepción cuando el pool se vacía");
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#releaseReusable(ubu.gii.dass.c01.Reusable)}.
	 */
	@Test
        @DisplayName("testReleaseReusable")
        @Disabled("Not implemented yet")
	public void testReleaseReusable() {
		
	}

}
