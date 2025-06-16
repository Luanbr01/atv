
package poo.atv.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class jogosService {
    
    @Autowired
    JogosDAO cdao;

    public void inserirjogos(Jogos jog){
        cdao.inserirJogos(jog);
    }

    public List<Jogos> puxarTodosjogos(){
        return Jogos.converterVarios(cdao.puxarTodosJogos());
    }

    public void atualizarjogos(int id, Jogos novo){
        cdao.atualizarJogos(id, novo);
    }

    public Jogos puxarjogos(int id){
        return Jogos.converter(cdao.puxarJogos(id));
    }

    public void deletar(int id){
        cdao.deletar(id);
    }

}
