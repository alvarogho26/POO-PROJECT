package EcoIsla;

public class Admin {
    private String usuario;
    private String contrasena;

    public Admin(String usuario, String contrasena){
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public boolean iniciarSesion(String user, String pass){
        return this.usuario.equals(user) && this.contrasena.equals(pass);
    }

    public String verResumen(SistemaReservas sistema) {
        ResumenVentas resumen = sistema.generarResumen();
        return resumen.mostrarResumen();
    }
    
}
