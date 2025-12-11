package EcoIsla;

public class SistemaReservas {

    private Embarcacion[] embarcaciones;
    private Venta[] ventasDelDia;   
    private int ventasCount;
    private int[][] pasajesPorEmbarcacionPorHorario;
    private int[] totalDineroPorEmbarcacion;
    private int totalGeneral;

    private int maxVentas = 75;
    private int precio = 15000;

    public SistemaReservas(){
        embarcaciones = new Embarcacion[3];
        ventasDelDia = new Venta[maxVentas]; 
        pasajesPorEmbarcacionPorHorario = new int[3][3]; 
        totalDineroPorEmbarcacion = new int[3];
    }

    public void cargarDatos(){

        embarcaciones[0] = new Embarcacion(0, "Felipe");
        embarcaciones[1] = new Embarcacion(1, "Trauco");
        embarcaciones[2] = new Embarcacion(2, "Caleuchito");
    }

    public int buscarEmbarcacion(String nombre){
    for (int i = 0; i < embarcaciones.length; i++){
        if (embarcaciones[i].getNombre().equals(nombre)){
            return i;
        }
    }
    return 0;
}

    public int[][] obtenerMatriz(int idEmbarcacion, int horario){
        if (idEmbarcacion < 0 || idEmbarcacion >= embarcaciones.length) return null;
        Embarcacion e = embarcaciones[idEmbarcacion];
        if (e == null) return null;
        return e.getMatriz(horario);
    }

    public boolean venderPasajes(int idEmbar, int horario, String[] asientos, Cliente cliente){
    
    Embarcacion embar = embarcaciones[idEmbar];
    int[][] matriz = embar.getMatriz(horario);

    for (String etiqueta : asientos){
        int[] coordenada = etiquetaACoordenada(etiqueta);
        embar.reservarAsiento(matriz, coordenada[0], coordenada[1]); 
    }

    Venta v = new Venta(cliente, embar.getNombre(), idEmbar, horario, asientos);
    registrarVenta(v);

    pasajesPorEmbarcacionPorHorario[idEmbar][horario] += v.getCantidad();
    totalDineroPorEmbarcacion[idEmbar] += v.getTotal();
    totalGeneral += v.getTotal();

    return true;
}

    public static int[] etiquetaACoordenada(String etiqueta){
        if (etiqueta == null) return null;
        etiqueta = etiqueta.trim().toUpperCase();
        if (etiqueta.length() < 2) return null;
        char letra = etiqueta.charAt(0);
        if (letra < 'A' || letra > 'E') return null;
        String num = etiqueta.substring(1);
        int col;
        try { col = Integer.parseInt(num) - 1; }
        catch (NumberFormatException ex){ return null; }
        int fila = letra - 'A';
        if (col < 0 || col > 4) return null;
        return new int[]{fila, col};
    }

    public boolean registrarVenta(Venta v){
        if (ventasCount >= maxVentas) return false;
        ventasDelDia[ventasCount++] = v;
        return true;
    }

    public ResumenVentas generarResumen(){
        return new ResumenVentas(this.pasajesPorEmbarcacionPorHorario, this.totalDineroPorEmbarcacion, this.totalGeneral);
    }




    public Embarcacion[] getEmbarcaciones(){
        return embarcaciones;
    }

    public int[][] getPasajesPorEmbarcacionPorHorario() {
        return pasajesPorEmbarcacionPorHorario;
    }

    public int[] getTotalDineroPorEmbarcacion() {
        return totalDineroPorEmbarcacion;
    }

    public int getTotalGeneral() {
        return totalGeneral;
    }
}
