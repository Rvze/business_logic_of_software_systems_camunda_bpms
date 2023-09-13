package com.nmakarov.generalservice.service;

import com.nmakarov.generalservice.model.Item;
import com.nmakarov.generalservice.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class ItemService implements JavaDelegate {
    private final ItemRepository itemRepository;
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        long itemId = (long) delegateExecution.getVariable("item_id") ;

//        int pageNo = (int) delegateExecution.getVariable("page_no") ;
//        int pageSz = (int) delegateExecution.getVariable("page_sz") ;
//
//        String regexp = (String) delegateExecution.getVariable("regexp");



        try {
            Item itemToFind = getItemById(itemId) ;
            delegateExecution.setVariable("item", itemToFind);
        } catch (NoSuchElementException err) {
            System.out.println("no item");
            throw new BpmnError("no_item") ;
        }
    }

    private Item getItemById(Long id) throws NoSuchElementException {
        return itemRepository.findById(id).orElseThrow();
    }


    private RequestType defineRequestType(long itemId, int pageNo, int pageSz, String regexp) {
        if (itemId != 0) return RequestType.BY_ID ;
        if (Objects.equals(regexp, "")) return RequestType.ALL ;
        return RequestType.REGEXP ;
    }

    enum RequestType {
        BY_ID,
        REGEXP,
        ALL
    }
}
