import axios from "axios";

const TICKERS_REST_API_URL = 'http://localhost:8080/api/v1/tickers';

const BTC_TICKERS_REST_API_URL = 'http://localhost:8080/api/v1/tickers/btcusd';

const ETH_TICKERS_REST_API_URL = 'http://localhost:8080/api/v1/tickers/ethusd';

const ADA_TICKERS_REST_API_URL = 'http://localhost:8080/api/v1/tickers/adausd';

class TickerService{
    getTickers(){
        return axios.get(TICKERS_REST_API_URL);
    }

    getBTCTickers(){
        return axios.get(BTC_TICKERS_REST_API_URL);
    }

    getETHTickers(){
        return axios.get(ETH_TICKERS_REST_API_URL);
    }

    getADATickers(){
        return axios.get(ADA_TICKERS_REST_API_URL);
    }
}

export default new TickerService();