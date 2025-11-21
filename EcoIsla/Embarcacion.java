package EcoIsla;

public class Embarcacion {
    private int idEmbarcacion;
    private String nombreEmbarcacion;
    private int[][] matutino;
    private int[][] mediodia;
    private int[][] vespertino;

    public Embarcacion(int id, String nombre){
        this.idEmbarcacion = id;
        this.nombreEmbarcacion = nombre;
        this.matutino = new int[5][5];
        this.mediodia = new int[5][5];
        this.vespertino = new int[5][5];
    }

    public int[][] getMatriz(int horario){
        switch(horario){
            case 0: return matutino;
            case 1: return mediodia;
            case 2: return vespertino;
            default: return null;
        }
    }
}
