package com.task.util;

import com.task.domain.Classes;
import com.task.domain.Keywords;
import com.task.service.KeywordService;
import com.task.service.ServiceImpl;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class Test {
    public static void main(String[] args) {

        List list = new ServiceImpl<Classes>(Classes.class).getAll();
        for(Classes item : (List<Classes>)list)
            System.out.println(item.getId() + " " + item.getClassName() + " ");

        list = new ServiceImpl<Keywords>(Keywords.class).getAll();
        for(Keywords item : (List<Keywords>)list)
            System.out.println(item.getId() + " " + item.getKeyword() + " - " + item.getBinded_class().getClassName());

        Keywords item = new Keywords();
        item = new ServiceImpl<Keywords>(Keywords.class).get(1);
        System.out.println("First item");
        System.out.println(item.getId() + " " + item.getKeyword() + " - " + item.getBinded_class().getClassName());

        KeywordService service = new KeywordService(Keywords.class);
        if(service.isExist("")) {
            service.toggle();
            System.out.println(service.getResponse());
        }

    }
}
