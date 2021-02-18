package refactorizando.blog;

import refactorizando.blog.model.Usuario;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {

    /**
     * Ejemplo de como refactorizar
     * Buscaremos en la lista de usuarios si el usuario Jhon Smith esta entre ellos
     * Y de ser asi, si su monto es mayor a 100
     *
     */
    private static String nombre="John";
    private static String apellido="Smith";
    public static void main(String[] args) {
        List<Usuario> listaUsuario=generarUsuarios();
        System.out.println( buscarUsuarioSinRefactorizar(listaUsuario));
        System.out.println(buscarUsuarioRefactorizado(listaUsuario));
    }

    public static Boolean buscarUsuarioSinRefactorizar(List<Usuario> usuarios){
        Usuario jonhSmith=new Usuario();
        for (int i=0;i<usuarios.size();i++){
            if(usuarios.get(i).getNombreUsuario()==nombre && usuarios.get(i).getApellidoPaterno()==apellido){
                jonhSmith=usuarios.get(i);
            }
        }
        if (jonhSmith.getBalance().intValue()>100){
            return true;
        }else{
            return false;
        }
    }

    public static Boolean buscarUsuarioRefactorizado(List<Usuario>usuarios){
        return usuarios.stream()
        .anyMatch(usuario ->
                usuario.getNombreUsuario().equals(nombre) && usuario.getApellidoPaterno().equals(apellido) && usuario.getBalance().intValue()>100);

    }

    public static List<Usuario> generarUsuarios(){
        List<Usuario> listaUsuario= new ArrayList<>();
        Usuario usuario1=new Usuario();
        usuario1.setNombreUsuario("Pedro");
        usuario1.setApellidoPaterno("Paramo");
        usuario1.setBalance(new BigDecimal("100.00"));
        usuario1.setId(UUID.randomUUID());
        listaUsuario.add(usuario1);
        Usuario usuario2=new Usuario();
        usuario2.setNombreUsuario("John");
        usuario2.setApellidoPaterno("Smith");
        usuario2.setBalance(new BigDecimal("110.00"));
        usuario2.setId(UUID.randomUUID());
        listaUsuario.add(usuario2);
        Usuario usuario3=new Usuario();
        usuario3.setNombreUsuario("Madhu");
        usuario3.setApellidoPaterno("Kumar");
        usuario3.setBalance(new BigDecimal("100.00"));
        usuario3.setId(UUID.randomUUID());
        listaUsuario.add(usuario3);
        return listaUsuario;
    }
}
