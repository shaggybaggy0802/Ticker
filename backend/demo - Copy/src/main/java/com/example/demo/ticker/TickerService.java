package com.example.demo.ticker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.List;

@Service
public class TickerService {

    private static Logger logger = LogManager.getLogger(TickerService.class);
    static final String[] enabledPairs = {"btcusd", "ethusd", "adausd"};
    private final TickerRepository tickerRepository;

    private final TickerPairFetcher tickerPairFetcher;


    @Autowired
    public TickerService(TickerRepository tickerRepository, TickerPairFetcher tickerPairFetcher) {
        this.tickerRepository = tickerRepository;
        this.tickerPairFetcher = tickerPairFetcher;
    }

    public String[] getEnabledPairs(){
        return enabledPairs;
    }

    public List<Ticker> getAllTickers() {
        return tickerRepository.findAll();
    }

    public List<Ticker> getTickersByPair(String pair) {
        return tickerRepository.findByPair(pair);
    }

    public List<Ticker> getTickersByDateAndPair(String date, String pair) {
        return tickerRepository.findByPairAndDate(pair, date);
    }


//    @Scheduled(cron = "0 0/2 * * * *")
    @Scheduled(fixedRate = 5000)
    public void insertTicker() {
        for (String pair : enabledPairs) {
            Ticker tickerBTC = new Ticker(pair, tickerPairFetcher.getTickerValue(pair));
            this.tickerRepository.save(tickerBTC);
            logger.info("A Ticker Has Been Inserted");
        }
    }
}