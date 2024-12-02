package com.prova.domains.enums;

public enum Popularidade {
    BOA(0,"BOA"),MEDIA(1,"MEDIA"),RUIM(2,"RUIM");

    private Integer id;
    private String nota;

    Popularidade(Integer id, String nota) {
        this.id = id;
        this.nota = nota;
    }

    public Integer getId() { return id;
    }

    public void setId(Integer id) { this.id = id;
    }

    public String getNota() { return nota;
    }

    public void setNota(String nota) { this.nota = nota; }

    public static Popularidade toEnum(Integer id){
        if (id==null) return null;
        for(Popularidade x : Popularidade.values()){
            if(id.equals(x.getId())){
                return x;
            }
        }
        throw new IllegalArgumentException("Popularidade Inválida");
    }
}
