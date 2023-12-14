package org.abi.characters.control;

import java.sql.SQLException;

import io.agroal.api.AgroalDataSource;
import io.quarkus.agroal.DataSource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CharacterBean {

    @Inject
    @DataSource("characters")
    AgroalDataSource characterDataSource;

    public final String CHARACTER_GET_SQL = 
            """
                select c.name, c.franchise 
                from `characters` c 
                where name = 'Samus'
            """;

    public String getCharacter() {

        String name = "";

        try (final var charConn = characterDataSource.getConnection();
             final var getStatement = charConn.prepareStatement(CHARACTER_GET_SQL);
             final var resultSet = getStatement.executeQuery()) {

            while (resultSet.next()) {

                name = resultSet.getString("name");
                final String franchise = resultSet.getString("franchise");
            }

            } catch (SQLException se) {
                System.out.println(se);
            }

        return name;
    }

    public String getSpecificCharacter(String name) {

        return "The character is " + name;
    }
    
}
