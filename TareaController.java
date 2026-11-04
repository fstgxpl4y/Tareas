import java.util.ArrayList;
import java.util.List;

public class TareaController {
    
    //atributos

    private List<Tarea> listaDeTareas = new ArrayList<Tarea>(); 

    private int contadorTareas;

    public TareaController(){
        contadorTareas = 0;
    }

    public Tarea agregarTarea(String titulo, String descripcion) {
        Tarea nueva = new Tarea(contadorTareas++, titulo, descripcion);
        listaDeTareas.add(nueva);
        return nueva;
    }

    public void completarTarea(int id) {
        if (id > contadorTareas){
            throw new IllegalArgumentException("No hay una tarea con el ID: " + id);
        }
        for (Tarea t : listaDeTareas) {
            if (t.getId() == id) {
                if (t.getCompletada()) {
                    throw new IllegalStateException("La tarea ya estaba completada.");
                }
                t.setCompletada(true);
            }
        }
        
    }


}
