package EcoIsla;

public class Embarcacion{
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

    public boolean verificarAsiento(int[][] matriz, int fila, int col){
        if (fila < 0 || fila > 4 || col < 0 || col > 4){
            return false;
        }
        return matriz[fila][col] == 0;
    }

    public void reservarAsiento(int[][] matriz, int fila, int col){
        if (fila >= 0 && fila < 5 && col >= 0 && col < 5){
            matriz[fila][col] = 1;
        }
    }

    public int contarOcupado(int[][] matriz){
        int cont = 0;
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                if (matriz[i][j] == 1){
                    cont++;
                }
            }
        }
        return cont;
    }



    public String getNombre(){
        return nombreEmbarcacion;
    }

}
