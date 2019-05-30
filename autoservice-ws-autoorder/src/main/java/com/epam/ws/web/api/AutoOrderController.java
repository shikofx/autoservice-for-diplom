package com.epam.ws.web.api;

import com.epam.ws.model.AutoOrder;
import com.epam.ws.service.AutoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class AutoOrderController extends BaseController {

    @Autowired
    private AutoOrderService autoOrderService;

    @RequestMapping(value = "api/autoOrders",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<AutoOrder>> getAutoOrders() {

        Collection<AutoOrder> autoOrders = autoOrderService.findAll();
        return new ResponseEntity<Collection<AutoOrder>>(autoOrders, HttpStatus.OK);
    }

    @RequestMapping(value = "api/autoOrders/{order_id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AutoOrder> getAutoOrder(
        @PathVariable("order_id")
            Long orderId) {

        AutoOrder autoOrder = autoOrderService.findOne(orderId);
        if (autoOrder == null) {
            return new ResponseEntity<AutoOrder>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<AutoOrder>(autoOrder, HttpStatus.OK);
    }

    @RequestMapping(value = "api/autoOrders",
        method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AutoOrder> createAutoOrder(
        @RequestBody
            AutoOrder autoOrder) {

        AutoOrder saveAutoOrder = autoOrderService.create(autoOrder);
        return new ResponseEntity<AutoOrder>(autoOrder, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/api/autoOrders/{order_id}",
        method = RequestMethod.PUT,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AutoOrder> updateAutoOrder(
        @RequestBody
            AutoOrder autoOrder) {

        AutoOrder updatedAutoOrder = autoOrderService.update(autoOrder);
        if (updatedAutoOrder == null) {
            return new ResponseEntity<AutoOrder>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<AutoOrder>(updatedAutoOrder, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/autoOrders/{order_id}",
        method = RequestMethod.DELETE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AutoOrder> deleteAutoOrder(
        @PathVariable("order_id")
            Long orderId) {

        autoOrderService.delete(orderId);

        return new ResponseEntity<AutoOrder>(HttpStatus.NO_CONTENT);
    }
}
