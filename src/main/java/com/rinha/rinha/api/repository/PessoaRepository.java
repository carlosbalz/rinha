package com.rinha.rinha.api.repository;

import com.rinha.rinha.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {

//    private static final Logger logger = LoggerFactory.getLogger(PessoaRepository.class);
//    public int countPessoas() {
//        try(Connection connection = DbUtils.getConnection();
//            Statement statement = connection.createStatement()) {
//            ResultSet result = statement.executeQuery("SELECT COUNT(*) AS TOTAL FROM PESSOA");
//            if(result.next()) {
//                return result.getInt("total");
//            }
//        } catch (SQLException e) {
//            logger.error("an error while trying to execute a sql on the database", e);
//        }
//        return 0;
//    }
//
//    public void createPessoa(Pessoa pessoa) {
//        try(Connection connection = DbUtils.getConnection();
//            PreparedStatement statement = connection.prepareStatement("INSERT INTO PESSOA (APELIDO, NOME, NASCIMENTO) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
//            statement.setString(1, pessoa.getApelido());
//            statement.setString(2, pessoa.getNome());
//            statement.setString(3, pessoa.getNascimento());
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            logger.error("an error while trying to create a person", e);
//        }
//    }
}
