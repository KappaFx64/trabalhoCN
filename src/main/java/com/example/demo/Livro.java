package com.example.demo;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Container(containerName = "Livro")
public class Livro {

    @Id
    @PartitionKey
    @GeneratedValue
    private String id;
    private String autor;
    private LocalDate data;
    private String imagem;
    private String descricao;

    public Livro(String autor, LocalDate data, String imagem, String descricao) {
        this.autor = autor;
        this.data = data;
        this.imagem = imagem;
        this.descricao = descricao;
    }
}
