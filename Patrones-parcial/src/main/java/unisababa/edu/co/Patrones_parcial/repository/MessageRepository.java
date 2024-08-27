package unisababa.edu.co.Patrones_parcial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unisababa.edu.co.Patrones_parcial.entity.Message;

public interface MessageRepository  extends JpaRepository<Message,Integer> {
}
