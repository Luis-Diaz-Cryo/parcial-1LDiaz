package unisababa.edu.co.Patrones_parcial.entity;


import jakarta.persistence.*;
import lombok.Data;

@Table(name = "message")
@Entity
@Data
public class Message {

    @Id
    @Column
    private Integer id;

    @Column
    private String message;
}
