package com.example.demo.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "funcionarios")
public class Funcionario {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column (nullable = false, length = 100)
        private String nome;

        @Column (nullable = false, unique = true)
        private String telefone;

        @Column (nullable = false)
        private BigDecimal salario;
}
