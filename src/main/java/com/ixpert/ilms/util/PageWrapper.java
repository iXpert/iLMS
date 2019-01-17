package com.ixpert.ilms.util;


import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class PageWrapper<T> {

    public static final int MAX_PAGE_ITEMS_DISPLAY = 15;

    public class PageItem{
        private int number;
        private boolean current;
        public PageItem(int number, boolean current){
            this.current = current;
            this.number = number;
        }

        public int getNumber(){
            return this.number;
        }

        public boolean isCurrent(){
            return this.current;
        }
    }

    private Page<T> page;
    private List<PageItem> items;
    private int currentNumber;
    private String url;

    public String getUrl(){
        return this.url;
    }

    public PageWrapper(Page<T> page, String url){
        this.page = page;
        this.url = url;
        items = new ArrayList<PageItem>();

        currentNumber = page.getNumber() + 1; // start from 1 to match page.page

        int start, size;
        if (page.getTotalPages() <= MAX_PAGE_ITEMS_DISPLAY){
            start = 1;
            size = page.getTotalPages();
        } else {
            if (currentNumber <= MAX_PAGE_ITEMS_DISPLAY - MAX_PAGE_ITEMS_DISPLAY/2){
                start = 1;
                size = MAX_PAGE_ITEMS_DISPLAY;
            } else if (currentNumber >= page.getTotalPages() - MAX_PAGE_ITEMS_DISPLAY/2){
                start = page.getTotalPages() - MAX_PAGE_ITEMS_DISPLAY + 1;
                size = MAX_PAGE_ITEMS_DISPLAY;
            } else {
                start = currentNumber - MAX_PAGE_ITEMS_DISPLAY/2;
                size = MAX_PAGE_ITEMS_DISPLAY;

            }
        }

        for (int i=0;i<size;i++){
            items.add(new PageItem(start+1, (start+1) == currentNumber));
        }
    }

    public List<PageItem> getItems(){
        return this.items;
    }

    public int getNumber(){
        return currentNumber;
    }

    public List<T> getContent(){
        return page.getContent();
    }

    public int getSize(){
        return page.getSize();
    }

    public int getTotalPages(){
        return page.getTotalPages();
    }

    public boolean isFirstPage(){
        return page.isFirst();
    }

    public boolean isLastPage(){
        return page.isLast();
    }

    public boolean isHasPreviousPage(){
        return page.hasPrevious();
    }

    public boolean isHasNextPage(){
        return page.hasNext();
    }




}
