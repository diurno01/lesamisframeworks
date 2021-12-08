package com.lesamis.lesAmisSpring.models;

public class MensajeModel {
    private String mensaje;

    public MensajeModel(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
