package com.hib.demoProj.Service;

import com.hib.demoProj.Entities.Stock;
import com.hib.demoProj.Repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    StockRepository stockRepository;


    public List<Stock> getStocks()
    {
        return stockRepository.getStocks();
    }
    public void saveorUpdateStock(Stock stock)
    {
        stockRepository.saveorUpdateStock(stock);
    }
    public void deleteStock(Stock stock)
    {
        stockRepository.deleteStock(stock);
    }
}
