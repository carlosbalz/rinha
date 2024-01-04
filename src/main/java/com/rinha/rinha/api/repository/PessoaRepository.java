package com.rinha.rinha.api.repository;

import com.rinha.rinha.model.Pessoa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class PessoaRepository {

    private static final Logger logger = LoggerFactory.getLogger(PessoaRepository.class);
    public int countPessoas() {
        try(Connection connection = DriverManager.getConnection("jdbc:postgresql://db:5432/rinha","cbalz","123");
            Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery("SELECT COUNT(*) AS TOTAL FROM PESSOA");
            if(result.next()) {
                return result.getInt("total");
            }
        } catch (SQLException e) {
            logger.error("an error while trying to execute a sql on the database", e);
        }
        return 0;
    }

    public void createPessoa(Pessoa pessoa) {
        try(Connection connection = DriverManager.getConnection("jdbc:postgresql://db:5432/rinha","cbalz","123");
            PreparedStatement statement = connection.prepareStatement("INSERT INTO PESSOA (APELIDO, NOME, NASCIMENTO) VALUES (?, ?, ?)")) {
            statement.setString(1, pessoa.getApelido());
            statement.setString(2, pessoa.getNome());
            statement.setString(3, pessoa.getNascimento());
            statement.execute();
        } catch (SQLException e) {
            logger.error("an error while trying to create a person", e);
        }
    }
}
