package com.bookapplication.adapter.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
//@FieldNameConstants
@Builder
@Entity
@Table(name = Book.TABLE)
public class Book implements Serializable {
    public static final String TABLE = "book";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @NotNull
    @Column(nullable = false, length = 100)
    private String nome;

    @NotNull
    @Column(nullable = false, length = 100)
    private String autor;

    @NotNull
    @Column(nullable = false, length = 100)
    private String categoria;

    @NotNull
    @Column(nullable = false, length = 100)
    private String tipo;
}
