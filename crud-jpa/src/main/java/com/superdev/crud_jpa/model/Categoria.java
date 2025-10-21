package com.superdev.crud_jpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor @NoArgsConstructor
@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NonNull
    private String nome;

    @NonNull
    private boolean status;

    @OneToMany(mappedBy = "categoria")
    private List<Produto> produtos;
}
