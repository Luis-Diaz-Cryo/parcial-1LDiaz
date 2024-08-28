package unisababa.edu.co.Patrones_parcial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import unisababa.edu.co.Patrones_parcial.entity.Messages;

public interface MessageRepository  extends JpaRepository<Messages,Integer> {
}
