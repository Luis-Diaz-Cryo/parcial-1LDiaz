package unisababa.edu.co.Patrones_parcial.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table
@Entity
@Data
public class Message {

    @Id
    @Column
    private Integer id;

    @Column
    private String message;
}
