import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TareaControllerTest {
    private TareaController controlador;

    @BeforeEach
    void setUp() {
        AlmacenarTareas almacenamiento = new AlmacenamientoMemoria();
        controlador = new TareaController(almacenamiento);
    }

    @Test
    void testAgregarVariosElementosYRevisarIds() {
        Tarea t = controlador.agregarTarea("atender estudiantes", "Ximena");
        Tarea t2 = controlador.agregarTarea("atender estudiantes", "Luis Diego");
        Tarea t3 = controlador.agregarTarea("atender estudiantes", "william");
        assertNotNull(t);
        assertEquals(0, t.getId());
        assertEquals(1, t2.getId());
        assertEquals(2, t3.getId());
        assertNotEquals(t.getId(), t2.getId());
        assertFalse(t.getCompletada());
    }

    @Test
    void validarCambioDeEstado() {
        Tarea t3 = controlador.agregarTarea("atender estudiantes", "william");
        controlador.completarTarea(t3.getId());
        assertTrue(t3.getCompletada());
    }

    @Test
    void testCompletarTareaInexistenteLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            controlador.completarTarea(99);
        });
    }

    @Test
    void testCompletarTareaYaCompletadaLanzaExcepcion() {
        Tarea t = controlador.agregarTarea("atender estudiantes", "Ximena");
        controlador.completarTarea(t.getId());
        assertThrows(IllegalStateException.class, () -> {
            controlador.completarTarea(t.getId());
        });
    }

    @Test
    void testEliminarTareaExistente() {
        Tarea t = controlador.agregarTarea("atender estudiantes", "Luis Diego");
        controlador.eliminarTarea(t.getId());
        assertNull(controlador.buscarTarea(t.getId()));
    }

    @Test
    void testEliminarTareaInexistenteLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            controlador.eliminarTarea(99);
        });
    }
}
