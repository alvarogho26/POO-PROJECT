package EcoIsla;

public class ResumenVentas {
    private int[][] pasajesPorEmbarcacionPorHorario;
    private int[] totalDineroPorEmbarcacion;
    private int totalGeneral;

    public ResumenVentas(int[][] pasajes, int[] dinero, int totalGeneral){
        this.pasajesPorEmbarcacionPorHorario = pasajes;
        this.totalDineroPorEmbarcacion = dinero;
        this.totalGeneral = totalGeneral;
    }

    public int getPasajesPorHorario(int idEmbarcacion, int horario){
        return pasajesPorEmbarcacionPorHorario[idEmbarcacion][horario];
    }

    public int getDineroPorEmbarcacion(int idEmbarcacion){
        return totalDineroPorEmbarcacion[idEmbarcacion];
    }

    public int getTotalGeneral(){
        return totalGeneral;
    }

    public String mostrarResumen() {
        String texto = "Reporte del día:\n\n";

        for (int i = 0; i < pasajesPorEmbarcacionPorHorario.length; i++){
            String nombre = "";
            if (i == 0) nombre = "Felipe";
            else if (i == 1) nombre = "Trauco";
            else nombre = "Caleuchito";

            texto += "Embarcación " + nombre + "\n";
            texto += "  Matutino: " + pasajesPorEmbarcacionPorHorario[i][0] + "\n";
            texto += "  Mediodía: " + pasajesPorEmbarcacionPorHorario[i][1] + "\n";
            texto += "  Vespertino: " + pasajesPorEmbarcacionPorHorario[i][2] + "\n";
            texto += "  Total recaudado: $" + totalDineroPorEmbarcacion[i] + "\n\n";
        }
        
        texto += "--------------------------------------\n";
        texto += "Total de dinero recaudado durante el día: $" + totalGeneral;

        return texto;
    }
}

