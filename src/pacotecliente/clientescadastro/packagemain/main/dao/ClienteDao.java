package pacotecliente.clientescadastro.packagemain.main.dao;

import pacotecliente.clientescadastro.packagemain.main.bean.Cliente;
import pacotecliente.clientescadastro.packagemain.main.util.Conector;
import pacotecliente.clientescadastro.packagemain.main.util.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao implements Dao {


    @Override
    public void insert(Object o) {
        Cliente cliente = (Cliente) o; //Cast para inserir com Object um objeto da classe Cliente;
        String sql = "insert into cliente (nome,endereco,municipio,cep,tel,cel,cpf,cnpj,genero)" +
                "values (?,?,?,?,?,?,?,?,?)";
        //Comando SQL para fazer a inserção no banco dos valores preenchidos no formulário (objeto Cliente);
        try {
            PreparedStatement prsmt = Conector.getConexao().prepareStatement(sql);
            prsmt.setString(1, cliente.getNome());
            prsmt.setString(2, cliente.getEndereco());
            prsmt.setString(3, cliente.getMunicipio());
            prsmt.setString(4, cliente.getCep());
            prsmt.setString(5, cliente.getTel());
            prsmt.setString(6, cliente.getCel());
            prsmt.setString(7, cliente.getCpf());
            prsmt.setString(8, cliente.getCnpj());
            prsmt.setString(9, cliente.getGenero());
            //PEGA OS VALORES DO OBJETO CLIENTE (GETS) E ATRIBUI AO CAMPO DA TABELA
            prsmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Object o) {
        Cliente cliente = (Cliente) o;
        String sql = "update cliente set nome=?,endereco=?,municipio=?,cep=?,tel=?,cel=?,cpf=?,cnpj=?,genero=? where id=?";
        //Comando SQL para fazer a atualização no banco dos valores alterados no formulário (objeto Clente);
        try {
            PreparedStatement prsmt = Conector.getConexao().prepareStatement(sql);
            prsmt.setString(1, cliente.getNome());
            prsmt.setString(2, cliente.getEndereco());
            prsmt.setString(3, cliente.getMunicipio());
            prsmt.setString(4, cliente.getCep());
            prsmt.setString(5, cliente.getTel());
            prsmt.setString(6, cliente.getCel());
            prsmt.setString(7, cliente.getCpf());
            prsmt.setString(8, cliente.getCnpj());
            prsmt.setString(9, cliente.getGenero());
            prsmt.setInt(10, cliente.getId());
            //Pega os valores do objeto Cliente (gets) e atribui aos campos (?) da tabela;
            prsmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Object o) {
        Cliente cliente = (Cliente) o;
        String sql = "delete from cliente where id=?"; //Comando SQL para fazer a exclusão no banco pelo campo chave primária - id;
        try{
            PreparedStatement prsmt = Conector.getConexao().prepareStatement(sql);
            //Faz a conexão com o banco e prepara o comando SQL;
            prsmt.setInt(1, cliente.getId());
            //Pega o valor do objeto Cliente (cliente.getId) e abribui ao campo chave primária - id;
            prsmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object select(int i) {
        Cliente cliente = new Cliente();
        //Faz a instância da classe Cliente;
        String sql = "select * from cliente where id=?";
        //Instrução SQL para seleção de registro específico da tabela cliente, pelo id;
        try {
            PreparedStatement ps = Conector.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery(); //java.sql.ResultSet
            while(rs.next()){
                //Laço de repetição para preencher com os dados do banco o objeto Cliente;
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setMunicipio(rs.getString("municipio"));
                cliente.setCep(rs.getString("cep"));
                cliente.setTel(rs.getString("tel"));
                cliente.setCel(rs.getString("cel"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setCnpj(rs.getString("cnpj"));
                cliente.setGenero(rs.getString("genero"));
                //"seta" os atributos da classe Cliente com os dados dos campos do banco - pega os dados do banco para pesquisa no formulário;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }

    @Override
    public List select() {
        List lista = new ArrayList();
        String sql = "select * from cliente"; //Instrução SQL para seleção de todos os registros da tabela Cliente;
        PreparedStatement prsmt;
        try{
            prsmt = Conector.getConexao().prepareStatement(sql);
            ResultSet rs = prsmt.executeQuery();
            while (rs.next()){
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setMunicipio(rs.getString("municipio"));
                cliente.setCep(rs.getString("cep"));
                cliente.setTel(rs.getString("tel"));
                cliente.setCel(rs.getString("cel"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setCnpj(rs.getString("cnpj"));
                cliente.setGenero(rs.getString("genero"));
                //"seta" os atributos da classe Cliente com os dados dos campos do banco;

                lista.add(cliente);
                //Adiciona à lista os dados do resultado do laço while;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
