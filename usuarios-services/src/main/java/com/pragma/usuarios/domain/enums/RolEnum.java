package com.pragma.usuarios.domain.enums;

public enum RolEnum {
    ADMIN(1L,"ADMIN"),
    OWNER(2L,"OWNER"),
    EMPLOYEE(3L,"EMPLOYEE"),
    CUSTOMER(4L,"CUSTOMER");

    private Long valor;
    private String etiqueta;

    private RolEnum(Long valor, String etiqueta) {
        this.valor = valor;
        this.etiqueta = etiqueta;
    }

    public Long getValor() {
        return valor;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public static RolEnum obtenerEnumXCodigo(String value) {
        for (RolEnum estadoEnum : RolEnum.values()) {
            if(estadoEnum.getValor().equals(value)) {
                return estadoEnum;
            }
        }
        throw new IllegalArgumentException("No se encontró la acción ["+ value + "].");
    }

    @Override
    public String toString() {
        return etiqueta;
    }
}
