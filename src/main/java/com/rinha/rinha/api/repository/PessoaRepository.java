package com.rinha.rinha.api.repository;

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
}
