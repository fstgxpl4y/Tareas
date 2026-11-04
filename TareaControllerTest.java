import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TareaControllerTest {
    private TareaController controlador;

    @BeforeEach
    void setUp() {
        controlador = new TareaController();
    }

    @Test
    void testAgregarVariosElementosYRevisarIds() {
        Tarea t = controlador.agregarTarea("atender estudiantes","Ximena");
        Tarea t2 = controlador.agregarTarea("atender estudiantes","Luis Diego");
        Tarea t3 = controlador.agregarTarea("atender estudiantes","william");
        assertEquals(0, t.getId());
        assertEquals(1, t2.getId());
        assertEquals(2, t3.getId());
    }

    @Test
    void validarCambioDeEstado() {
        Tarea t3 = controlador.agregarTarea("atender estudiantes","william");
       
    }





}
