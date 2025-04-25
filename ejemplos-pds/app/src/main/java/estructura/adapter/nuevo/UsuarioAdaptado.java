package estructura.adapter.nuevo;

import estructura.adapter.legacy.Usuario;

class UsuarioAdaptado implements IUsuario {
    private Usuario usuarioLegacy;

    public UsuarioAdaptado(Usuario usuarioLegacy) {
        this.usuarioLegacy = usuarioLegacy;
    }

    @Override
    public String getRut() {
        return usuarioLegacy.getRut();
    }

    @Override
    public String getNombre() {
        return usuarioLegacy.getNombre();
    }

    @Override
    public int getEdad() {
        return usuarioLegacy.getEdad();
    }

    @Override
    public Perfil getPerfil() {
        if(usuarioLegacy.getPerfil().trim().toLowerCase().equals("admin")) {
            return Perfil.ADMIN;
        } 
        else if(usuarioLegacy.getPerfil().trim().toLowerCase().equals("user")) {
            return Perfil.USUARIO;
        }

        return Perfil.USUARIO;
    }
}
