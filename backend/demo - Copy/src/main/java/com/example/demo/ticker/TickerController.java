package com.example.demo.ticker;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1/")
public class TickerController {

    private static Logger logger = LogManager.getLogger(TickerController.class);
    private final TickerService tickerService;
    private final ObjectMapper objectMapper = new ObjectMapper();


    /**
     *
     * @param tickerService
     */
    @Autowired
    public TickerController(TickerService tickerService){
        this.tickerService = tickerService;
    }

    /**
     *
     * @return
     */
    @GetMapping("/tickers")
    public List<TickerDTO> getTickers(){
        List<TickerDTO> result = new ArrayList<TickerDTO>();
        List<Ticker> data = tickerService.getAllTickers();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        //za svaki ticker u data pretovrit ga u tickerDTO i gurnut ga u result listu
        //razmisli o object mapperu
        for (int i = 0; i < data.size(); i++) {
            TickerDTO tickerDTO = objectMapper.convertValue(data.get(i), TickerDTO.class);
            result.add(tickerDTO);
        }
        logger.info("Getting All Ticker Pairs");
        return result;
    }

    /**
     *
     * @param date
     * @param pair_name
     * @return
     */
    @GetMapping("/tickers/{date}/{pair_name}")
    public ResponseEntity getTickersByDateAndPair(@PathVariable String date, @PathVariable String pair_name){
            List<TickerDTO> result = new ArrayList<TickerDTO>();
            List<Ticker> data = tickerService.getTickersByDateAndPair(date, pair_name);
            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            for (int i = 0; i < data.size(); i++) {
                TickerDTO tickerDTO = objectMapper.convertValue(data.get(i), TickerDTO.class);
                result.add(tickerDTO);
            }
            if(result.size() == 0){
                logger.error("Wrong Date or Pair Name");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("400 - DATE AND PAIR DON'T EXIST");
            }
            else {
                logger.info("Getting Date Name Ticker Pairs");
                return new ResponseEntity<>(result,HttpStatus.OK);
            }

    }

    /**
     *
     * @param pair_name
     * @return
     */
    @GetMapping("/tickers/{pair_name}")
    public ResponseEntity getTickersByPair(@PathVariable String pair_name){
            List<TickerDTO> result = new ArrayList<TickerDTO>();
            List<Ticker> data = tickerService.getTickersByPair(pair_name);
            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            for (int i = 0; i < data.size(); i++) {
                TickerDTO tickerDTO = objectMapper.convertValue(data.get(i), TickerDTO.class);
                result.add(tickerDTO);
            }
            if(result.size() == 0){
                logger.error("Wrong Pair Name");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("400 - PAIR NAME DOESN'T EXIST");
            }
            else {
                logger.info("Getting Name Ticker Pairs");
                return new ResponseEntity<>(result,HttpStatus.OK);
            }
    }


}
