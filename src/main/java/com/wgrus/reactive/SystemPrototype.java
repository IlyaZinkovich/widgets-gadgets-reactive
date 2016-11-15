package com.wgrus.reactive;

import com.wgrus.reactive.catalog.Catalog;
import com.wgrus.reactive.catalog.gadget.GadgetCatalog;
import com.wgrus.reactive.catalog.widget.WidgetCatalog;
import com.wgrus.reactive.input.callcenter.CallCenter;
import com.wgrus.reactive.input.web.Website;
import com.wgrus.reactive.system.OrderTransformer;
import rx.schedulers.Schedulers;

import java.util.List;

import static com.wgrus.reactive.system.OrderItem.Type.GADGET;
import static com.wgrus.reactive.system.OrderItem.Type.WIDGET;
import static java.util.Arrays.asList;
import static rx.Observable.merge;

public class SystemPrototype {

    public static void main(String[] args) throws InterruptedException {

        List<Catalog> catalogs = asList(new WidgetCatalog(), new GadgetCatalog());

        Website website = new Website(catalogs);
        CallCenter callCenter = new CallCenter(catalogs);

        OrderTransformer orderTransformer = new OrderTransformer();

        merge(website.getOrders().map(order -> orderTransformer.transform(order, WIDGET)),
                callCenter.getOrders().map(order -> orderTransformer.transform(order, GADGET)))
                .subscribeOn(Schedulers.io())
                .subscribe(System.out::println, System.out::println);

        while (true) {

        }
    }
}