package unisababa.edu.co.Patrones_parcial.entity;


import jakarta.persistence.*;
import lombok.Data;

@Table
@Entity
@Data
public class Messages {

    @Id
    @Column
    private Integer id;

    @Column
    private String message;
}
