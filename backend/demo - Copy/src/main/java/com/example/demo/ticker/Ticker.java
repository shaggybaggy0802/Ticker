package com.example.demo.ticker;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table
@Data
public class Ticker {
    @Id
    @SequenceGenerator(
            name = "ticker_sequence",
            sequenceName = "ticker_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ticker_sequence"
    )
    private int id;
    @Column()
    private String value;

    @Column()
    private String date;

    @Column()
    private String pair;

    @Column()
    private String leo;

    public Ticker() {
    }

    /**
     *
     * @param pair
     * @param value
     */
    public Ticker(String pair, String value) {
        this.pair = pair;
        this.value = value;
        this.date = new Timestamp(System.currentTimeMillis()).toString().replaceAll("\\s", "_");
    }


}
