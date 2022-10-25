import React from "react";
import TickerService from "../services/TickerService";

class TickerComponent extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            tickers: [],
            BTCtickers: [],
            ETHtickers: [],
            ADAtickers: []
        }


    }

    componentDidMount() {
        TickerService.getTickers().then((Response) => {
            this.setState({ tickers: Response.data });
        });
        TickerService.getBTCTickers().then((Response) => {
            this.setState({ BTCtickers: Response.data });
        });
        TickerService.getETHTickers().then((Response) => {
            this.setState({ ETHtickers: Response.data });
        });
        TickerService.getADATickers().then((Response) => {
            this.setState({ ADAtickers: Response.data });
        });
    }

    render() {

        return (
            <section>
                
                <h1>All Tickers</h1>
                <div className="tbl-header">
                    <table cellPadding="0" cellSpacing="0" border="0">
                        <thead>
                            <tr>
                                <td className="width">ID</td>
                                <td>Pair</td>
                                <td>Date</td>
                                <td>Value</td>
                            </tr>
                        </thead>
                    </table>
                </div>
                <div className="tbl-content">
                    <table cellPadding="0" cellSpacing="0" border="0">
                        <tbody>
                            {
                                this.state.tickers.map(
                                    ticker =>
                                        <tr key={ticker.id}>
                                            <td>{ticker.id}</td>
                                            <td>{ticker.pair}</td>
                                            <td>{ticker.date}</td>
                                            <td>{ticker.value}</td>
                                        </tr>
                                )
                            }
                        </tbody>
                    </table>
                </div>

                <h1>BTCUSD Tickers</h1>
                <div className="tbl-header">
                    <table cellPadding="0" cellSpacing="0" border="0">
                        <thead>
                            <tr>
                                <td className="width">ID</td>
                                <td>Pair</td>
                                <td>Date</td>
                                <td>Value</td>
                            </tr>
                        </thead>
                    </table>
                </div>
                <div className="tbl-content">
                    <table cellPadding="0" cellSpacing="0" border="0">
                        <tbody>
                            {
                                this.state.BTCtickers.map(
                                    ticker =>
                                        <tr key={ticker.id}>
                                            <td>{ticker.id}</td>
                                            <td>{ticker.pair}</td>
                                            <td>{ticker.date}</td>
                                            <td>{ticker.value}</td>
                                        </tr>
                                )
                            }
                        </tbody>
                    </table>
                </div>

                <h1>ETHUSD Tickers</h1>
                <div className="tbl-header">
                    <table cellPadding="0" cellSpacing="0" border="0">
                        <thead>
                            <tr>
                                <td className="width">ID</td>
                                <td>Pair</td>
                                <td>Date</td>
                                <td>Value</td>
                            </tr>
                        </thead>
                    </table>
                </div>
                <div className="tbl-content">
                    <table cellPadding="0" cellSpacing="0" border="0">
                        <tbody>
                            {
                                this.state.ETHtickers.map(
                                    ticker =>
                                        <tr key={ticker.id}>
                                            <td>{ticker.id}</td>
                                            <td>{ticker.pair}</td>
                                            <td>{ticker.date}</td>
                                            <td>{ticker.value}</td>
                                        </tr>
                                )
                            }
                        </tbody>
                    </table>
                </div>

                <h1>ADAUSD Tickers</h1>
                <div className="tbl-header">
                    <table cellPadding="0" cellSpacing="0" border="0">
                        <thead>
                            <tr>
                                <td className="width">ID</td>
                                <td>Pair</td>
                                <td>Date</td>
                                <td>Value</td>
                            </tr>
                        </thead>
                    </table>
                </div>
                <div className="tbl-content">
                    <table cellPadding="0" cellSpacing="0" border="0">
                        <tbody>
                            {
                                this.state.ADAtickers.map(
                                    ticker =>
                                        <tr key={ticker.id}>
                                            <td>{ticker.id}</td>
                                            <td>{ticker.pair}</td>
                                            <td>{ticker.date}</td>
                                            <td>{ticker.value}</td>
                                        </tr>
                                )
                            }
                        </tbody>
                    </table>
                </div>

            </section>
        )
    }
}

export default TickerComponent