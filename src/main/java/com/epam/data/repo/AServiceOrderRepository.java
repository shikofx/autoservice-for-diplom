package com.epam.data.repo;

import com.epam.controller.DatabaseController;
import com.epam.data.RequestToFindOrders;
import com.epam.domain.ServiceOrder;

import java.util.List;
import java.util.Set;

public class AServiceOrderRepository implements IAutoserviceRepository<ServiceOrder> {
    DatabaseController databaseController;

    public AServiceOrderRepository(DatabaseController databaseController) {
        this.databaseController = databaseController;
    }

    @Override
    public void add(ServiceOrder serviceOrder) {
        String parameters = serviceOrder.toString();
    }

    @Override
    public ServiceOrder find(ServiceOrder serviceOrder) {
        return null;
    }

    @Override
    public void delete(ServiceOrder serviceOrder) {

    }

    @Override
    public List<ServiceOrder> findAll() {
        return null;
    }

    public Set<ServiceOrder> getByRequest(RequestToFindOrders rtd) {
        return null;
    }

}
