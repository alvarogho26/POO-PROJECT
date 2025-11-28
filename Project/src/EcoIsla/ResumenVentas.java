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

    public void mostrarResumen(){
        System.out.println("Resumen del día:");
        for (int i = 0; i < 3; i++){
            System.out.println("Embarcación " + i);
            System.out.println("  Matutino: " + pasajesPorEmbarcacionPorHorario[i][0]);
            System.out.println("  Mediodía: " + pasajesPorEmbarcacionPorHorario[i][1]);
            System.out.println("  Vespertino: " + pasajesPorEmbarcacionPorHorario[i][2]);
            System.out.println("  Total recaudado: $" + totalDineroPorEmbarcacion[i]);
            System.out.println();
        }
        System.out.println("Total de dinero recaudado durante el día: $" + totalGeneral);
    }
}

