package br.com.dio.dao;

import br.com.dio.BasicBasket;
import br.com.dio.model.StockInfo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BasicBasketDAO {
    private final List<BasicBasket> stock = new ArrayList<>();

    public List<BasicBasket> addBatch(final List<BasicBasket> baskets) {
        stock.addAll(baskets);
        return baskets;
    }

    public List<BasicBasket> remove(final int amount){
        stock.sort(Comparator.comparing(BasicBasket::price));
        return stock.subList(0, amount);
    }

    public StockInfo getInfo(){
        return new StockInfo(stock.size(), stock.stream().filter(b -> b.validate().isBefore(LocalDate.now())).count());
    }

    public List<BasicBasket> removeOutOfDate(){
        var outOfDate = stock.stream().filter(b -> b.validate().isBefore(LocalDate.now())).toList();
        stock.removeAll(outOfDate);
        return outOfDate;
    }

}
