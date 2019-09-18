package com.hib.demoProj.Service;

import com.hib.demoProj.Entities.Stock;

import java.util.List;

public interface StockService {
    public List<Stock> getStocks();
    public void saveorUpdateStock(Stock stock);
    public void deleteStock(Stock stock);
}
