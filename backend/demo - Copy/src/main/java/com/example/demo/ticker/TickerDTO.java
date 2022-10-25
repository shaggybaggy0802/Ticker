package com.example.demo.ticker;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class TickerDTO {
    private int id;
    private String value;
    private String date;
    private String pair;

    public TickerDTO() {
    }

    public TickerDTO(String pair, String value) {
        this.pair = pair;
        this.value = value;
        this.date = new Timestamp(System.currentTimeMillis()).toString().replaceAll("\\s", "_");
    }


}
