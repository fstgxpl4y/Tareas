public class Tarea {
    
    private int id;
    private String titulo;
    private String descripcion;
    private boolean completada;

    public Tarea(String t, String c) {
        titulo = t;
        descripcion = c;
        completada = false;
    }

    void setCompletada(boolean estadoNuevo){
        completada = estadoNuevo;

    }

    boolean getCompletada(){
        return completada;
    }
}
