package com.example.treenimuistio.repo;
import com.example.treenimuistio.model.Kayttaja;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KayttajaRepo extends JpaRepository<Kayttaja, Long> {
}
