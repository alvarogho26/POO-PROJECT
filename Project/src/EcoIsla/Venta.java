package EcoIsla;

public class Venta {
    private Cliente cliente;
    private String nombreEmbarcacion;
    private int idEmbarcacion;
    private int horario;
    private String[] asientos;  
    private int cantidad;
    private int total;

    public Venta(Cliente cliente, String nombreE, int idE, int horario, String[] asientos){
        this.cliente = cliente;
        this.nombreEmbarcacion = nombreE;
        this.idEmbarcacion = idE;
        this.horario = horario;
        this.asientos = asientos;
        this.cantidad = asientos.length;
        this.total = calcularTotal();
    }

    public int calcularTotal(){
        final int PRECIO = 15000;
        return cantidad * PRECIO;
    }

    public String resumenVenta(){
        return "Cliente: " + cliente.getNombreCliente() + "\n" + "Embarcación: " + nombreEmbarcacion + "\n" + "Horario: " + horario + "\n" + "Asientos: " + String.join(", ", asientos) + "\n" + "Cantidad: " + cantidad + "\n" + "Total: $" + total;
    }

    public int getTotal(){
        return total;
    }
    public int getHorario(){
        return horario;
    }
    public int getIdEmbarcacion(){
        return idEmbarcacion;
    }
    public int getCantidad(){
        return cantidad;
    }
}

