package com.example.demo.ticker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TickerRepository extends JpaRepository<Ticker, String> {
    List<Ticker> findByPair(String name);
    List<Ticker> findByPairAndDate(String name, String date);
}
