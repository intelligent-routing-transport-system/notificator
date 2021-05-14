package br.com.smartservice.notificator.notificator.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
@RestController
@RequestMapping("test")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TestController {
    private final DataSource dataSource;

    @GetMapping("connection-db")
    public ResponseEntity<?> testConnectionDb() throws SQLException {
        Connection connection = dataSource.getConnection();
        String catalog = connection.getCatalog();
        log.info("Catalog: {}", catalog);
        return ResponseEntity.ok(catalog);
    }
}
