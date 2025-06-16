
package poo.atv.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Jogos {
    private int id;
    private String nome;
    private String plataforma;
    private boolean zerado;

    public Jogos(){

    }

    public Jogos(String nome, String plataforma, boolean zerado) {
        this.nome = nome;
        this.plataforma = plataforma;
        this.zerado = zerado;
    }

    public Jogos(int id, String nome, String plataforma, boolean zerado) {
        this.id = id;
        this.nome = nome;
        this.plataforma = plataforma;
        this.zerado = zerado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public boolean isZerado() {
        return zerado;
    }

    public void setZerado(boolean zerado) {
        this.zerado = zerado;
    }

    public static Jogos converter (Map<String,Object> registro){
        int id = (int) registro.get("id");
        String nome = (String) registro.get("nome");
        String plataforma = (String) registro.get("plataforma");
        Object zeradoObj = registro.get("zerado");
        boolean zerado = false; 
        if (zeradoObj instanceof Boolean) {
            zerado = (Boolean) zeradoObj;
        } else if (zeradoObj instanceof Number) { 
            zerado = ((Number) zeradoObj).intValue() == 1;
        } else if (zeradoObj instanceof String) { 
            zerado = Boolean.parseBoolean((String) zeradoObj); 
        }

        return new Jogos(id, nome, plataforma, zerado);
    }

        public static List<Jogos> converterVarios(List<Map<String,Object>> registros){
        ArrayList<Jogos> lista = new ArrayList<Jogos>();
        for(Map<String,Object> reg : registros){
            lista.add(converter(reg));
        }
        return lista;
    }








}
