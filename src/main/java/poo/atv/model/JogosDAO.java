
package poo.atv.model;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class JogosDAO {


    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize(){
        jdbc = new JdbcTemplate(dataSource);
    }

    public void inserirJogos(Jogos jog){
        String sql = "INSERT INTO jogos(nome,plataforma,zerado) VALUES(?,?,?)";
        Object[] parametros = new Object[3]; //Um para cada ?
        parametros[0] = jog.getNome();
        parametros[1] = jog.getPlataforma();
        parametros[2] = jog.isZerado();
        jdbc.update(sql,parametros);
    }
        public List<Map<String,Object>> puxarTodosJogos(){
        String sql = "SELECT * FROM jogos;";
        return jdbc.queryForList(sql);
    }

    public Map<String,Object> puxarJogos(int id){
        String sql = "SELECT * from jogos WHERE id = ?";
        return jdbc.queryForMap(sql, id);
    }

    public void atualizarJogos(int id, Jogos novo){
        String sql = "UPDATE jogos SET nome = ?, plataforma = ?, zerado = ? WHERE id = ?";
        Object[] parametros = new Object[4];
        parametros[0] = novo.getNome();
        parametros[1] = novo.getPlataforma();
        parametros[2] = novo.isZerado();
        parametros[3] = id;
        jdbc.update(sql,parametros);
    }

    public void deletar(int id){
        String sql = "DELETE FROM jogos WHERE id = ?";
        jdbc.update(sql,id);
    }


}




