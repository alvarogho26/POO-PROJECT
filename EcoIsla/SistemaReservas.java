package EcoIsla;

public class SistemaReservas {

    private Embarcacion[] embarcaciones;

    public SistemaReservas(){
        embarcaciones = new Embarcacion[3];
    }

    public void cargarDatos(){

        embarcaciones[0] = new Embarcacion(0, "Felipe");
        embarcaciones[1] = new Embarcacion(1, "Trauco");
        embarcaciones[2] = new Embarcacion(2, "Caleuchito");
    }

}
