package com.hib.demoProj.Contollers;

import com.hib.demoProj.Entities.Stock;
import com.hib.demoProj.Entities.User;
import com.hib.demoProj.Repository.StockRepository;
import com.hib.demoProj.Repository.UserRepository;
import com.hib.demoProj.Service.StockService;
import com.hib.demoProj.Service.StockServiceImpl;

import com.hib.demoProj.Service.UserServiceImpl;
import io.reactivex.Observable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpLogging;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import rx.observables.MathObservable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    StockService stockService;

    @Autowired
    StockRepository stockRepository;
    @Autowired
    UserRepository userRepository;
    @RequestMapping("/s")
    void createmethod()
    {
        userRepository.createstock();
    }

    @RequestMapping(value = "getall", method = RequestMethod.GET)
    public String getStocks() {
        List<Stock> stocks = stockService.getStocks();
        return stocks.toString();
    }

    @RequestMapping(value = "saveStockmethod", method = RequestMethod.POST)
    public void saveStock(@RequestBody Stock stock) {
        stockService.saveorUpdateStock(stock);
    }

    @RequestMapping(value = "getByPrice/{price}", method = RequestMethod.GET)
    public List<Stock> getStockByPrice(@PathVariable int price) {
        List<Stock> stocks = stockService.getStocks();
        return stocks.stream().filter(a -> a.getPrice() > price).collect(Collectors.toList());
    }

    @RequestMapping(value = "deleteStock", method = RequestMethod.POST)
    public void deleteStock(@RequestBody Stock stock) {
        stockService.deleteStock(stock);
    }
    @RequestMapping(value = "st", method = RequestMethod.GET)
    public String viewStock() {

        List<User> empList = stockRepository.getallUsers();
        System.out.println("emp size: "+empList.size());
        System.out.println("---------------------------");
//        empList.stream().forEach(e -> {
//            e.setUserid(1);
//            e.getStocks().stream().forEach(System.out::println);
//            System.out.println("---------------------------");
//        });
        Set set=new HashSet<Stock>();
        for(User user1:empList)
        {
            set.add(user1.getStocks());
            System.out.println(set);
        }

        return set.toString();
    }

}

    /*@RequestMapping(value="obs", method = RequestMethod.POST)
    public void getS()
    {
        List<Stock> stocks=stockService.getStocks();
        Stock[] s= (Stock[]) stocks.toArray();
        Observable<Stock> observable = Observable.fromIterable(stocks);

        MathObservable
                .(stocks.sort((stock, t1) -> stock.getPrice());)
                .subscribe(new Subscriber<Stock>() {


                    @Override
                    public void onSubscribe(Subscription s) {

                    }

                    @Override
                    public void onNext(Stock stock) {

                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                }




}
*/