import java.util.ArrayList;
import java.util.List;

public class TareaController {
    
    public List<Tarea> listaDeTareas = new ArrayList<Tarea>();

    private int contadorTareas;

    public TareaController(){
        contadorTareas = 0;
    }

    public void agregarTarea(String titulo, String descripcion) {
        Tarea nueva = new Tarea(contadorTareas++, titulo, descripcion);
        listaDeTareas.add(nueva);

    }

    public void completarTarea(int id) {
        for(Tarea t : listaDeTareas){
            if (t.getId() == id) {
                if(t.getCompletada()){
                    throw new IllegalStateException("La tarea ya esta completada");
                }
                t.setCompletada(true);
            }
        }
        if (id > contadorTareas) {
            throw new IllegalArgumentException("No hay tarea con el id: " + id);
        }
    }
}
